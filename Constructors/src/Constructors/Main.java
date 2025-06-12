package Constructors;

public class Main {
	public static void main(String args[]) {
		pages page=new pages("prologue",2);
		Document document=new Document("Murder on the orient Express",page);
		
		
		Document documentShallow=new Document(document);
		Document documentDeep=new Document(document,1);
		
		System.out.println(documentShallow.documentName+" "+documentShallow.pages);
		System.out.println(documentDeep.documentName+" "+documentDeep.pages);
		
		
	}

}
