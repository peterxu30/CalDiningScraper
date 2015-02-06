import org.jsoup.Jsoup;
//import htmlunit.*;
//import com.gargoylesoftware.htmlunit.html.HtmlPage;
//import com.gargoylesoftware.htmlunit.html.HtmlTextInput;


public class Reader {

	public static void main(String[] args) {
		WebClient webClient = new WebClient();
		HtmlPage currentPage = webClient.getPage(
			"http://services.housing.berkeley.edu/FoodPro/dining/static/todaysentrees.asp");

		final HtmlTable table = currentPage.getElementByName("TABLE");
		for (final HtmlTableRow row : table.getRows()) {
			System.out.println("Found row");
			for (final HtmlTableCell cell : row.getCells()) {
				System.out.println("   Found cell: " + cell.asText());
			}
		}
	}

}