import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SnakeAndLadder {
    public static void main(String[] args) {

        Board board = Board.getInstance(100);
        ObstacleFactory factory = new ObstacleFactory();
        // put some snakes
        factory.createSnakes(board , Arrays.asList(new int[]{10 , 20} , new int[]{30 , 40}));
        factory.createLadders(board , Arrays.asList(new int[]{50 , 60} , new int[]{70 , 80}));

        Game game = new Game();
        Player player1 = new Player("Player1" , 0);
        Player player2 = new Player("Player2" , 0);

        game.addPlayer(player1);
        game.addPlayer(player2);

        DiceStrategy dice = new NormalDice();

        while(true){
            Player currentPlayer = game.getCurrentPlayer();
            int no = dice.roll();
            Command command = new Move(currentPlayer , board , no);
            command.move();

            game.notifyPlayers(currentPlayer.getName() + " moved to " + currentPlayer.getPosition());
            if(currentPlayer.getPosition() == board.getSize()){
                System.out.println("Player " + currentPlayer.getName() + " won");
                break;
            }
            game.nextPlayer();



        }

    }
}
