package caldiningscraper;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.In;

public class CDSLauncher {
	
	public static void main(String[] args) throws Exception {
		MainFoodScraper menu = new MainFoodScraper("http://services.housing.berkeley.edu/FoodPro/dining/static/todaysentrees.asp", 0, 3, 11, 4);

		while(true) {
			System.out.print("> ");
			String line = StdIn.readLine();
			String[] rawTokens = line.split(" ");
			String command = rawTokens[0];
			String[] tokens = new String[rawTokens.length - 1];
			System.arraycopy(rawTokens, 1, tokens, 0, rawTokens.length - 1);
			switch (command) {
				case "quit":
					System.exit(0);
				/* IN PROGRESS */
				case "help":
					In helpIn = new In("ngordnet/help.txt");
                    String helpStr = helpIn.readAll();
                    System.out.println(helpStr);
                    break; 
                case "menu":
                	try {
	                	if (tokens.length == 0) {
	                		System.out.println(menu.getCompleteMenu());
	                	} else if (tokens.length == 1) {
	                		String dc = tokens[0];
	                		System.out.println(menu.getDCMenu(dc));
	                	} else if (tokens.length == 2) {
	                		String dc = tokens[0];
	                		String time = tokens[1];
	                		System.out.println(menu.getMenu(time, dc));
	                	} else if (tokens.length == 3) {
	                		String dc = tokens[0];
	                		String time = tokens[1];
	                		String diet = tokens[2];
	                		System.out.println(menu.getMenu(time, dc, diet));
	                	}
	                	break;
	                } catch (IllegalArgumentException e) {
                        System.out.println("Invalid menu input.");
                    }
                case "search":
                	System.out.println("In progress.");
                	break;
               	default:
                    System.out.println("Invalid command.");  
                    break;
			}
		}
	}
}