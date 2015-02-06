import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap;

//largest data structure

public class MealList {
	private String[] mealName = {"Breakfast", "Lunch", "Dinner"};
	private HashMap<String, Element> mealList = new HashMap<String, Element>();
	
	public MealList(Elements rows) { //creates new FoodList object

		for (int i = 0; i <= 2; i++) { //fills in the array with Table Row elements. Also skips unecessary rows
		    mealList.put(mealName[i], rows.get(i+11));
		}
	}

	public Element getMeal(String meal) {
		return mealList.get(meal);
	}

}