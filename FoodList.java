import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 

//smallest data structure

public class FoodList {
	private String[] foodType = {"", "vegetarian", "vegan"};
	private HashMap<String, String> foodType = new HashMap<String, String>();
	foodType.put("#000000", "");
	foodType.put("#008000", "vegetarian");
	foodType.put("#800040", "vegan");
	
	public FoodList(Elements td) { //constructor
		ArrayList<StringTuple> foodList = new ArrayList<StringTuple>();

		Elements foods = td.select("a");

		for (Element food: foods) {
			foodList.add(new Tuple(checkFoodType(food)), food.text());
		}
	}

	private String checkFoodType(Element food) { //takes in everything between <a>...</a>
		String font = food.select("font").attr("color");
		return foodType(font);
	}

	public class StringTuple {
		String head;
		String tail;

		private Tuple(String head, String tail) {
			this.head = head;
			this.tail = tail;
		} 
	}

}