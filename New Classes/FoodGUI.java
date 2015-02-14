import java.awt.*; 
import javax.swing.*;
import java.net.*;
import java.awt.event.*;

public class FoodGUI extends JFrame {
	
	@SuppressWarnings("unchecked")
	public static void createWindow() throws Exception {
		JFrame frame = new JFrame("Dining Hall Menu Finder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// FlowLayout flo = new FlowLayout();
        //Container pane = frame.getContentPane();
        //frame.setLayout(new GridLayout(5, 5));
        frame.setLayout(new FlowLayout());

		// JLabel textLabel = new JLabel("I'm a label in the window",SwingConstants.CENTER); 
		frame.setPreferredSize(new Dimension(500, 600));
		//frame.getContentPane().add(textLabel, BorderLayout.CENTER);

		JButton button = new JButton("Search");
        //JLabel label = new JLabel("Meal");
        JComboBox mealDrop = new JComboBox();
        mealDrop.addItem("breakfast");
        mealDrop.addItem("lunch");
        mealDrop.addItem("dinner");

        JComboBox dcDrop = new JComboBox();
        dcDrop.addItem("crossroads");
        dcDrop.addItem("cafe 3");
        dcDrop.addItem("foothill");
        dcDrop.addItem("clark kerr");

        JButton button2 = new JButton("Search");
        JLabel label2 = new JLabel("Dining Hall");
        JTextField field = new JTextField(10);
        JTextArea field1 = new JTextArea(new MainFoodScraper("http://services.housing.berkeley.edu/FoodPro/dining/static/todaysentrees.asp", 0, 3, 11, 4).getMenu("lunch", "foothill"));
	    
	    frame.add(mealDrop);
	    frame.add(dcDrop);
	    frame.add(field1);
      	frame.add(button);
      	
      	//frame.add(button2);
	    
      	//pane.add(label);

		//Display the window. 
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	//public static void 

	public static void main(String[] args) throws Exception {
		
		createWindow();

	}

}