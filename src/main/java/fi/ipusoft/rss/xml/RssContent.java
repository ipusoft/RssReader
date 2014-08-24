package fi.ipusoft.rss.xml;

import java.util.List;

import fi.ipusoft.web.domain.Header;
import fi.ipusoft.web.domain.Item;

/**
 * RSS content object which contains header and usually several items.
 * @author Isto
 *
 */
public class RssContent {
	
	private Header header;
	private List<Item> items;
	
	public RssContent(Header header, List<Item> items) {
		this.header = header;
		this.items = items;		
	}
	
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}


	

	
}
