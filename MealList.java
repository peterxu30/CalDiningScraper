import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap;

//largest data structure

public class MealList {
	private String[] mealName = {"breakfast", "lunch", "dinner"};
	private HashMap<String, DCList> mealList = new HashMap<String, DCList>();
	
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

}