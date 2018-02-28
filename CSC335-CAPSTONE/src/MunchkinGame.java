
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
	
	final int SCENE_WIDTH = 1400;
	final int SCENE_HEIGHT = 900;
	final int FONT_SIZE = 20;
	final int INTRO_BUTTON_WIDTH = 200;
	final int GAME_BUTTON_WIDTH = 150;
	final int GAME_BUTTON_HEIGHT = 180;
	final String FONT_STYLE = "Arial";
	final String imagePath = "./";
	
	Label dialogueBox;
	ToggleButton cardSlot1;
	ToggleButton cardSlot2;
	ToggleButton cardSlot3;
	ToggleButton cardSlot4;
	ToggleButton cardSlot5;
	ToggleButton cardSlot6;
	Button actionButton1;
	Button actionButton2;
	Button actionButton3;
	Button actionButton4;
	Button actionButton5;
	Label playerLevelField;
	Label playerGoldField;
	Label playerStrengthField;
	Label playerClassField;
	Label playerRaceField;
	
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
				
				//begins gameplay
				gameMain(doorDeck, treasureDeck, character);


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
		startGame.setPrefWidth(INTRO_BUTTON_WIDTH);
		

		//creates and modifies the 'Exit' button
		Button exitGame = new Button("Exit");
		exitGame.setFont(new Font(FONT_STYLE, FONT_SIZE));
		exitGame.setPrefWidth(INTRO_BUTTON_WIDTH);
		
		//lists the participating programmers and modifies label
		Label credits = new Label("Adapted by:\nAshley Roman\nBrendaTorres\nCarlos Portillo\nEvan Gubler\nand Jeremy Roberts");
		credits.setFont(new Font(FONT_STYLE, FONT_SIZE));
		credits.setPrefWidth(INTRO_BUTTON_WIDTH);
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
		cardDisplay.setPrefHeight(SCENE_HEIGHT - 280);
		
		//creates a dialogue box to guide gameplay
		dialogueBox = new Label("This is the dialogue box. Instructions for the player and details of gameplay should go here. Was a monster drawn? do I need to fight? Can I run away?");
		dialogueBox.setFont(new Font(FONT_STYLE, FONT_SIZE));
		dialogueBox.setWrapText(true);
		dialogueBox.setTextAlignment(TextAlignment.CENTER);
		dialogueBox.setPrefHeight(400);
		dialogueBox.setPrefWidth(800);
		dialogueBox.setBorder(new Border(new BorderStroke(Color.GOLD,
				BorderStrokeStyle.SOLID, new CornerRadii(3.0), BorderStroke.MEDIUM)));
		dialogueBox.setAlignment(Pos.CENTER);
		dialogueBox.setStyle("-fx-background-color: Grey;");
		cardDisplay.getChildren().add(dialogueBox);
		cardDisplay.setAlignment(Pos.CENTER);
		
		
		//adds card display to root
		gameRoot.add(cardDisplay, 0, 0);
		
		
		//creates a container for action buttons and adds it to the scene
		HBox actionContainer = new HBox(30);
		
		gameRoot.add(actionContainer, 0, 1);
		actionContainer.setAlignment(Pos.CENTER_LEFT);
		actionContainer.setPrefWidth(SCENE_WIDTH);
		actionContainer.setPrefHeight(80);
		actionContainer.setStyle("-fx-background-color: Gold;");
		actionContainer.setAlignment(Pos.CENTER);
		
		//creates action buttons and adds them to actionContainer
		actionButton1 = new Button("Fight");
		actionButton1.setFont(new Font(FONT_STYLE, FONT_SIZE));
		actionContainer.getChildren().add(actionButton1);
		
		actionButton2 = new Button("Run Away");
		actionButton2.setFont(new Font(FONT_STYLE, FONT_SIZE));
		actionContainer.getChildren().add(actionButton2);
		
		actionButton3 = new Button("Cast Spell (WIZARD only)");
		actionButton3.setFont(new Font(FONT_STYLE, FONT_SIZE));
		actionContainer.getChildren().add(actionButton3);
		
		actionButton4 = new Button("Sell Card");
		actionButton4.setFont(new Font(FONT_STYLE, FONT_SIZE));
		actionContainer.getChildren().add(actionButton4);
		
		actionButton5 = new Button("Buy Level");
		actionButton5.setFont(new Font(FONT_STYLE, FONT_SIZE));
		actionContainer.getChildren().add(actionButton5);
		
		//creates player data fields and adds them to the scene
		playerLevelField = new Label("Level: 0");
		playerLevelField.setFont(new Font(FONT_STYLE, FONT_SIZE));
		actionContainer.getChildren().add(playerLevelField);

		playerGoldField = new Label("Gold: 1000");
		playerGoldField.setFont(new Font(FONT_STYLE, FONT_SIZE));
		actionContainer.getChildren().add(playerGoldField);

		playerStrengthField = new Label("Strength: 0");
		playerGoldField.setFont(new Font(FONT_STYLE, FONT_SIZE));

		playerClassField = new Label("Class: Unskilled");
		playerClassField.setFont(new Font(FONT_STYLE, FONT_SIZE));
		actionContainer.getChildren().add(playerClassField);

		playerRaceField = new Label("Race: Human");
		playerRaceField.setFont(new Font(FONT_STYLE, FONT_SIZE));
		actionContainer.getChildren().add(playerRaceField);

		
		
		
		
		
		//creates the menu control holder and aligns
		HBox menuOptions = new HBox(30);
		menuOptions.setAlignment(Pos.CENTER);
		menuOptions.setPrefWidth(SCENE_WIDTH);
		menuOptions.setPrefHeight(250);
		menuOptions.setStyle("-fx-background-color: Grey;");
		
		//creates the 'Draw Card' button and adds it to the controls
		ImageView doorDeckImage = new ImageView(new Image(imagePath + "doorDeck.jpg", 125, 75, true, true));
		Button drawCard = new Button("Draw Card", doorDeckImage);
		drawCard.setContentDisplay(ContentDisplay.BOTTOM);
		drawCard.setFont(new Font(FONT_STYLE, FONT_SIZE));
		drawCard.setWrapText(true);
		drawCard.setTextAlignment(TextAlignment.CENTER);
		HBox.setMargin(drawCard, new Insets(0, 0, 0, 20));
		menuOptions.getChildren().add(drawCard);
		
		//creates the card buttons
		cardSlot1 = new ToggleButton("Card details listed here when they are drawn");
		cardSlot1.setFont(new Font(FONT_STYLE, FONT_SIZE));
		cardSlot1.setWrapText(true);
		cardSlot1.setPrefWidth(GAME_BUTTON_WIDTH);
		cardSlot1.setPrefHeight(GAME_BUTTON_HEIGHT);
		cardSlot1.setTextAlignment(TextAlignment.CENTER);
		menuOptions.getChildren().add(cardSlot1);
		
		cardSlot2 = new ToggleButton("Cards can be used by clicking on these, perhaps");
		cardSlot2.setFont(new Font(FONT_STYLE, FONT_SIZE));
		cardSlot2.setWrapText(true);
		cardSlot2.setPrefWidth(GAME_BUTTON_WIDTH);
		cardSlot2.setPrefHeight(GAME_BUTTON_HEIGHT);
		cardSlot2.setTextAlignment(TextAlignment.CENTER);
		menuOptions.getChildren().add(cardSlot2);
		
		cardSlot3 = new ToggleButton("Card Slot 3");
		cardSlot3.setFont(new Font(FONT_STYLE, FONT_SIZE));
		cardSlot3.setWrapText(true);
		cardSlot3.setPrefWidth(GAME_BUTTON_WIDTH);
		cardSlot3.setPrefHeight(GAME_BUTTON_HEIGHT);
		cardSlot3.setTextAlignment(TextAlignment.CENTER);
		menuOptions.getChildren().add(cardSlot3);
		
		cardSlot4 = new ToggleButton("Card Slot 4");
		cardSlot4.setFont(new Font(FONT_STYLE, FONT_SIZE));
		cardSlot4.setWrapText(true);
		cardSlot4.setPrefWidth(GAME_BUTTON_WIDTH);
		cardSlot4.setPrefHeight(GAME_BUTTON_HEIGHT);
		cardSlot4.setTextAlignment(TextAlignment.CENTER);
		menuOptions.getChildren().add(cardSlot4);
		
		cardSlot5 = new ToggleButton("Card Slot 5");
		cardSlot5.setFont(new Font(FONT_STYLE, FONT_SIZE));
		cardSlot5.setWrapText(true);
		cardSlot5.setPrefWidth(GAME_BUTTON_WIDTH);
		cardSlot5.setPrefHeight(GAME_BUTTON_HEIGHT);
		cardSlot5.setTextAlignment(TextAlignment.CENTER);
		menuOptions.getChildren().add(cardSlot5);
		
		cardSlot6 = new ToggleButton("Card Slot 6 (DWARF only)");
		cardSlot6.setFont(new Font(FONT_STYLE, FONT_SIZE));
		cardSlot6.setWrapText(true);
		cardSlot6.setPrefWidth(GAME_BUTTON_WIDTH);
		cardSlot6.setPrefHeight(GAME_BUTTON_HEIGHT);
		cardSlot6.setTextAlignment(TextAlignment.CENTER);
		menuOptions.getChildren().add(cardSlot6);
		
		//aligns the menu options
		menuOptions.setAlignment(Pos.BASELINE_LEFT);

		
		//creates the 'End Turn' button and adds it to the controls
		Button endTurn = new Button("End Turn");
		endTurn.setContentDisplay(ContentDisplay.TOP);
		endTurn.setFont(new Font(FONT_STYLE, FONT_SIZE));
		endTurn.setWrapText(true);
		endTurn.setTextAlignment(TextAlignment.CENTER);
		endTurn.setPrefHeight(110);
		HBox.setMargin(endTurn, new Insets(25, 5, 25, 0));
		menuOptions.getChildren().add(endTurn);
		
		
		//adds menu control to root
		gameRoot.add(menuOptions, 0, 2);
	
		//creates scene with root
		Scene gameScene = new Scene(gameRoot, SCENE_WIDTH, SCENE_HEIGHT);
		
		//sets the game scene
		stage.setScene(gameScene);
		
	}
	
	
	
	
	
	/*
	 * This method will generate the door deck.
	 * Carlos should handle this portion since he knows the cards.
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
	 * This method is the main loop for gameplay. It loops turns
	 * until the player has won or lost. A turn consists of a draw
	 * phase, a combat phase (if a monster was drawn), a post-combat
	 * phase, and an end turn phase.
	 */
	
	public void gameMain(ArrayList<Card> doorDeck, ArrayList<Card> treasureDeck, Character character) {
		
		System.out.println("initiating gameplay");
		//creates a boolean representing if the game is over or not				
		
		//loop continues until player wins or loses
		//while(!isGameOver) {
			
			//TODO write drawCard() method
			
			//TODO write combat() method
			
			//TODO write postCombat() method
			
			//TODO write endTurn() method
			
		//}
		
	}
	

}
