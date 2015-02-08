import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 

//smallest data structure

public class FoodList {
	private HashMap<String, String> foodType = new HashMap<String, String>();
	private ArrayList<StringTuple> foodList;
	
	public FoodList(Element td) { //constructor
		foodType.put("#000000", "");
		foodType.put("#008000", "(vegetarian)");
		foodType.put("#800040", "(vegan)");

		foodList = new ArrayList<StringTuple>();

		Elements foods = td.select("a");

		for (Element food: foods) {
			foodList.add(new StringTuple(food.text(), checkFoodType(food)));
		}
	}

	private String checkFoodType(Element food) { //takes in everything between <a>...</a>
		String font = food.select("font").attr("color");
		return foodType.get(font);
	}

	public String text() {
		String words = "";
		for (StringTuple food: foodList) {
			words = words + "\n" + food.head + " " + food.tail;
		}
		if (words == "")
			return "Closed";
		words += "\n";
		return words;
	} 

	public String specificText(String type) { //sorts by normal, vegetarian, or vegan
		String words = "";
		String classification = "";
		if (type.equals("")) {
			return text();
		}
		else if (type.equals("vegan")) {
			classification = "(vegan)";
			words += "\nVegan:\n";
		}
		else if (type.equals("vegetarian")) {
			classification = "(vegetarian)";
			words += "\nVegetarian:\n";
		}
		for (StringTuple food: foodList) {
			if (classification.equals("(vegetarian)")) { //temporary hot fix. get rid of this if statement, it's bad form
				if (food.tail.equals(classification) || food.tail.equals("(vegan)")) {
					words = words + "\n" + food.head;
				}
			}
			else if (food.tail.equals(classification)) {
				words = words + "\n" + food.head;
			}
		}
		words += "\n";
		return words;
	}

	public class StringTuple {
		String head;
		String tail;

		private StringTuple(String head, String tail) {
			this.head = head;
			this.tail = tail;
		} 
	}

}