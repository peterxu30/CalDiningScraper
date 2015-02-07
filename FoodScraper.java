import java.net.*;
import java.io.*;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 

public class FoodScraper {
	MealList test;

	public static String getDCMenuURL(String diningCommon, Elements rows) throws Exception { //gets URLS for specific dining hall
		Element halls = rows.get(10);
		return halls.text();//filler text
	} 

	public static String getMenu(MealList x, String meal, String dc) { //returns menu for specific meal for 1 DC
		return x.getDCList(meal).getFoodList(dc).text();
	}

	public static void main(String[] args) throws Exception { //change to non-main method later
		String meal = args[0]; //command line input
		String location = args[1];

		URL url = new URL("http://services.housing.berkeley.edu/FoodPro/dining/static/todaysentrees.asp"); //dining hall menu url
		Document site = Jsoup.parse(url, 3000); 
		Element table = site.select("table").get(0); //gets first table, the menu
		Elements rows = table.select("tr"); //gets all table row elements

		MealList mealList = new MealList(rows); //hashtable for 3 meals

		System.out.println(getMenu(mealList, meal, location)); //works

		//System.out.println(getDCMenuURL("Foothill", rows)); //works

		




		//System.out.println(rowArray[1].text()); //test
	}


}