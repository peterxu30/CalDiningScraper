package caldiningscraper;

import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.LinkedHashMap;

//largest data structure

public class MealList {
	private static String[] mealName = {"breakfast", "lunch", "dinner"};
	private LinkedHashMap<String, DCList> mealList = new LinkedHashMap<String, DCList>();
	
	public MealList(Elements rows, int rowNum, int startRow, int colNum) { //creates new FoodList object

		for (int i = 0; i <= (rowNum - 1); i++) { //fills in the array with Table Row elements. Also skips unecessary rows
		    //mealList.put(mealName[i], rows.get(i+11));
		    addDCList(mealName[i], rows.get(i+startRow), colNum);
		}
	}

	public void addDCList(String mealName, Element row, int colNum) {
		mealList.put(mealName, new DCList(row, colNum));
	}

	public DCList getDCList(String meal) {
		return mealList.get(meal);
	}

	/* IN PROGRESS */
	boolean[][] searchMeal(String food) {
		boolean[][] meals = new boolean[3][];
		// for (int i = 0; i <= 3; i++) {
		// 	meals[i] = new String[4];
		// }
		int count = 0;
		for (DCList dcl : mealList.values()) {
			meals[count] = dcl.searchDC(food);
			count += 1;
		}
		return meals;
	}
}
