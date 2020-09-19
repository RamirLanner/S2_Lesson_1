package Homework_1.Barriers;

//Беговая дорожка
public class Track extends Barrier {

    public Track(int BARRIER_DISTANCE) {
        super(BARRIER_DISTANCE);
    }

    @Override
    public String toString() {
        return "Длина дорожки: " + BARRIER_DISTANCE + "м.";
    }

}
