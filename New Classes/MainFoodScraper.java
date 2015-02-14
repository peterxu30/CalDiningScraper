import java.net.*;
import java.io.*;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 

//turning main method into a new data structure

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

	public static String getDCMenuURL(int dc, Elements rows) throws Exception { //gets URLS for specific dining hall 0 - Crossroads, 1 - Cafe 3, 2 - Foothill, 3 - CKC
		Element halls = rows.get(10);
		return halls.select("a").get(dc).text();//filler text IN PROGRESS
	} 

	public String getMenu(String meal, String dc) { //returns menu for specific meal for 1 DC
		return mealList.getDCList(meal).getFoodList(dc).text();
	}

	public String getMenu(String meal, String dc, String diet) { //returns menu for specific meal for 1 DC
		return mealList.getDCList(meal).getFoodList(dc).specificText(diet);
	}

	public String getDCMenu(String dc) { //all menus for a dining hall
		String text = "\n";
		text += "Breakfast:" + getMenu("breakfast", dc, "") + "\n";
		text += "Lunch:" + getMenu("lunch", dc, "") + "\n";
		text += "Dinner:" + getMenu("dinner", dc, "") + "\n";
		return text;
	}

	public static void main(String[] args) throws Exception { //exists purely for testing purposes
		MainFoodScraper new1 = new MainFoodScraper("http://services.housing.berkeley.edu/FoodPro/dining/static/todaysentrees.asp", 0, 3, 11, 4);

		String meal = args[0]; //command line input
		if (args.length == 1) {
			System.out.println(new1.getDCMenu(args[0]));
		}
		else {
			String location = args[1];
			if (args.length == 3) {
				String diet = args[2];
				System.out.println(new1.getMenu(meal, location, diet));
			}
			else {
				System.out.println(new1.getMenu(meal, location));
			}
		}

		//MainFoodScraper new1 = new MainFoodScraper("http://services.housing.berkeley.edu/FoodPro/dining/static/todaysentrees.asp", 0, 3, 11, 4);
		//System.out.println(new1.getMenu("Lunch", "Foothill", "vegan"));
		
		


		//System.out.println(getMenu(mealList, meal, location)); //works

		//System.out.println(getDCMenuURL("Foothill", rows)); //works

		




		//System.out.println(rowArray[1].text()); //test
	}


}