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
	/*private URL url = new URL("http://services.housing.berkeley.edu/FoodPro/dining/static/todaysentrees.asp"); //dining hall menu url
	private Document site = Jsoup.parse(url, 3000); 
	private Element table = site.select("table").get(0); //gets first table, the menu
	private Elements rows = table.select("tr"); //gets three rows for three meal times*/

	public static void main(String[] args) throws Exception { //change to non-main method later
		URL url = new URL("http://services.housing.berkeley.edu/FoodPro/dining/static/todaysentrees.asp"); //dining hall menu url
		Document site = Jsoup.parse(url, 3000); 
		Element table = site.select("table").get(0); //gets first table, the menu
		Elements rows = table.select("tr"); //gets three rows for three meal times

		MealList mealList = new MealList(rows); //hashtable for 3 meals

		System.out.println(mealList.getMeal("Breakfast")); //works

		




		//System.out.println(rowArray[1].text()); //test
	}


}