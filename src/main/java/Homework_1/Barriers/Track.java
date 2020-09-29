package Homework_1.Barriers;

import Homework_1.Interfaces.JumpAndRunsPlayers;

//Беговая дорожка
public class Track extends Barrier {

    public Track(int barrierDistance) {
        super(barrierDistance);
    }

    @Override
    public String toString() {
        return "Длина дорожки: " + barrierDistance + "м.";
    }

    @Override
    public boolean barrierPass(JumpAndRunsPlayers player) {
        System.out.println(this.toString());
        return this.barrierDistance <= player.getPlayerJumpHeight();
    }

}
