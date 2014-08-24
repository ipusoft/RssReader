package fi.ipusoft.web.domain;

import java.util.Date;

/**
 * RSS items's values to be shown on the web page.
 * @author Isto
 *
 */
public class Item implements Comparable<Item> {
	
	private String title;
	private String link;
	private String description;
	private Date publishDate;		

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	
	@Override
	/**
	 * Items are shown published date order.
	 */
	public int compareTo(Item another) {
		if (this.getPublishDate() == null && another.getPublishDate() == null) {
			return 0;
		}
		if (this.getPublishDate() == null && another.getPublishDate() != null) {
			return -1;
		}
		if (this.getPublishDate() != null && another.getPublishDate() == null) {
			return 1;
		}		
		return this.getPublishDate().compareTo(another.getPublishDate()) * -1; //* -1 = the newest one first.
	}

}
