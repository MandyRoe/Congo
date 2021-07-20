package DBConnection;

import java.util.ArrayList;
import java.util.List;

import ServletPackage.Product;

public class listTest {                 //static funktionen




	Product test = new Product(1, "a", "b", "c", 3);
	Product bla = new Product(1, "a", "b", "c", 3);
	
	
	
	List<Product> productList = new ArrayList<>();
	
	productList.add(test);       //befehl zum hinzufügen (wird hinten dran gehangen)
	
	productList.add(bla) ;    //wird eingefügt, einträge davor werden eine position nach hinten verschoben 
	
	productList.add(1, test);
	
	
	  //arraylist.addAll(arralylist) = 
	//arraylist.get(x) = abruf spezifischer position
	//arraylist.size() = größe array
	//arraylist.set(x, y) = setzen  eines wertes y an stelle x
//arraylist.isEmpty() = true oder false falls leer
//arraylist.remove(x) = remove wert an stelle x
//boolean isRemoved = arraylist.remove(y)  ==> löscht ersten eintrag
//arraylist.removeAll = löscht alles aus einer collection               
//arraylist.clear = löscht einträge aus liste


//for each geht arraylist durch
arraylist.forEach(i -> {
System.out.println(i);});



//Check if an ArrayList contains a given element
System.out.println("Does names array contain \"Bob\"? : " + names.contains("Bob"));       //true false output

//Find the index of the first occurrence of an element in an ArrayList
System.out.println("indexOf \"Steve\": " + names.indexOf("Steve"));
System.out.println("indexOf \"Mark\": " + names.indexOf("Mark"));

//Find the index of the last occurrence of an element in an ArrayList
System.out.println("lastIndexOf \"John\" : " + names.lastIndexOf("John"));
System.out.println("lastIndexOf \"Bill\" : " + names.lastIndexOf("Bill"));


}