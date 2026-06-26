import java.util.Random;

public interface DiceStrategy {
    int roll();
}

class NormalDice implements DiceStrategy{

    private Random random;

    public NormalDice(){
        random = new Random();
    }

    @Override
    public int roll(){
        return random.nextInt(6) + 1;
    }

}

class TestDice implements DiceStrategy{

    private Random random;

    public TestDice(){
        random = new Random();
    }

    @Override
    public int roll(){
        return random.nextInt(2) + 1;
    }
}
