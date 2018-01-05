public class Hangman {
    
    public static void main(String[] args) {
        
        if (args.length == 0){
        	System.out.println("Please enter a word when starting");
        	System.exit(0);
        }
        Game game = new Game(args[0]);
        // Create class for Promter
        Prompter prompter = new Prompter(game);
        prompter.play();
    }

}