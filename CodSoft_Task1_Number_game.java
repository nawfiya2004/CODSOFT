import java.util.*;
public class CodSoft_Task1_Number_game {
    public static void main(String[] args){
        Random rand=new Random();
        Scanner scan=new Scanner(System.in);
        int atmp,i,j=0,i1;
        do {
            int cip = rand.nextInt(101);
            for ( i = 0; i <=10; i++) {
                System.out.println("Enter the  number:");
                int uip = scan.nextInt();
                if(i==10) {
                    System.out.println("SORRY,YOU REACHED THE GUESSING LIMIT :(");
                    System.out.println("The number is" + cip);
                    break;
                } else if (uip < cip) {
                    System.out.println("too low");
                } else if (uip > cip) {
                    System.out.println("too high");
                }else{
                    System.out.println("You won the Game:)");
                    break;
                }
            }
            System.out.println(i+1 + " Times you guessed the number");
            j=j+1;
            System.out.println("press '1' to continue \n press '0' to exit");
            atmp=scan.nextInt();

        }while(((j < 3) && (atmp == 1))) ;
        System.out.println((j)+" Times you played the game \n GAME OVER");

    }
}

