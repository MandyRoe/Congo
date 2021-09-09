package model;



public class Product {

	private int itmnbr;
	private String name;
	private String image;
	private String descr;
	private String category;

	private float price;


	public Product() {

	}

	public Product(int itmnbr, String name, String image, String descr, String category, float price) {
		super();
		this.itmnbr = itmnbr;
		this.name = name;
		this.image = image;
		this.descr = descr;
		this.category = category;
		this.price = price;
		
	}
	
	
	

	public int getItmnbr() {
		return itmnbr;
	}

	public void setItmnbr(int itmnbr) {
		this.itmnbr = itmnbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float p) {
		this.price = p;
	}



	@Override
	public String toString() {
		return "Product [itmnbr=" + itmnbr + ", name=" + name + ", image=" + image + ", descr=" + descr + ", category="
				+ category + ", price=" + price + "]";
	}



}
