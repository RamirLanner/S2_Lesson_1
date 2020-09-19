package Homework_1.Barriers;

//стена
public class Wall extends Barrier {

    public Wall(int BARRIER_DISTANCE) {
        super(BARRIER_DISTANCE);
    }

    @Override
    public String toString() {
        return "Высота стены: " + BARRIER_DISTANCE + "cм.";
    }
}
