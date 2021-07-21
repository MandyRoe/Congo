package ServletPackage;


public class Product {
	
	
	private int itmnbr;
	private String name;
	private String img64;
	private String descr;
	private float price;
	private int amount;
	

	public Product(int itmnbr, String name, String img64, String descr, float price, int amount) {
		super();
		this.itmnbr = itmnbr;
		this.name = name;
		this.img64 = img64;
		this.descr = descr;
		this.price = price;
		this.amount =amount;
	}

	public Product(int itmnbr, String name, String img64, String descr, float price) {
		super();
		this.itmnbr = itmnbr;
		this.name = name;
		this.img64 = img64;
		this.descr = descr;
		this.price = price;
	}

	
	


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setItmnbr(int itmnbr) {
		this.itmnbr = itmnbr;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getItmnbr() {
		return itmnbr;
	}
	public void setID(int itmnbr) {
		this.itmnbr = itmnbr;
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

	