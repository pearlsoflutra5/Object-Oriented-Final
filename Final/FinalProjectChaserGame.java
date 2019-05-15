/*
Kacie Rae
5-6-19
Final Project: Chaser game with an emoji face that eats food and dodges obstacles.

All the images are By Twitter, CC BY 4.0, https://commons.wikimedia.org/w/index.php?curid=(37288034 through 37288142)

Music by Alexander Blu, CC BY 4.0, http://www.orangefreesounds.com/aggressive-electronic-dubstep-track/
	http://www.orangefreesounds.com/electronic-beat/
	http://www.orangefreesounds.com/ambient-background-music-intro/
	http://www.orangefreesounds.com/mysterious-piano/
	http://www.orangefreesounds.com/chill-electronic-music/
	http://www.orangefreesounds.com/ambient-synth-pad-sound/
	http://www.orangefreesounds.com/retro-electronic-music-intro/
	http://www.orangefreesounds.com/electronic-background-music-for-videos/
	http://www.orangefreesounds.com/primavera-lounge-music-inspired-spring/
	http://www.orangefreesounds.com/brightness-soft-techno/
	http://www.orangefreesounds.com/electro-blues-groovy-lounge-track/
	http://www.orangefreesounds.com/snowy-street-solo-piano-melody/
Sound effects by Alexander Blu, CC BY 4.0, http://www.orangefreesounds.com/winning-sound-effect/, http://www.orangefreesounds.com/wha-wha-wha-sound-effect/

*/
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.util.Random; 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.layout.Region.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.Scene;
import javafx.scene.text.Text; 
import javafx.stage.Stage;

public class FinalProjectChaserGame extends Application {
	public Chaser chaser;
	public Food food;
	public Text score;
	public long food1;	
	public long food2;
	
	MediaPlayer mediaPlayer;
	MediaPlayer win = new MediaPlayer(new Media(new File("sounds/win.mp3").toURI().toString()));
	MediaPlayer lose = new MediaPlayer(new Media(new File("sounds/lose.mp3").toURI().toString()));
	
	Button start = new Button("Start Music");
	Button pause = new Button("Pause Music");

	@Override 
		public void start(Stage primaryStage) throws FileNotFoundException {
			Media music1 = new Media(this.getClass().getResource("sounds/background.mp3").toExternalForm());
			Media music2 = new Media(this.getClass().getResource("sounds/background2.mp3").toExternalForm());
			Media music3 = new Media(this.getClass().getResource("sounds/background3.mp3").toExternalForm());
			Media music4 = new Media(this.getClass().getResource("sounds/background4.mp3").toExternalForm());
			Media music5 = new Media(this.getClass().getResource("sounds/background5.mp3").toExternalForm());
			Media music6 = new Media(this.getClass().getResource("sounds/background6.mp3").toExternalForm());
			Media music7 = new Media(this.getClass().getResource("sounds/background7.mp3").toExternalForm());
			Media music8 = new Media(this.getClass().getResource("sounds/background8.mp3").toExternalForm());
			Media music10 = new Media(this.getClass().getResource("sounds/background10.mp3").toExternalForm());
			Media music11 = new Media(this.getClass().getResource("sounds/background11.mp3").toExternalForm());
			Media music12 = new Media(this.getClass().getResource("sounds/background12.mp3").toExternalForm());
			Media music13 = new Media(this.getClass().getResource("sounds/background13.mp3").toExternalForm());
			Media music14 = new Media(this.getClass().getResource("sounds/win2.mp3").toExternalForm());
			Media music9 = new Media(this.getClass().getResource("sounds/lose2.mp3").toExternalForm());

			ObservableList<Media> mediaList = FXCollections.observableArrayList();
			//mediaList.addAll(music3, );
			mediaList.add(music3);
			/*music2, music10, music1, music4, music5, music6, music7, music8, music12, music13, music11*/
		
			playMediaTracks(mediaList);		
			
			this.chaser = new Chaser();	
			this.food = new Food();		
			Pane gamePane = new Pane();
			
			Image image = new Image(new FileInputStream("images/backgrounds/blue.jpg"));	
			//Image image = new Image(new FileInputStream("images/backgrounds/colorful.jpg"));
			//Image image = new Image(new FileInputStream("images/backgrounds/paintSplotch2.jpg"));
			//Image image = new Image(new FileInputStream("images/backgrounds/purplePaisley.jpg")); 
			
			ImageView background = new ImageView(image);			
			background.setFitWidth(500);
			background.setFitHeight(500);
			gamePane.getChildren().addAll(background, this.food, this.chaser);			
			
			HBox hBox = new HBox(10);
			hBox.setAlignment(Pos.CENTER);
			hBox.setPadding(new Insets(3, 10, 3, 10));
			hBox.setStyle("-fx-border-color: blue");
			
			Button restart = new Button("Restart");
			this.score = new Text("Score: 0");
			hBox.getChildren().addAll(restart, pause, start, this.score);	
	
			restart.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					chaser.restart();
					food.restart();
					score.setText(chaser.scoreT + "");					
				}
			});
					
			BorderPane pane = new BorderPane();
			pane.setCenter(gamePane);
			pane.setTop(hBox);
			
			pane.setOnKeyPressed(e ->  { 
			switch (e.getCode()) {
				case DOWN:this.chaser.down();return;  
				case UP: this.chaser.up(); break; 		
				case LEFT: this.chaser.left(); break; 
				case RIGHT: this.chaser.right(); break;
				}		
			});	

			Scene scene = new Scene(pane, 500, 500);
			primaryStage.setTitle("Chaser Game"); 
			primaryStage.setScene(scene); 
			primaryStage.show();
			pane.requestFocus();
			scene.addEventFilter(KeyEvent.ANY, keyEvent -> {
				pointGain();
			}); 
						
	}	
	public void pointGain() {
		score.setText("Score: " + Long.toString(chaser.scoreT));
		if((chaser.face.getX() == food.food.getX()) && (chaser.face.getY() == food.food.getY())) {
			chaser.scoreT++;
			score.setText("Score: " + chaser.scoreT + "");		
			food.die();			
		}
		else {
			return;
		}	
	} 
		
	public void playMediaTracks(ObservableList<Media> mediaList) {		
		if (mediaList.size() == 0){
			return;
		}	
		
		MediaPlayer mediaPlayer = new MediaPlayer(mediaList.remove(0));	
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				playMediaTracks(mediaList);
			}
		});
		mediaPlayer.play();
		
		pause.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				mediaPlayer.pause();					
			}
		});
		
		start.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				mediaPlayer.play();					
			}
		});	
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
			launch(args);
		}	
}


//--------------------------------CHASER-------------------------------------------------
class Chaser extends Pane {
	public long scoreT = 0;
	public ImageView face;
	public Chaser() {
		try {
			Image openFace = new Image(new FileInputStream("images/faces/openFace.png"));	
			this.face = new ImageView(openFace);
			this.face.setFitHeight(50);
			this.face.setFitWidth(50);
			getChildren().add(this.face);			
		} 
		catch (FileNotFoundException e) {
		}	
	}
	
	
	public void down(){
		if(this.face.getY() > 405) return;
		this.face.setY(this.face.getY() + 10); 
	}
	public void up(){
		if(this.face.getY() < 10) return;
		this.face.setY(this.face.getY() - 10);
	}
	public void right(){
		if(this.face.getX() > 440) return;
		this.face.setX(this.face.getX() + 10);	
	}
	public void left(){
		if(this.face.getX() < 10) return;
		this.face.setX(this.face.getX() - 10);	
	}
	public void start(){
		try {
			Image openFace = new Image(new FileInputStream("images/faces/openFace.png"));	
			this.face = new ImageView(openFace);
			this.face.setFitHeight(50);
			this.face.setFitWidth(50);
			this.face.setX(0.0);
			this.face.setY(0.0);
			getChildren().add(this.face);		
		} 
		catch (FileNotFoundException e) {
		}		
	}
	public void restart(){
		this.scoreT = 0;
		getChildren().remove(this.face);
		start();			
	}	
	public void eat(){
		try{	
			this.face = new ImageView(new Image(new FileInputStream("images/faces/heartFace.png")));
			this.face.setFitHeight(50);
			this.face.setFitWidth(50);
		}
		catch(FileNotFoundException e){	
		}									
	}
	public void die(){
		try{
			Image deadFace = new Image(new FileInputStream("images/faces/deadFace.png"));
			this.face =	new ImageView(deadFace);
		}
		catch (FileNotFoundException e){	
		}		
	}
	public void normal(){
			try{
				Image openFace = new Image(new FileInputStream("images/faces/openFace.png"));	
				this.face =	new ImageView(openFace);
			}
			catch (FileNotFoundException e){	
			}		
		}
		
}
//--------------------------------FOOD-------------------------------------------------
class Food extends Pane {
	public ImageView food;
	public Food() {
			String foodImg = foodPicker();
			this.food = new ImageView(new Image(foodImg));
			int randFoodX = (int)(Math.random() * 300 + 50);
			int randFoodY = (int)(Math.random() * 370 + 50);
			if((randFoodX % 10.0 != 0) || (randFoodY % 10 != 0)){
				if(randFoodX % 10 != 0){
					while(randFoodX % 10 != 0){
						randFoodX--;
					}
						
				}
				if(randFoodY % 10 != 0){
					while(randFoodY % 10 != 0){
						randFoodY--;
					}
				}
			}
			this.food.setX(randFoodX);
			this.food.setY(randFoodY);
			this.food.setFitHeight(50);
			this.food.setFitWidth(50);
			getChildren().add(this.food);
	}
	public void start(){			
		String foodImg = foodPicker();
		this.food = new ImageView(new Image(foodImg));
		int randFoodX = (int)(Math.random() * 300 + 50);
		int randFoodY = (int)(Math.random() * 300 + 50);
		if((randFoodX % 10.0 != 0) || (randFoodY % 10 != 0)){
			if(randFoodX % 10 != 0){
				while(randFoodX % 10 != 0){
					randFoodX--;
				}			
			}
			if(randFoodY % 10 != 0){
				while(randFoodY % 10 != 0){
					randFoodY--;
				}
			}
		}
		this.food.setX(randFoodX);
		this.food.setY(randFoodY);
		this.food.setFitHeight(50);
		this.food.setFitWidth(50);
		getChildren().add(this.food);	
	}
	public void restart(){
		getChildren().remove(this.food);
		start();
	}
	
	public void die(){
		getChildren().remove(this.food);
		start();
	}
	public static String foodPicker() {
		Random random = new Random();	
		String[] food  = {"banana", "birthdayCake", "bread", "candy", "cherry", "chocolate", "cookie", "corn", "donut", "drumstick", "flan", "frenchFries", "friedEgg", "fruitShiskabob", "grapes", "greenApple", "greenSoup", "hamburger", "honey", "icecreamBowl", "icecreamCone", "lemon", "lollypop", "meatOnBones", "meatShishkabob", "melon", "orange", "orangeJuice", "peach", "pear", "pineapple", "pizzaSlice", "redApple", "rice", "spaghetti","strawberry", "strawberryIcecream", "strawberryShortCake", "tomato", "watermelonSlice", "yams" };
		int rand = random.nextInt(food.length);
		String result = new String("images/food/" + food[rand] + ".png");
		return result;
	}
	
}

//--------------------------------OBJECTS-------------------------------------------------
class Objects extends Pane {
	
}


