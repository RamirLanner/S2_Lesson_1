package Homework_1.Players;

import Homework_1.Barriers.Barrier;
import Homework_1.Barriers.Track;
import Homework_1.Barriers.Wall;
import Homework_1.Enums_PlayerStatus.PlayerStatus;
import Homework_1.Interfaces.JumpAndRunsPlayers;

import java.util.Random;

public class Robot implements JumpAndRunsPlayers {
    private final int RUN_DISTANCE;
    private final int JUMP_DISTANCE;
    private String name;
    private PlayerStatus playerStatus;

    public Robot(String name) {
        Random random = new Random();
        this.name = name;
        RUN_DISTANCE = 100 + random.nextInt(500);
        JUMP_DISTANCE = 150 + random.nextInt(200);
        playerStatus = PlayerStatus.IN_GAME;
    }

    public Robot(String name, int runDistance, int jumpDistance) {
        RUN_DISTANCE = runDistance;
        JUMP_DISTANCE = jumpDistance;
        this.name = name;
        playerStatus = PlayerStatus.IN_GAME;
    }


    @Override
    public void playerJump(Wall wall) {
        wall.info();
        if (wall.barrierPass(JUMP_DISTANCE)) {
            System.out.println(name + " перепрыгнул стену.");
        } else {
            System.out.println(name + " не смог перепрыгнуть стену.");
            playerStatus = PlayerStatus.GAME_OVER;
        }
    }

    @Override
    public void playerRun(Track track) {
        track.info();
        if (track.barrierPass(RUN_DISTANCE)) {
            System.out.println(name + " пробежал дистанцию.");
        } else {
            System.out.println(name + " не смог пробежать дистанцию.");
            playerStatus = PlayerStatus.GAME_OVER;
        }
    }

    @Override
    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    @Override
    public void barrierAttack(Barrier barrier) {
        if (barrier instanceof Track) {
            playerRun((Track) barrier);
        }
        if (barrier instanceof Wall) {
            playerJump((Wall) barrier);
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "RUN_DISTANCE=" + RUN_DISTANCE +
                ", JUMP_DISTANCE=" + JUMP_DISTANCE +
                ", name='" + name + '\'' +
                ", playerStatus=" + playerStatus +
                '}';
    }

    @Override
    public void info() {
        System.out.println(this.toString());
    }
}
