import java.util.ArrayList;
import java.util.List;

public interface Observer {
    void update(String message);
}

class Player implements Observer{
    String name;
    int position;

    Player(String name, int position){
        this.name = name;
        this.position = 0;
    }

    void name(String name){
        this.name = name;
    }
    void position(int position){
        this.position = position;
    }

    String getName(){
        return name;
    }
    int getPosition(){
        return position;
    }

    void setPosition(int position){
        this.position = position;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " " + message);
    }
}

class Game{
    private List<Player> players ;
    private int currentPlayerIndex;

    Game(){
        players = new ArrayList<>();
        currentPlayerIndex = 0;
    }
    void addPlayer(Player player){
        players.add(player);
    }
    Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }
    void nextPlayer(){
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    void notifyPlayers(String message){
        for(Player player : players){
            player.update(message);
        }
    }

}
