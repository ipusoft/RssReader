package fi.ipusoft.rss.xml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fi.ipusoft.web.domain.Header;
import fi.ipusoft.web.domain.Item;

/**
 * Combines RSS contents as a group.
 * @author Isto
 *
 */
public class CombinedRssContent {
	
	public List<Header> contentHeaders = new ArrayList<Header>();
	private List<Item> combainedItems = new ArrayList<Item>();

	public CombinedRssContent() {
		
	}
	
	 /**
	  * Reload RSS contents.	
	  * @param content
	  */
	public void reloadContents(List<RssContent> contents) {
		this.contentHeaders.clear();
		this.combainedItems.clear();
		for (RssContent content: contents) {
			this.combainedItems.addAll(content.getItems());
			this.contentHeaders.add(content.getHeader());
		}
		Collections.sort(this.combainedItems);
	}
		
	/**
	 * Get combined rss items sorted by publication date.
	 * @return
	 */
	public List<Item> getRssItems() {
		return this.combainedItems;
	}
	
	/**
	 * Get combined rss items sorted by publication date.
	 * @return
	 */
	public List<Header> getRssHeaders() {
		return this.contentHeaders;
	}

	
}
