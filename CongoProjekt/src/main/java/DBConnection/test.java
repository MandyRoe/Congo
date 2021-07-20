package DBConnection;
import java.util.ArrayList;
import java.util.List;

import ServletPackage.*;

public class test {

	public static void main(String[] args) {
	
		List<Product> pl = new ArrayList<>();
		
		pl.add(new Product(1,"a","b","c",2));
		pl.add(new Product(3,"d","e","f",6));
		pl.add(new Product(7,"g","h","i",9));
		
	for(int i =0; i<pl.size(); i++)	{
	System.out.println(pl.get(i).getName().toString());
	}
	
	}

}
