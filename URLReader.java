import java.net.*;
import java.io.*;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class URLReader {

    public static void main(String[] args) throws Exception {
		File file = new File("test.txt");
		file.createNewFile();
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		

		URL url = new URL("http://services.housing.berkeley.edu/FoodPro/dining/static/todaysentrees.asp");
		Document site = Jsoup.parse(url, 3000);
    	Element table = site.select("table").get(0); //gets first table, the menu
		Elements rows = table.select("tr");
		
		Element row1 = rows.get(11);
		Element col = row1.select("td").get(0);
		System.out.println(col.text());
		String[] items = row1.text().split("\\s+");
		for (String item: items) {
			if (item == "Breakfast") {
				System.out.println("\n");
			}
			System.out.println(item);
		}
		//System.out.println(row1.text());

		/*for (int i = 11; i < rows.size(); i++) { //skips unecessary rows
		    Element row = rows.get(i);
		    System.out.println(row.text() + "\n");
		    bw.write(row.text() + "\n");
		}
		bw.close();

    	
    	/*UIManager.put("swing.boldMetal", Boolean.FALSE);
    	JFrame f = new JFrame("Print UI Example");
    	f.pack();
    	f.setVisible(true); EXPERIMENTING*/
    }  

}