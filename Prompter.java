import java.io.Console;

public class Prompter {
	private Game mGame;


	public Prompter(Game game){
		mGame = game;

	}

	public void play(){
		while (mGame.getRemainingTries() > 0 && !mGame.isSolved()){
			displayProgress();
			promptForGuess();
		}
		if(mGame.isSolved()){
			System.out.printf("Congratulations, You won with %d tries remaining.\n", mGame.getRemainingTries());
		}else{
			System.out.printf("Sorry, you are all out of tries. Better luck next time. \n");
		}

	}

	public void displayProgress(){
		System.out.printf("You have %d tries left to solve: %s \n",
										mGame.getRemainingTries(),
										mGame.getCurrentProgress());
	}

	public boolean promptForGuess(){
		Console console = System.console();
		//Adding validation for the guess
		boolean isHit = false;
		boolean isValidGuess = false;

		while(! isValidGuess){
			
			String guessAsString = console.readLine("Enter a letter: ");
			
			try{
				char guess = guessAsString.charAt(0);
				isHit = mGame.applyGuess(guess);
				isValidGuess = true;
			}catch (IllegalArgumentException ex){
				console.printf("%s Please try again.\n", ex.getMessage());
			}catch (StringIndexOutOfBoundsException ex){
				console.printf("Please Choose a letter");
			}
		}		
		return isHit;
	}
}