package snakeladder;

public class Player{
    private int position;
    private int totNoMoves;
    Player(){
        position = 0;
        totNoMoves = 0;
    }
    
    public void move(int opt){
        if(opt > 0){
            position += opt;
            totNoMoves++;
        }
        else{
            if(position == 0)
                return;
            if(position - opt < 0)
                position = 0;
            else
                position -= opt;
            totNoMoves--;
        }
    }
    public int getPosition(){
        return position;
    }
    public int getTotalMoves(){
        return totNoMoves;
    }
}
