import java.util.Random;
import java.util.Scanner;

class Guessnumber {
    
    private static final int minnum = 1;
    private static final int maxnum= 100;
    
    private static int targetnumber;
    private static int attempts;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number of attempts do you want");
     int maxattempts= sc.nextInt();

        int score=20;
        int highscore=0;
        
        Random random = new Random();

        System.out.println("!!!!Guess the Number !!!!");
        System.out.println("Welcome to the Number Guessing Game!!");

        while (true) {
            System.out.println();
            System.out.println("New Game!");

            targetnumber = random.nextInt(maxnum- minnum + 1) + minnum;
            attempts = 0;

            while (true) {
                System.out.print("Enter the guess number(between 1 and 100): ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == targetnumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    if(score>highscore)
                    {
                        highscore=score;
                    }
                    break;
                } else if (guess < targetnumber) {
                    
                    System.out.println("Too low! Try again.");
                    if(score>0)
                    {
                        score--;
                    }
                    else{
                        System.out.println("you lost game");
                    }
                } else {
                    System.out.println("Too high! Try again.");
                    if(score>0)
                    {
                        score--;
                    }
                    else{
                        System.out.println("you lost game");
                    }
                }

                if (attempts >= maxattempts) {
                    System.out.println("Sorry, you have reached the maximum number of attempts.");
                    System.out.println("highscore:"+highscore);
                    System.out.println("score:"+score);
                   
                    break;
                }

            }

            System.out.print("Do you want to play again? (Yes/No): ");
            String playAgain = sc.next();
            if (!playAgain.equalsIgnoreCase("Yes")) {
                System.out.println("Thank you for playing the Number Guessing Game! Goodbye!");
                break;
            }
            
        }
    }
}