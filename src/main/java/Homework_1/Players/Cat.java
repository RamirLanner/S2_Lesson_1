package Homework_1.Players;

import Homework_1.Barriers.Barrier;
import Homework_1.Barriers.Track;
import Homework_1.Barriers.Wall;
import Homework_1.Enums_PlayerStatus.PlayerStatus;
import Homework_1.Interfaces.JumpAndRunsPlayers;

import java.util.Random;


public class Cat implements JumpAndRunsPlayers {
    private final int RUN_DISTANCE;//максимальная дистанция участника
    private final int JUMP_DISTANCE;//максимальная дистанция участника
    private final String name;
    private PlayerStatus playerStatus;

    public Cat(String name, int runDistance, int jumpDistance) {
        RUN_DISTANCE = runDistance;
        JUMP_DISTANCE = jumpDistance;
        this.name = name;
        playerStatus = PlayerStatus.IN_GAME;
    }

    // этот конструктор просто для упрощения генерации случайных участников, при этом с поправкой что это коты..
    public Cat(String name) {
        Random random = new Random();
        this.name = name;
        RUN_DISTANCE = 100 + random.nextInt(150);
        JUMP_DISTANCE = 100 + random.nextInt(100);
        playerStatus = PlayerStatus.IN_GAME;
    }

    @Override//метод для перепрыгивания
    public void playerJump(Wall wall) {
        wall.info();
        if (wall.barrierPass(JUMP_DISTANCE)) {
            System.out.println(name + " перепрыгнул стену.");
        } else {
            System.out.println(name + " не смог перепрыгнуть стену.");
            playerStatus = PlayerStatus.GAME_OVER;
        }
    }

    @Override//метод для бега
    public void playerRun(Track track) {
        track.info();
        if (track.barrierPass(RUN_DISTANCE)) {
            System.out.println(name + " пробежал дистанцию.");
        } else {
            System.out.println(name + " не смог пробежать дистанцию.");
            playerStatus = PlayerStatus.GAME_OVER;
        }
    }

    @Override//для передачи статуса в игре или уже выбыл
    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    @Override//что бы пользователь не ломал голову и не подбирал метод под то или иное препядствие
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
        return "Cat{" +
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
