	package userInterface;



import java.util.StringTokenizer;

import customExceptions.TooLargeNumber;
import customExceptions.WrongNumberEntry;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.MagicSquare;

public class squareController {
	
    @FXML
    private BorderPane borderPane;
	
    @FXML
    private TextField textOrder;
    
    @FXML
    private TilePane tilePane;
    
    @FXML
    private Label labelSelect;
    
    @FXML
    private Button buttonFill;
    
    /**
     * relationship with MagicSquare to get the square to fill
     */
    private MagicSquare square;
    
    /**
		<b>Description:</b>
		* this method initialize the model object
   
     */
    public void initialize() {
    	
    	square = new MagicSquare(0);
    	
    }
    
    /**
		<b>Description:</b>
	     * generates the square according the order choose by user for the user to choose the first position and the direction, but does not fill the magic square.
	     *
	     *<b>pre:</b> the square relationship has already been inicializated.
	     *
	     * @param event
	     * 
     */
    @FXML
    void generateSquare(ActionEvent event) {
    	
    	try {
    	
	    	tilePane.getChildren().clear();
	    	borderPane.setRight(null);
	    	buttonFill.setDisable(true);
	    	int order = Integer.parseInt(textOrder.getText());
	    	
	    	boolean up;
	    	boolean down;
	    	boolean left;
	    	boolean right;
	    	
	    	// these buttons are the first position that the user can choose
	    	Button buttonUp =  new Button("1");
	    	Button buttonLeft =  new Button("1");
	    	Button buttonDown =  new Button("1");
	    	Button buttonRight =  new Button("1");
	    	
			buttonUp.setPrefHeight(40);
			buttonUp.setPrefWidth(60);
			buttonLeft.setPrefHeight(40);
			buttonLeft.setPrefWidth(60);
			buttonDown.setPrefHeight(40);
			buttonDown.setPrefWidth(60);
			buttonRight.setPrefHeight(40);
			buttonRight.setPrefWidth(60);
	    	   	
	    	tilePane.getChildren().clear();
	    	square.setOrder(order);
	    	GridPane panel = new GridPane();
	    	
	    	// these two for are responsible for creating the square using a GridPane
	    	for(int i=0; i< square.getOrder(); i++) {
	    		
	    		for(int j=0; j<square.getOrder(); j++) {
	    			TextArea t = new TextArea();
	    			
	    			 up = i == 0 && j == (square.getOrder() /2);
	    			 down = i == square.getOrder()-1 && j == (square.getOrder() /2);
	    			 left = i == square.getOrder() /2 && j == 0;
	    			 right = i == square.getOrder() /2 && j == square.getOrder()-1;
	    		
	    			if(up || down || left || right) {
	    				
	    				if(up)
	    					panel.add(buttonUp, j, i);
	    				else if(left)
	    					panel.add(buttonLeft, j, i);
	    				else if(down)
	    					panel.add(buttonDown, j, i);
	    				else
	    					panel.add(buttonRight, j, i);
	    					
	    			}
	    			else {
	    				t.setEditable(false);
	    				panel.add(t, j, i);
	    			}
	    			
	    			
	    		}
	    	}
	    	
	    	panel.setAlignment(Pos.CENTER);
	    	panel.setPrefHeight(15);
	    	panel.setPrefWidth(15);
	    	labelSelect.setText("select the place where you want to start");
	    	labelSelect.setVisible(true); 	
	    	tilePane.getChildren().add(panel);
	    	   	
	    	
	    	
	    	buttonUp.setOnAction(new EventHandler<ActionEvent>() {
	
				@Override
				public void handle(ActionEvent event) {
					
					buttonLeft.setDisable(true);
					buttonDown.setDisable(true);
					buttonRight.setDisable(true);
					buttonFill.setDisable(false);
					
					labelSelect.setText("choose the direction in which the magic square will be filled");
					
					ComboBox<String>  box =  new ComboBox<String>();
			    	box.setPromptText("choose a direction");
			    	box.setPrefHeight(50);
			    	box.setPrefWidth(150);
					
					box.setPromptText("Choose a direction");
					box.getItems().add("northwest");
					box.getItems().add("northeast");
					borderPane.setRight(box);
					borderPane.setAlignment(box, Pos.CENTER);
					
					
					square.setFirstPosition(MagicSquare.UP);
					
				}
	    	});
	    	buttonLeft.setOnAction(new EventHandler<ActionEvent>() {
	
				@Override
				public void handle(ActionEvent event) {
					
					buttonUp.setDisable(true);
					buttonDown.setDisable(true);
					buttonRight.setDisable(true);
					
					buttonFill.setDisable(false);
					
					labelSelect.setText("choose the direction in which the magic square will be filled");
					
					ComboBox<String>  box =  new ComboBox<String>();
			    	box.setPromptText("choose a direction");
			    	box.setPrefHeight(50);
			    	box.setPrefWidth(150);
					
					box.getItems().add("northwest");
					box.getItems().add("southwest");
					
					borderPane.setRight(box);
					borderPane.setAlignment(box, Pos.CENTER);
					
					square.setFirstPosition(MagicSquare.LEFT);
				}
	    	});
	    	buttonDown.setOnAction(new EventHandler<ActionEvent>() {
	
				@Override
				public void handle(ActionEvent event) {
					buttonLeft.setDisable(true);
					buttonUp.setDisable(true);
					buttonRight.setDisable(true);
					
					buttonFill.setDisable(false);
					
					labelSelect.setText("choose the direction in which the magic square will be filled");
					
					ComboBox<String>  box =  new ComboBox<String>();
			    	box.setPromptText("choose a direction");
			    	box.setPrefHeight(50);
			    	box.setPrefWidth(150);
					
					box.getItems().add("southwest");
					box.getItems().add("southeast");
					
					borderPane.setRight(box);
					borderPane.setAlignment(box, Pos.CENTER);
					
					square.setFirstPosition(MagicSquare.DOWN);
				}
	    	});
	    	buttonRight.setOnAction(new EventHandler<ActionEvent>() {
	
				@Override
				public void handle(ActionEvent event) {
					buttonLeft.setDisable(true);
					buttonDown.setDisable(true);
					buttonUp.setDisable(true);
					
					buttonFill.setDisable(false);
					
					labelSelect.setText("choose the direction in which the magic square will be filled");
					
					ComboBox<String>  box =  new ComboBox<String>();
			    	box.setPromptText("choose a direction");
			    	box.setPrefHeight(50);
			    	box.setPrefWidth(150);
					
					box.getItems().add("northeast");
					box.getItems().add("southeast");
					
					borderPane.setRight(box);
					borderPane.setAlignment(box, Pos.CENTER);
					
					square.setFirstPosition(MagicSquare.RIGHT);
				}
	    	});
	    
	    	
    }catch(NumberFormatException n) {
    	labelSelect.setVisible(true);
    	labelSelect.setText("insert a odd number");
    }catch(WrongNumberEntry w) {
    	labelSelect.setVisible(true);
    	labelSelect.setText("the square can´t generated, because " + w.getMessage());
    } catch (TooLargeNumber t) {
    	labelSelect.setVisible(true);
    	labelSelect.setText("the square can´t generated, because " + t.getMessage());
	}catch(NegativeArraySizeException ne) {
		labelSelect.setVisible(true);
    	labelSelect.setText("the square can´t generated, because the number entered is negative");
	}
    } 
    
    /**
	<b>Description:</b>
     * fill the square according to the direction and first position chosen by the user
     *
     *<b>pre:</b> the square relationship has already been inicializated.
     *
     * @param event
     * <b>post:</b> elements have been added to the matrix squared
 */
     
    @SuppressWarnings("unchecked")
	@FXML
    void fill(ActionEvent event) {
    	
    	try {
	    	tilePane.getChildren().clear();
	    	String n = "" + ((ComboBoxBase<String>) borderPane.getRight()).getValue();
	    	square.setDirection(n);
	    	
	    	TextArea t = null;
	    	GridPane panel2 = null;
	    	
	    	// get the address that the user chooses
	    	
	    	if(((ComboBoxBase<String>) borderPane.getRight()).getValue() != null){
	    		panel2 = new GridPane();
	    		square.fillSquare();
	    		
	    		// fill the magicSquare
	    		for(int i=0; i<square.getOrder(); i++) {
	    			for(int j=0; j<square.getOrder(); j++) {
	    				 t = new TextArea("" + square.getSquare()[i][j]);
	    				t.setEditable(false);
	    				panel2.add(t, j, i);
	    				
	    			}
	    			
	    		}
	    		
	    		labelSelect.setText("magic Square solved!!");
	    		panel2.setAlignment(Pos.CENTER);
	        	panel2.setPrefHeight(15);
	        	panel2.setPrefWidth(15);
	    		tilePane.getChildren().add(panel2);
	    		borderPane.setRight(null);
	    		
	    	}
	    	
	    	changeColors(panel2);
	    	
    	}
	    catch(NullPointerException e) {
	    	if(square.getSquare()[0][0] == 0) {
	    		labelSelect.setText("please, choose a direction");
	    	}else {
	    		labelSelect.setText("insert the order of the square and press the -generate- button");
	    	}
	    		
	    	
	    }	
    	
    	}

    

    
    
    
    /**
	<b>Description:</b>
     *allows that when you click on a square of the 
     *magic square, you change the color of all the squares of your same row and column.
     *
     *<b>pre:</b> the square relationship has already been inicializated.
     *
     * @param panel2, the container where the magic square is.
     * 
 */
   void changeColors(GridPane panel2) {
	   
	  TextArea ll = new TextArea();
    	for(int i=0; i<square.getOrder() * square.getOrder(); i++) {
   
    		ll = (TextArea) panel2.getChildren().get(i);
    		 
    		  Text b = new Text(panel2.getRowIndex(ll) + " " + panel2.getColumnIndex(ll));  // get the column and row of the box selected
    		  
    			panel2.getChildren().get(i).addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){     

					@Override
					public void handle(MouseEvent event) {
						tilePane.getChildren().clear();
						GridPane pa = new GridPane();
						
						
						// change the box of the same row and column
						for(int i=0; i<square.getOrder(); i++) {
			    			for(int j=0; j<square.getOrder(); j++) {
			    				
			    				StringTokenizer st = new StringTokenizer(b.getText());
			    				
			    			
			    				if(i == Integer.parseInt(st.nextToken()) || j == Integer.parseInt(st.nextToken())) {
			    					
			    			
			    					
			    					 if((j== square.getOrder()-1 || i== square.getOrder()-1 || i==0 || j==0)) {  // add the magic constant 
			    						
			    						TextArea t = new TextArea("" + square.getMagicConstant());
			    						t.setBlendMode(BlendMode.EXCLUSION);
				    					t.setEditable(false);
				    					pa.add(t, j, i);
			    					}else{
			    						TextArea t = new TextArea("" + square.getSquare()[i][j]);
			    						t.setBlendMode(BlendMode.EXCLUSION);
				    					t.setEditable(false);
				    					pa.add(t, j, i);
			    					}
			    				
			    					
			    					
			    				
			    				}else {
			    					TextArea t = new TextArea("" + square.getSquare()[i][j]);
			    					
			    					t.setEditable(false);
			    					pa.add(t, j, i);
			    				}
			    				
			    			}
			    			
			    		}
						pa.setPrefHeight(15);
			        	pa.setPrefWidth(15);
						tilePane.getChildren().add(pa);
						
					}

					
    			
    			});
    		
    		
    			
    		
    	}
    }
   
}
