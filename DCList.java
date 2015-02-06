import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 

//intermediary data structure

public class DCList {
	private String[] dcName = {"Crossroads", "Cafe 3", "Foothill", "Clark Kerr"};
	private HashMap<String, Element> dcList = new HashMap<String, Element>();
	
	public DCList(Element row) { //creates new DCList object
		
		Elements columns = row.select("td");

		for (int i = 0; i <= 3; i++) { //fills in the array with Table Row elements. Also skips unecessary rows
		    dcList.put(dcName[i], columns.get(i)); //associates a column to a dining hall
		}
	}

	public Element getDC(String dc) {
		return mealList.get(dc);
	}

}