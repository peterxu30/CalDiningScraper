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
	ArrayList<StringTuple> foodList;
	
	public FoodList(Element td) { //constructor
		foodType.put("#000000", "normal");
		foodType.put("#008000", "vegetarian");
		foodType.put("#800040", "vegan");

		foodList = new ArrayList<StringTuple>();

		Elements foods = td.select("a");

		for (Element food: foods) {
			foodList.add(new StringTuple(checkFoodType(food), food.text()));
		}
	}

	private String checkFoodType(Element food) { //takes in everything between <a>...</a>
		String font = food.select("font").attr("color");
		return foodType.get(font);
	}

	public String text() {
		String words = "";
		for (StringTuple food: foodList) {
			words = words + "\n" + food.head + ": " + food.tail;
		}
		if (words == "")
			return "Closed";
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