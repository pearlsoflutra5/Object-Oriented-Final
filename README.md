# Object-Oriented-Final
## Synopsis
I have created a game for younger children. The average age range that would most appreciate it would probably be from about 5-10. It is similar to the classical Snake Game, however, my "hunter" does not increase in size. Points are added and fun music is playing in the background. 

## Motivation
I have two young nephews and I wanted to create a game that would be fun for them. I always think it is fun to create a game that you would like to play yourself and be able to share with those around you. I thought it would be a fun game that was simple on the outside, but it would be able to do more fun things than it would appear. 

## How to Run
The only file needed to run the code is the main FinalProjectChaserGame.java from the main screen. 
(code.png)[Still of my code during a run.]

## Code Example
I was especially proud of this code because it was the most important to me.  I wanted to take music from a Media list and then be able to repeat it infinitely. While running infinitely I also wanted to be able to pause the music, because you may have to leave and that is the only thing that is dependent on time. The rest of the code takes user input to run. It took me a while to get the code in the correct locations, but it was very rewarding to make what I specifically wanted for my project.  
```
public int index = 0; 
	public void playMediaTracks(ObservableList<Media> mediaList) {
		if (mediaList.size() == 0){
			return;
		}
		this.mediaPlayer = new MediaPlayer(mediaList.get(index));
		this.mediaPlayer.play();							
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				if(index + 1 < mediaList.size() - 1){
					index++;
				}
				else {
					index = 0;
				}
				playMediaTracks(mediaList);
			}
		});
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
```

## Tests
### Describe and show how to run the tests with code examples. State that you are using JUnit4 to test.

## Contributors
There is not anything that is special for this project. I did use JavaFx so there may be some complications with certain programs. Anyone can modify this project how they wish just as long as the original code stays the same.  A fun idea that I had was to create obstacles for the "hunter" to avoid.

## resources
### Images
All images are by Twitter, CC BY 4.0, https://commons.wikimedia.org/w/index.php?curid=  (curid 37288034 through 37288142)

### Music
All music was taken from orangefreesounds.com from Alexander Blu, CC BY 4.0
<ul> 
  <li>http://www.orangefreesounds.com/aggressive-electronic-dubstep-track/
  <li>http://www.orangefreesounds.com/electronic-beat/
  <li>http://www.orangefreesounds.com/ambient-background-music-intro/
  <li>http://www.orangefreesounds.com/mysterious-piano/
  <li>http://www.orangefreesounds.com/chill-electronic-music/
  <li>http://www.orangefreesounds.com/ambient-synth-pad-sound/
  <li>http://www.orangefreesounds.com/retro-electronic-music-intro/
  <li>http://www.orangefreesounds.com/electronic-background-music-for-videos/\    
  <li>http://www.orangefreesounds.com/primavera-lounge-music-inspired-spring/
  <li>http://www.orangefreesounds.com/brightness-soft-techno/
  <li>http://www.orangefreesounds.com/electro-blues-groovy-lounge-track/
  <li>http://www.orangefreesounds.com/snowy-street-solo-piano-melody/   
</ul>
  
  
