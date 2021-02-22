package snakeladder;
import java.util.Random;
import snakeladder.Player;

public class SnakeLadderEngine{
    public static void loader(){
        Player p1 = new Player();
        start(p1);
    }
    private static void start(Player p1){
        int dieCount = throwDie();
        int optAhead = giveOptions(dieCount);
        p1.move(optAhead);
    }
    private static int throwDie(){
        Random rand = new Random();
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
