import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 

//intermediary data structure

public class DCList {
	private String[] dcName = {"Crossroads", "Cafe_3", "Foothill", "Clark Kerr"};
	private HashMap<String, FoodList> dcList = new HashMap<String, FoodList>();
	
	public DCList(Element row, int colNum) { //creates new DCList object
		
		Elements columns = row.select("td");

		for (int i = 0; i <= (colNum-1); i++) { //fills in the array with Table Row elements. Also skips unecessary rows
		    addFoodList(dcName[i], columns.get(i)); //associates a column to a dining hall
		}
	}

	public void addFoodList(String mealName, Element column) {
		dcList.put(mealName, new FoodList(column));
	}

	public FoodList getFoodList(String dc) {
		return dcList.get(dc);
	}



}