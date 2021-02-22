package snakeladder;
import java.util.Random;
import snakeladder.Player;

public class SnakeLadderEngine{
    public static void loader(){
        Player p1 = new Player();
        start(p1);
    }
    public static void start(Player p1){
        int dieCount = throwDie();
    }
    private static int throwDie(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
