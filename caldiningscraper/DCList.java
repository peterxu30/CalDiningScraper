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
	private static String[] dcName = {"crossroads", "cafe_3", "foothill", "clark kerr"};
	private LinkedHashMap<String, FoodList> dcList = new LinkedHashMap<String, FoodList>();
	private Elements columns;
	
	public DCList(Element row, int colNum) { //creates new DCList object
		columns = row.select("td");
		scrapeAll(colNum);		
	}

	/* Scrapes all the dining halls */
	private void scrapeAll(int colNum) {
		for (int i = 0; i <= (colNum-1); i++) { //fills in the array with Table Row elements. Also skips unecessary rows
		    String name = dcName[i];
			Element column = columns.get(i);
			dcList.put(name, new FoodList(column)); //associates a column to a dining hall
		}
	}

	/* Returns a FoodList object */
	public FoodList getFoodList(String dc) {
		return dcList.get(dc);
	}

	/* IN PROGRESS */
	boolean[] searchDC(String food) {
		boolean[] dc = new boolean[]{false, false, false, false};
		int count = 0;
		for (FoodList fl : dcList.values()) {
			if (fl.search(food)) {
				dc[count] = true;
			}
			count += 1;
		}
		return dc;
	}
}
