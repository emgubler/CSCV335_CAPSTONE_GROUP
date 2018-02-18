
import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;
import java.util.*;

public class MunchkinGame extends Application {
	
	final int SCENE_WIDTH = 800;
	final int SCENE_HEIGHT = 800;
	final int FONT_SIZE = 20;
	final int BUTTON_WIDTH = 200;
	final String FONT_STYLE = "Arial";
	final String imagePath = "./";

	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage stage) {
		
		//sets title
		stage.setTitle("CSCV335 - CAPSTONE - Munchkin");
		
		//accesses the menu options from the welcome screen
		VBox menuOptions = createWelcomeScreen(stage);
		ObservableList<Node> options = menuOptions.getChildren();
		Node startGame = options.get(0);
		Node exitGame = options.get(1);

		//starts the game when the "Start Game" button is clicked
		startGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				//creates the next scene
				createGameScreen(stage);
				
				//creates the initial door deck
				ArrayList<Card> doorDeck = initializeDoorDeck();
				//creates the initial treasure deck
				ArrayList<Card> treasureDeck = initializeTreasureDeck();
				//creates a character
				Character character = initializeCharacter();

				//creates a boolean representing if the game is over or not				
				boolean isGameOver = true; //set this to true to play. freezes if loop is vacant
				//loop continues until player wins or loses
				while(isGameOver == false) {
					
					isGameOver = playGame(doorDeck, treasureDeck, character);
					
				}
			}
		});
		
		//exits the game when the "Exit" button is clicked
		exitGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				Platform.exit();
			}
		});
		
		
		stage.show();

		
	}
	
	
	/*
	 * This method creates the opening splash page for the game. This scene
	 * displays the game title and creates two buttons: 'Start Game' and 'Exit'.
	 * 'Exit will terminate the program and 'Start Game' will construct the game
	 * scene. Project contributors' names are also listed at the bottom of the
	 * splash page.
	 */
	public VBox createWelcomeScreen(Stage stage) {
		
		//creates root pane and sets background color
		GridPane welcomeRoot = new GridPane();
		welcomeRoot.setStyle("-fx-background-color: White;");
		
		//imports munchkin logo, adds it to root, and aligns
		ImageView logo = new ImageView(new Image(imagePath + "munchkinLogo.png", 300, 179, true, true));
		GridPane.setMargin(logo, new Insets(100, 0, 0, 0));
		welcomeRoot.add(logo, 0, 0);
		welcomeRoot.setAlignment(Pos.BASELINE_CENTER);
		
		//creates the menu control holder and aligns
		VBox menuOptions = new VBox(50);
		menuOptions.setAlignment(Pos.BASELINE_CENTER);
		
		//creates and modifies the 'Start Game' button
		Button startGame = new Button("Start Game");
		startGame.setFont(new Font(FONT_STYLE, FONT_SIZE));
		startGame.setPrefWidth(BUTTON_WIDTH);
		

		//creates and modifies the 'Exit' button
		Button exitGame = new Button("Exit");
		exitGame.setFont(new Font(FONT_STYLE, FONT_SIZE));
		exitGame.setPrefWidth(BUTTON_WIDTH);
		
		//lists the participating programmers and modifies label
		Label credits = new Label("Adapted by:\nAshley Roman\nBrendaTorres\nCarlos Portillo\nEvan Gubler\nand Jeremy Roberts");
		credits.setFont(new Font(FONT_STYLE, FONT_SIZE));
		credits.setPrefWidth(BUTTON_WIDTH);
		credits.setWrapText(true);
		credits.setAlignment(Pos.CENTER);
		credits.setTextAlignment(TextAlignment.CENTER);

		//adds buttons to the menu control holder
		menuOptions.getChildren().addAll(startGame, exitGame);
		
		//sets vertical spacing between root elements
		welcomeRoot.setVgap(100);
		
		//adds elements to root
		welcomeRoot.add(menuOptions, 0, 1);
		welcomeRoot.add(credits, 0, 2);
		
		//sets horizontal alignment of contributors' names
		GridPane.setHalignment(credits, HPos.CENTER);

		//creates welcome scene from root
		Scene welcomeScene = new Scene(welcomeRoot, SCENE_WIDTH, SCENE_HEIGHT);
		
		//sets the welcome scene
		stage.setScene(welcomeScene);
		
		//returns controls for access by start function
		return menuOptions;
		
	}
	
	/*
	 * This method creates the game scene
	 */
	public void createGameScreen(Stage stage) {
		
		//creates root
		GridPane gameRoot = new GridPane();
		
		//sets dungeon image background and fits to screen
		gameRoot.setStyle("-fx-background-image: url(" + imagePath + "dungeonBackground.jpg);"
				+ "-fx-background-size: " + SCENE_WIDTH + " " + SCENE_HEIGHT + ";");
		
		//creates the holder for card interaction
		HBox cardDisplay = new HBox(50);
		cardDisplay.setAlignment(Pos.TOP_LEFT);
		cardDisplay.setPrefWidth(SCENE_WIDTH);
		cardDisplay.setPrefHeight(SCENE_HEIGHT - 200);
		
		//TODO create a bunch of various cards to interact with (Card class)
		
		//adds card display to root
		gameRoot.add(cardDisplay, 0, 0);

		
		//creates the menu control holder and aligns
		HBox menuOptions = new HBox(50);
		menuOptions.setAlignment(Pos.BOTTOM_CENTER);
		menuOptions.setPrefWidth(SCENE_WIDTH);
		menuOptions.setPrefHeight(200);
		menuOptions.setStyle("-fx-background-color: Grey;");
		
		//creates the 'Draw Card' button and adds it to the controls
		ImageView doorDeckImage = new ImageView(new Image(imagePath + "doorDeck.jpg", 150, 103, true, true));
		Button drawCard = new Button("Draw Card", doorDeckImage);
		drawCard.setContentDisplay(ContentDisplay.TOP);
		drawCard.setFont(new Font(FONT_STYLE, FONT_SIZE));
		drawCard.setWrapText(true);
		drawCard.setTextAlignment(TextAlignment.CENTER);
		HBox.setMargin(drawCard, new Insets(50, 0, 50, 10));
		menuOptions.getChildren().add(drawCard);
		menuOptions.setAlignment(Pos.BASELINE_LEFT);
		
		
		//adds menu control to root
		gameRoot.add(menuOptions, 0, 1);
		
		
		
		//starts the design 2 turn walkthrough
		 playGameTutorial(gameRoot, menuOptions, drawCard, cardDisplay);
		
		
		//creates scene with root
		Scene gameScene = new Scene(gameRoot, SCENE_WIDTH, SCENE_HEIGHT);
		
		//sets the game scene
		stage.setScene(gameScene);
		
	}
	
	/*
	 * This method will generate the door deck.
	 */
	public ArrayList<Card> initializeDoorDeck() {
		
		ArrayList<Card> doorDeck = new ArrayList<Card>();
		
		//TODO create a list of cards representing the door deck
		
		return doorDeck;
	}
	
	/*
	 * This method will generate the treasure deck.
	 */
	public ArrayList<Card> initializeTreasureDeck() {
		
		ArrayList<Card> treasureDeck = new ArrayList<Card>();

		//TODO create a list of cards representing the treasure deck
		
		return treasureDeck;
		
	}
	
	/*
	 * This method will generate the player's character and assign
	 * them 4 cards to start with.
	 */
	public Character initializeCharacter() {
		
		ArrayList<Card> startingHand = new ArrayList<Card>();
		
		Character character = new Character(startingHand);
		
		//TODO initialization of character as determined
		
		return character;
		
	}
	
	/*
	 * This method will handle playing a single turn of the game. It will
	 * ensure that a player start a turn by drawing a card.
	 */
	public boolean playGame(ArrayList<Card> doorDeck, ArrayList<Card> treasureDeck, Character character) {
		
		boolean isGameOver = false;
		
		//TODO play a turn in the game
		
		return isGameOver;
		
	}
	
	
	
	
	
	
	
	
	
	
	public void playGameTutorial(GridPane gameRoot, HBox menuOptions, Button drawCard, HBox cardDisplay) {
		
		Label tutorial = new Label("First, player will be prompted to draw a card. Click on the 'Draw Card' button now");
		tutorial.setFont(new Font(FONT_STYLE, FONT_SIZE));
		tutorial.setWrapText(true);
		tutorial.setPrefWidth(500);
		menuOptions.getChildren().add(tutorial);
		
		//exits the game when the "Exit" button is clicked
		drawCard.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				tutorial.setText("If the card is a monster, it will appear up top, and the player must fight it."
						+ " The player's cards will be shown in the grey area here, and fight options, such as run away will be offered.");
				menuOptions.getChildren().remove(0);
				
				ImageView monsterCard = new ImageView(new Image(imagePath + "monsterExample.png", 253, 400, true, true));
				cardDisplay.setAlignment(Pos.BASELINE_CENTER);
				HBox.setMargin(monsterCard, new Insets(100, 0, 0, 0));
				cardDisplay.getChildren().add(monsterCard);
				
				Button next1 = new Button("Next");
				next1.setFont(new Font(FONT_STYLE, FONT_SIZE));
				next1.setPrefWidth(100);
				menuOptions.getChildren().add(next1);
				
				next1.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent ae) {
						tutorial.setText("If the monster is defeated, treasure is collected and the player gains a level." +
					" Unwanted cards can be used, sold, discarded, etc. as the rules dictate.");
						cardDisplay.getChildren().remove(0);
						ImageView treasureCard = new ImageView(new Image(imagePath + "treasureExample.png", 253, 400, true, true));
						cardDisplay.setAlignment(Pos.BASELINE_CENTER);
						HBox.setMargin(treasureCard, new Insets(100, 0, 0, 0));
						cardDisplay.getChildren().add(treasureCard);
						menuOptions.getChildren().remove(1);
						
						Button next2 = new Button("Next");
						next2.setFont(new Font(FONT_STYLE, FONT_SIZE));
						next2.setPrefWidth(100);
						menuOptions.getChildren().add(next2);
						
						next2.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent ae) {
								tutorial.setText("Gameplay loop continues until player reaches level 10 or dies. End of tutorial.");
								cardDisplay.getChildren().remove(0);
								HBox.setMargin(treasureCard, new Insets(100, 0, 0, 0));
								menuOptions.getChildren().remove(1);
									
							}
						});
							
					}
				});
				

				


				
			}
		});
		
		

		
		
		
		
		
	}
	

}
