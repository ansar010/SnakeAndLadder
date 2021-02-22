package snakeladder;
import java.util.Random;
import snakeladder.Player;

public class SnakeLadderEngine{
    private static int countNoThrows=0;
    public static void loader(){
        Player p1 = new Player();
        while(p1.getPosition() != Player.END_POSITION){
            start(p1);
            System.out.println("{Throw No.: " + countNoThrows + 
                    "} Player Position: " + p1.getPosition());
        }
        System.out.println("Total Number of moves took by the player is : "
                + p1.getTotalMoves());
    }
    private static void start(Player p1){
        int dieCount = throwDie();
        int optAhead = giveOptions(dieCount);
        p1.move(optAhead);
    }
    private static int throwDie(){
        Random rand = new Random();
        countNoThrows++;
        return rand.nextInt(6) + 1;
    }
    private static int giveOptions(int dieCount){
        Random rand = new Random();
        int opt = rand.nextInt(3);
        switch(opt){
            case 0: 
                return 0;
            case 1:
                return dieCount;
            case 2:
                return (-1)*dieCount;
        }
        return -1;
    }
}
