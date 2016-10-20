package entity;

public class book {
	private int ISBN;
	private String Title;
	private int AuthorID;
	private String Publisher;
	private String PublishDate;
	private int  Price;
	
	public book(){
		
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public book(int iSBN, String title, int authorID, String publisher,
			String publishDate, int price) {
		//super();
		ISBN = iSBN;
		Title = title;
		AuthorID = authorID;
		Publisher = publisher;
		PublishDate = publishDate;
		Price = price;
	}

	@Override
	public String toString() {
		return "book [ISBN=" + ISBN + ", Title=" + Title + ", AuthorID="
				+ AuthorID + ", Publisher=" + Publisher + ", PublishDate="
				+ PublishDate + ", Price=" + Price + "]";
	}
	
	
	
	
}
