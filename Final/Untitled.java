class Untitled {
	public static void main(String[] args) {
		int randFoodX = (int)(Math.random() * 300 + 50);
		int randFoodY = (int)(Math.random() * 400 + 50);
		System.out.println("x: " +randFoodX + " y: "+ randFoodY);
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
		System.out.println("x: " +randFoodX + " y: "+ randFoodY);
	}
}

final List<MediaPlayer> players = new ArrayList<>();
		for (String file : dir.list(new FilenameFilter() {
			@Override public boolean accept(File dir, String name) {
				for (String ext: SUPPORTED_FILE_EXTENSIONS) {
					if (name.endsWith(ext)) {
						return true;
					}
				}

				return false;
			}
		})) players.add();
		if (players.isEmpty()) {
			System.out.println("No audio found in " + dir);
			return;
		}    

/*
long mTime = System.currentTimeMillis();
long end = mTime + 5000; 
*

/* music for win
music.pause();
	win.play();
music.play();

public boolean pointSound(){
		if((chaser.face.getX() == food.food.getX()) && (chaser.face.getY() == food.food.getY())) {
			return true;		
		}
		else {
			return false;
		}
	} 
	
if(pointSound() == true) {	
	mediaPlayer.pause();
	win.play();
	//chaser.eat();
	mediaPlayer.play();
	//chaser.normal();
}

*/

/*
music 1- upbeat retro
music 2- 46 second calm retro
music 3- 
music 4- dramatic strings calming music
music 5- upbeat deep oompah high techno
music 6- calm techno
music 7- calm strings intro, upbeat piano, both
music 8- calm relax techno
music 10- calm piano
music 11- calm techno
music 12- techno fun
music 13- fun little kid song
music 14- win2
music 9- lose2
music - 
music - 
music - 
music -  
*/
