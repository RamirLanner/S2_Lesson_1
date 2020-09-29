package Homework_1.Barriers;

import Homework_1.Interfaces.JumpAndRunsPlayers;

//стена
public class Wall extends Barrier {

    public Wall(int barrierDistance) {
        super(barrierDistance);
    }

    @Override
    public String toString() {
        return "Высота стены: " + barrierDistance + "cм.";
    }

    @Override
    public boolean barrierPass(JumpAndRunsPlayers player) {
        System.out.println(this.toString());
        return this.barrierDistance <= player.getPlayerRunDistance();
    }

}
