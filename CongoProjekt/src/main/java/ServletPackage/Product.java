package ServletPackage;


public class Product {
	private int ID;
	private String name;
	private String img64;
	private String descr;
	private float price;
	

	public Product(int iD, String name, String img64, String descr, float price) {
		super();
		ID = iD;
		this.name = name;
		this.img64 = img64;
		this.descr = descr;
		this.price = price;
	}

	

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
	public String getImg64() {
		return img64;
	}
	public void setImg64(String img64) {
		this.img64 = img64;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	
}

	