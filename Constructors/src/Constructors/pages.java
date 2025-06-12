package Constructors;

class pages
{
	String pageContent;
	int pageNumber;
	public pages(String pageContent,int pageNumber) {
		this.pageContent=pageContent;
		this.pageNumber=pageNumber;
	}
	@Override
	public String toString() {
		return "pages [pageContent=" + pageContent + ", pageNumber=" + pageNumber + "]";
	}
	
}
