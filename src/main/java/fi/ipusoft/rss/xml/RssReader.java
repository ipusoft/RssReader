package fi.ipusoft.rss.xml;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import fi.ipusoft.rss.exceptions.RssApplicationException;
import fi.ipusoft.web.domain.Header;
import fi.ipusoft.web.domain.Item;

/**
 * Sax parser for RSS content. 
 * @author Isto
 *
 */
public class RssReader {

	public RssContent readRSS(String uri) {
		SyndFeedInput input = new SyndFeedInput();
		try {
			List<Item> itemList = new ArrayList<Item>();	  
			Header header = new Header();				
			SyndFeed feed = input.build(new XmlReader(new URL(uri)));
			header.setDescription(feed.getDescription());
			header.setLink(feed.getLink());
			header.setTitle(feed.getTitle());

			List<SyndEntry> entries = feed.getEntries();
		    for (SyndEntry entry: entries) {
		    	Item item = new Item();
		    	item.setTitle(entry.getTitle());
		    	item.setDescription(entry.getDescription().getValue());
		    	item.setPublishDate(entry.getPublishedDate());
		    	item.setLink(entry.getLink());
		    	itemList.add(item);
		    }		    
		  	return new RssContent(header, itemList);
		    
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new RssApplicationException("Unable to read RSS from the: " + uri);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RssApplicationException("Unable to read RSS from the: " + uri);
		} catch (FeedException e) {
			e.printStackTrace();
			throw new RssApplicationException("Cannot handle RSS feed");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RssApplicationException("Unable to read RSS from the: " + uri);
		}			
	
	}
}
