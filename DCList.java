import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 

//intermediary data structure

public class DCList {
	private String[] dcName = {"crossroads", "cafe_3", "foothill", "clark Kerr"};
	private HashMap<String, FoodList> dcList = new HashMap<String, FoodList>();
	private Elements columns;
	
	public DCList(Element row, int colNum) { //creates new DCList object
		
		columns = row.select("td");

		scrapeAll(colNum);		
	}

	private void scrapeDC(int dc) { //scrapes one dc
		String dcName = dcName[dc];
		Element column = columns.get(dc);
		dcList.put(dcName, new FoodList(column));
	}

	private void scrapeAll(int colNum) {
		for (int i = 0; i <= (colNum-1); i++) { //fills in the array with Table Row elements. Also skips unecessary rows
		    scrapeDC(i); //associates a column to a dining hall
		}
	}

	public FoodList getFoodList(String dc) {
		return dcList.get(dc);
	}

}