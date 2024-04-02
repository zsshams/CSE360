package asuHelloWorldJavaFX;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
 
public class ASUHelloWorldJavaFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    //sets class variables total and billString for future use in bill calculations and display
    double total = 0;
	String billString = "			Bill:\n"; //Spacing is to center the "Bill" text within the bill window
    
    public void start(Stage primaryStage) {
    	
    	primaryStage.setTitle("Joe's Deli"); //sets title for window
    	
    	//sets overall title ('Joe's Deli')
    	Label title = new Label("Joe's Deli"); 
    	
    	//creates user immutable box for bill information, and sets its dimensions
    	TextArea billArea = new TextArea("			Bill:\n");
    	billArea.setEditable(false);
    	billArea.setMaxWidth(180);
    	billArea.setMaxHeight(170);
    	
    	//creates Order, Cancel, and Confirm buttons
        Button confirm = new Button("Confirm");
        Button cancel = new Button("Cancel");       
        Button order = new Button("Order");
        
        //creates Eat section with 'Eat' label and 4 checkboxes for the 4 food options
    	Label eat = new Label("Eat:");
        CheckBox eggSandwich = new CheckBox("Egg Sandwich");
        CheckBox chickenSandwich = new CheckBox("Chicken Sandwich");
        CheckBox bagel = new CheckBox("Bagel");
        CheckBox potatoSalad = new CheckBox("Potato Salad");
        
      //creates Drink section with 'Drink' label and 4 radio buttons within the same toggle group for the 4 drink options
    	Label drink = new Label("Drink:");
        ToggleGroup drinks = new ToggleGroup();
        RadioButton blackTea = new RadioButton("Black Tea");
        blackTea.setToggleGroup(drinks);
        RadioButton greenTea = new RadioButton("Green Tea");
        greenTea.setToggleGroup(drinks);
        RadioButton coffee = new RadioButton("Coffee");
        coffee.setToggleGroup(drinks);
        RadioButton orangeJuice = new RadioButton("Orange Juice");
        orangeJuice.setToggleGroup(drinks);
        
       
        //action performed if order button is selected - bill is presented with subtotal calculation
        order.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	//goes through each button to see if it is selected
            	//if the button is selected, its information is added to the billString and its price is added to the total
            	if (eggSandwich.isSelected()) {
            		billString += "Egg Sandwich: $7.99\n";
            		total += 7.99;
            				
            	}
            	if (chickenSandwich.isSelected()) {
            		billString += "Chicken Sandwich: $9.99\n";
            		total += 9.99;
            				
            	}
            	if (bagel.isSelected()) {
            		billString += "Bagel: $2.50\n";
            		total += 2.5;
            				
            	}
            	if (potatoSalad.isSelected()) {
            		billString += "Potato Salad: $4.49\n";
            		total += 4.49;
            				
            	}
            	if (blackTea.isSelected()) {
            		billString += "Black Tea: $1.25\n";
            		total += 1.25;
            				
            	}
            	if (greenTea.isSelected()) {
            		billString += "Green Tea: $0.99\n";
            		total += 0.99;
            				
            	}
            	if (coffee.isSelected()) {
            		billString += "Coffee: $1.99\n";
            		total += 1.99;
            				
            	}
            	if (orangeJuice.isSelected()) {
            		billString += "Orange Juice: $2.25\n";
            		total += 2.25;
            				
            	}
            	//Subtotal information is added to the billString
            	billString += "\nSubtotal: $"; 
            	billString += String.format("%.2f",total);
            	billString += "\n";
            	
            	//the bill textbox is edited with the new information
            	billArea.setText(billString);
                
            }
        });
        
      //action performed if cancel button is selected - everything is deselected and the bill information restarts
        cancel.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	
            	//total and billString are replaced back to 0 and default bill information
            	total = 0; 
            	billString = "			Bill:\n";
            	
            	//goes through each selection and deselects all of them
            	eggSandwich.setSelected(false);
            	chickenSandwich.setSelected(false);
            	bagel.setSelected(false);
            	potatoSalad.setSelected(false);
            	blackTea.setSelected(false);
            	greenTea.setSelected(false);
            	coffee.setSelected(false);
            	orangeJuice.setSelected(false);
            	
            	billArea.setText(billString); //edits bill textbox back to default
            }
        });
        
        //action performed if confirm button is selected - tax is added to the subtotal, final total is shown on the bill, everything deselected
        confirm.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	double tax = 0.07*total; //7% tax rate
            	total += tax;
            	
            	//tax and total information added to billString
            	billString += "Tax: $";
            	billString += String.format("%.2f",tax);
            	billString += "\n";
            	billString += "Total: $";
            	billString += String.format("%.2f",total);
            	billString += "\n";
            	
            	billArea.setText(billString); //bill textbox is updated
            	
            	//restart - total back to 0, billString back to default, and everything deselected
            	total = 0;
            	billString = "			Bill:\n";
            	eggSandwich.setSelected(false);
            	chickenSandwich.setSelected(false);
            	bagel.setSelected(false);
            	potatoSalad.setSelected(false);
            	blackTea.setSelected(false);
            	greenTea.setSelected(false);
            	coffee.setSelected(false);
            	orangeJuice.setSelected(false);
            	
                
            }
        });
        
        GridPane root = new GridPane(); //create GridPane layout
        
        root.setHgap(20); //horizontal gap of 20 to create space between objects
        root.setVgap(8);  //vertical gap of 8 to create space between objects
        
        root.add(title, 3, 0); //adds title to the top of the screen
        
        //creates layout for Eat section with appropriate label and options
        root.add(eat,1,1);
        root.add(eggSandwich,1, 2);
        root.add(chickenSandwich,1, 3);
        root.add(bagel,1, 4);
        root.add(potatoSalad,1, 5);
        
        //creates layout for Drink section with appropriate label and options
        root.add(drink,3,1);
        root.add(blackTea, 3, 2);
        root.add(greenTea, 3, 3);
        root.add(coffee, 3, 4);
        root.add(orangeJuice, 3, 5);
        
        //creates layout for buttons, placing them under the selections with the correct order horizontally
        root.add(confirm, 4, 8);
        root.add(cancel, 3,8);
        root.add(order, 1,8);
        
        //creates bill textbox, and spanning it by 4 rows and 7 columns to make it fir a good bit of the bill at once
        root.add(billArea, 4, 1, 4, 7);
        
        //creates the screen to a size of 600 by 400 pixels and displays
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}