package fi.ipusoft.web.domain;

/**
 * RSS header's values to be shown on the web page.
 * @author Isto
 *
 */
public class Header {

	private String title;
    private String description;
	private String link; 
    
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
