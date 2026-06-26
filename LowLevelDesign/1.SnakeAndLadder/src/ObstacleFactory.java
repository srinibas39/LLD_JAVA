import java.util.List;

public class ObstacleFactory {
    public void createSnakes(Board board , List<int[]> snakes) {

        for(int[] snake : snakes){
            board.addSnake(snake[0] , snake[1]);
        }

    }
    public void createLadders(Board board , List<int[]> ladders) {
        for(int[] ladder : ladders){
            board.addLadder(ladder[0] , ladder[1]);
        }
    }
}
