import java.net.*;
import java.io.*;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 

// turning main method into a new data structure

// The data structure that the launcher will interact with.
public class MainFoodScraper {

	private MealList mealList;
	private Elements rows;

	public MainFoodScraper(String urlString, int tableNum, int rowNum, int startRow, int colNum) throws Exception {

		URL url = new URL(urlString); //dining hall menu url
		Document site = Jsoup.parse(url, 3000); 
		Element table = site.select("table").get(tableNum); //gets first table, the menu
		rows = table.select("tr"); //gets all table row elements

		mealList = new MealList(rows, rowNum, startRow, colNum); 

	}

	// In Progress. Experimental method. 
	public static String getDCMenuURL(int dc, Elements rows) throws Exception { //gets URLS for specific dining hall 0 - Crossroads, 1 - Cafe 3, 2 - Foothill, 3 - CKC
		Element halls = rows.get(10);
		return halls.select("a").get(dc).text();//filler text IN PROGRESS
	} 

	// Returns Menu as a String
	private String getMenuText(FoodList foodie, String diet) {
		return foodie.text(diet);
	}

	// Returns a menu filtered based on dietary restrictions for a specific meal at a specific dining hall.
	public String getMenu(String meal, String dc, String diet) {
		return getMenuText(mealList.getDCList(meal).getFoodList(dc), diet);
	}

	// Returns a menu for a specific meal at a specific dining hall.
	public String getMenu(String meal, String dc) { 
		return getMenu(meal, dc, "");
	}

	// Returns complete menu for a specific dining hall.
	public String getCompleteMenu(String dc) { 
		String text = "\n";
		text += "Breakfast:" + getMenu("breakfast", dc, "") + "\n";
		text += "Lunch:" + getMenu("lunch", dc, "") + "\n";
		text += "Dinner:" + getMenu("dinner", dc, "") + "\n";
		return text;
	}

	// Exists purely for testing purposes
	public static void main(String[] args) throws Exception { 
		MainFoodScraper new1 = new MainFoodScraper("http://services.housing.berkeley.edu/FoodPro/dining/static/todaysentrees.asp", 0, 3, 11, 4);

		String location = args[0]; //command line input
		if (args.length == 1) {
			System.out.println(new1.getCompleteMenu(meal));
		}
		else {
			String meal = args[1];
			if (args.length == 3) {
				String diet = args[2];
				System.out.println(new1.getMenu(meal, location, diet));
			}
			else {
				System.out.println(new1.getMenu(meal, location, ""));
			}
		}

	}

}