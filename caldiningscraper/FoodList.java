package caldiningscraper;

import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.LinkedHashMap; 

/* Smallest data structure
 * Stores the menu for a specific meal at a specific dining hall. */

public class FoodList {
	private HashMap<String, String> foodType = new HashMap<String, String>();
	private LinkedHashMap<String, String> foodList = new LinkedHashMap<String, String>();
	
	/* Creates a new foodlist. */
	public FoodList(Element td) { //constructor
		foodType.put("#000000", "");
		foodType.put("#008000", "(vegetarian)");
		foodType.put("#800040", "(vegan)");
		foodType.put("#800000", "(vegan)");
		Elements foods = td.select("a");
		for (Element food: foods) {
			// foodList.add(new StringTuple(food.text(), checkFoodType(food)));
			foodList.put(food.text(), checkFoodType(food));
		}
	}

	/* Checks if a food item falls under any dietary resctrictions. (e.g. vegetarian/vegan) */
	private String checkFoodType(Element food) { //takes in everything between <a>...</a>
		String font = food.select("font").attr("color");
		return foodType.get(font);
	}

	/* Returns entire menu, ignoring type of food. */
	private String basic_text() {
		String words = "";
		if (foodList.keySet().isEmpty()) {
			return "Closed\n";
		} else {
			for (Entry food : foodList.entrySet()) {
				words = words + "\n" + food.getKey() + " " + food.getValue();
			}
			words += "\n";
		}
		return words;	
	} 

	/* Returns specialized menu regarding type of food. */
	public String text(String type) { //sorts by normal, vegetarian, or vegan
		String words = "";
		String classification = "";
		if (type.equals("")) {
			return basic_text();
		} else if (type.equals("vegan")) {
			classification = "(vegan)";
			words += "\nVegan:\n";
		} else if (type.equals("vegetarian")) {
			classification = "(vegetarian)";
			words += "\nVegetarian:\n";
		}
		for (Entry food: foodList.entrySet()) {
			if (classification.equals("(vegetarian)")) {
				if (classification.equals(food.getValue()) || "(vegan)".equals(food.getValue())) {
					words = words + "\n" + food.getKey();
				}
			} else if (classification.equals(food.getValue())) {
				words = words + "\n" + food.getKey();
			}
		}
		words += "\n";
		return words;
	}

	/* Checks if a food item is available today */
	public boolean search(String food) {
		return foodList.containsKey(food);
	}
}
