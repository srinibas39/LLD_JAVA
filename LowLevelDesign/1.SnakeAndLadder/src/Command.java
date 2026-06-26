public interface Command {
    void move();
}

class Move implements Command{
    private Player player;
    private Board board;
    private int steps;

    public Move(Player player, Board board, int steps){
        this.player = player;
        this.board = board;
        this.steps = steps;
    }

    @Override
    public void move(){
       int newPosition = player.getPosition() + steps;

       if(newPosition > board.getSize()){
           newPosition = board.getSize();
       }

       if(board.getSnakes().containsKey(newPosition)){
           newPosition = board.getSnakes().get(newPosition);
       }
       if(board.getLadders().containsKey(newPosition)){
           newPosition = board.getLadders().get(newPosition);
       }

       player.setPosition(newPosition);


    }

}
