package Constructors;



class Document {
	String documentName;
	pages pages;
	
	public Document(String documentName,pages page){
		this.documentName=documentName;
		this.pages=page;
	}
	
	public Document(Document document) {
		this.documentName=document.documentName;
		this.pages=document.pages;
	}
	
	
	public Document(Document document,int flag) {
		if(flag==1) {
			this.documentName=document.documentName;
			this.pages=new pages(document.pages.pageContent,document.pages.pageNumber);
		}
	}

}
