package ServletPackage;

import java.sql.Blob;

//simples Userobjekt was mit Usermanager gefüllt wird aus SQL --> Usermanager soll es dann wd an dass Servlet zurück geben damit das Objekt angezeigt werden kann
public class User {
	private int ID;
	private String name;
	private String email;
	private String img64;
	

	public User(int iD, String name, String email, String img64) {
		super();
		ID = iD;
		this.name = name;
		this.email = email;
		this.img64 = img64;
	}
	

	public int getID() {
		return ID;
	}
	

	
	
	public String getImg64() {
		return img64;
	}

	public void setImg64(String img64) {
		this.img64 = img64;
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
	
}

	