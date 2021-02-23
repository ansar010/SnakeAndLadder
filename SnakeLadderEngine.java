package snakeladder;
import java.util.Scanner;
import java.util.Random;
import snakeladder.Player;

public class SnakeLadderEngine{
    private static int countNoThrows = 0;
    public static void loader(){
        Player p1 = new Player();
        Player p2 = new Player();
        Scanner sc = new Scanner(System.in);
        decidesThrowFirst(p1, p2);
        while(!p1.is_end_position() && !p2.is_end_position()){
            start(p1, p2);
            printDetails(p1, p2);
            sc.nextLine();
        }
        if(p1.is_end_position()){
            System.out.println("Player One won the game");
            System.out.println("Total moves taken: " + p1.getTotalMoves()); 
        }
        else{
            System.out.println("Player two won the game");
            System.out.println("Total moves taken: " + p2.getTotalMoves());
        }
        sc.close();
    }
    private static void start(Player p1, Player p2){
        int dieCount = throwDie();
        int optAhead = giveOption(dieCount);
        updatePlayers(p1, p2, optAhead);
    }
    private static int throwDie(){
        Random rand = new Random();
        countNoThrows++;
        return rand.nextInt(6) + 1;
    }
    private static int giveOption(int dieCount){
        Random rand = new Random();
        int opt = rand.nextInt(3);
        switch(opt){
            case 0: 
                return 0;
            case 1:
                return dieCount;
            default:
                return (-1)*dieCount;
        }
    }
    private static void decidesThrowFirst(Player p1, Player p2){
        Random rand = new Random();
        int toss = rand.nextInt(2);
        boolean throwFirst = true;
        if(toss == 0)
            p1.setChance(throwFirst);
        else
            p2.setChance(throwFirst);
    }
    private static void updatePlayers(Player p1, Player p2, int opt){
        if(p1.getChance()){
            if(opt <= 0){
                p1.setChance(false);
                p2.setChance(true);
                if(opt == 0)
                    System.out.println("Player 1: No move");
                else
                    System.out.println("Player 1: Bit by snake, going down by "+ (-1)*opt );
            }
            if(opt > 0)
                System.out.println("Player 1: Going up the ladder by " + opt);
            p1.move(opt);
        }
        else{
            if(opt <= 0){
                p2.setChance(false);
                p1.setChance(true);
                if(opt == 0)
                    System.out.println("Player 2: No move");
                else
                    System.out.println("Player 2: Bit by snake, going down by "+ (-1)*opt);
            }
            if(opt > 0)
                System.out.println("Player 2: Going up the ladder by "+ opt);
            p2.move(opt);
        }
    }
    private static void printDetails(Player p1, Player p2){
        System.out.println("-----------------------------------------------");
        System.out.println("[ Throw Number : " + countNoThrows + " ]");
        System.out.println("Player One: " + p1.getPosition());
        System.out.println("Player Two: " + p2.getPosition());
        System.out.println("-----------------------------------------------");
    }
}
