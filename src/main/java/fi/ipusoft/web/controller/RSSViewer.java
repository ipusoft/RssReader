package fi.ipusoft.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fi.ipusoft.rss.exceptions.RssApplicationException;
import fi.ipusoft.rss.xml.CombinedRssContent;
import fi.ipusoft.rss.xml.RssContent;
import fi.ipusoft.rss.xml.RssReader;
 
@Controller
public class RSSViewer {
 
	private static CombinedRssContent combinedRssContent = new CombinedRssContent();
	private static RssReader rssReader = new RssReader();
	
	/**
	 * Reloads RSS feeds
	 */
	private void reloadRSS() {
		
		List<RssContent> contents = new ArrayList<RssContent>();
		contents.add(rssReader.readRSS("http://rss.kauppalehti.fi/rss/luetuimmat.jsp"));
		contents.add(rssReader.readRSS("http://rss.kauppalehti.fi/rss/yritysuutiset.jsp"));
		contents.add(rssReader.readRSS("http://rss.kauppalehti.fi/rss/startup.jsp"));
		contents.add(rssReader.readRSS("http://rss.kauppalehti.fi/rss/omaraha.jsp"));
		synchronized (combinedRssContent) {
			combinedRssContent.reloadContents(contents);
		}		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/rssload")
	public String reload(ModelMap model) {
		try {
			reloadRSS();
		} catch (RssApplicationException ex) {
			model.addAttribute("errorMessage", ex.getMessage());		
		}
		return "redirect:rss";		 
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/rss")
	public String open(ModelMap model) {

		if (combinedRssContent.getRssHeaders().size() == 0) {
			//Create RSS content at the first time...
			try {
				reloadRSS();
			} catch (RssApplicationException ex) {
				model.addAttribute("errorMessage", ex.getMessage());		
			}
		}
		model.addAttribute("rssheaders", combinedRssContent.getRssHeaders());		
		model.addAttribute("rssitems", combinedRssContent.getRssItems());
		return "rssView";
 
	}
 	
 
}

