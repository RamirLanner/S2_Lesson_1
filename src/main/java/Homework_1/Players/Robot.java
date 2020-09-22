package Homework_1.Players;

import Homework_1.Enums_PlayerStatus.PlayerStatus;
import Homework_1.Interfaces.JumpAndRunsPlayers;

import java.util.Random;

public class Robot implements JumpAndRunsPlayers {
    private final int runDistance;
    private final int jumpDistance;
    private final String name;
    private PlayerStatus playerStatus;

    public Robot(String name) {
        Random random = new Random();
        this.name = name;
        runDistance = 100 + random.nextInt(500);
        jumpDistance = 150 + random.nextInt(200);
        playerStatus = PlayerStatus.IN_GAME;
    }

    public Robot(String name, int runDistance, int jumpDistance) {
        this.runDistance = runDistance;
        this.jumpDistance = jumpDistance;
        this.name = name;
        playerStatus = PlayerStatus.IN_GAME;
    }

    @Override
    public int getPlayerJumpHeight() {
        return this.jumpDistance;
    }

    @Override
    public int getPlayerRunDistance() {
        return this.runDistance;
    }

    @Override//для передачи статуса в игре или уже выбыл
    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    @Override
    public void setPlayerStatus(PlayerStatus status) {
        this.playerStatus = status;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "RUN_DISTANCE=" + runDistance +
                ", JUMP_DISTANCE=" + jumpDistance +
                ", name='" + name + '\'' +
                ", playerStatus=" + playerStatus +
                '}';
    }

    @Override
    public void info() {
        System.out.println(this.toString());
    }
}
