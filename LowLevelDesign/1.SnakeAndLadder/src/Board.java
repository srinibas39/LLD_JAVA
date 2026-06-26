import java.util.HashMap;
import java.util.Map;

public class Board {

    private static Board instance;
    private int size;
    Map<Integer , Integer> snakes;
    Map<Integer , Integer> ladders;

    public Board(int size) {
        this.size = size;
        snakes = new HashMap<>();
        ladders = new HashMap<>();
    }

    public static Board getInstance(int size){
        if(instance == null){
            return new Board(size);
        }
        return instance;
    }

    public int getSize() {
        return size;
    }
    public Map<Integer , Integer> getSnakes() {
        return snakes;
    }
    public Map<Integer , Integer> getLadders() {
        return ladders;
    }

    public void addSnake(int start , int end){
        snakes.put(start , end);
    }

    public void addLadder(int start , int end){
        ladders.put(start , end);
    }
}
