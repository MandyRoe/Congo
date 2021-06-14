package ServletPackage;
//simples Userobjekt was mit Usermanager gefüllt wird aus SQL --> Usermanager soll es dann wd an dass Servlet zurück geben damit das Objekt angezeigt werden kann
public class User {
	private int ID;
	private String name;
	private String email;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String Email) {
		this.email = Email;
	}
	

	public User(int iD, String name, String email) {
		super();
		ID = iD;
		this.name = name;
		this.email = email;
	}
	
}