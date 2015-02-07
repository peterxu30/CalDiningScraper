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

public class FoodScraper {
	//private String urlString; //url = url of site 
	//private int tableNum; //tableNum = which table on page is desired
	//private int rowNum; // rowNum = number of rows being scraped
	private int startRow; // startRow = which row to start scraping
	private int colNum; // colNum = number of columns per row
	private MealList mealList;

	public FoodScraper(String urlString, int tableNum, int rowNum, int startRow, int colNum) throws Exception {
		//this.rowNum = rowNum;
		this.startRow = startRow;
		this.colNum = colNum;

		URL url = new URL(urlString); //dining hall menu url
		Document site = Jsoup.parse(url, 3000); 
		Element table = site.select("table").get(tableNum); //gets first table, the menu
		Elements rows = table.select("tr"); //gets all table row elements

		mealList = new MealList(rows, rowNum, startRow, colNum); 

	}

	public static String getDCMenuURL(String diningCommon, Elements rows) throws Exception { //gets URLS for specific dining hall
		Element halls = rows.get(10);
		return halls.text();//filler text IN PROGRESS
	} 

	public String getMenu(String meal, String dc) { //returns menu for specific meal for 1 DC
		return mealList.getDCList(meal).getFoodList(dc).text();
	}

	public static void main(String[] args) throws Exception { //change to non-main method later
		FoodScraper new1 = new FoodScraper("http://services.housing.berkeley.edu/FoodPro/dining/static/todaysentrees.asp", 0, 3, 11, 4);
		System.out.println(new1.getMenu("Lunch", "Foothill"));
		//String meal = args[0]; //command line input
		//String location = args[1];


		//System.out.println(getMenu(mealList, meal, location)); //works

		//System.out.println(getDCMenuURL("Foothill", rows)); //works

		




		//System.out.println(rowArray[1].text()); //test
	}


}