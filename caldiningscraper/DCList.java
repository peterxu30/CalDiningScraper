package caldiningscraper;

import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.LinkedHashMap; 

//intermediary data structure

public class DCList {
	private static String[] dcName = {"crossroads", "cafe_3", "foothill", "clark Kerr"};
	private HashMap<String, FoodList> dcList = new HashMap<String, FoodList>();
	private Elements columns;
	
	public DCList(Element row, int colNum) { //creates new DCList object
		columns = row.select("td");
		scrapeAll(colNum);		
	}

	/* Scrapes all the dining halls */
	private void scrapeAll(int colNum) {
		for (int i = 0; i <= (colNum-1); i++) { //fills in the array with Table Row elements. Also skips unecessary rows
		    String name = dcName[dc];
			Element column = columns.get(dc);
			dcList.put(name, new FoodList(column)); //associates a column to a dining hall
		}
	}

	/* Returns a FoodList object */
	public FoodList getFoodList(String dc) {
		return dcList.get(dc);
	}

	/* IN PROGRESS */
	String[] searchDC(String food) {
		String[] dc = new String[4]{false, false, false, false};
		int count = 0;
		for (FoodList fl : dcList.valueSet()) {
			if (fl.search(food)) {
				String[i] = true;
			}
			count += 1;
		}
		return dc;
	}
}
