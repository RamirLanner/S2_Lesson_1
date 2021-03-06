package Homework_1;

import Homework_1.Barriers.Barrier;
import Homework_1.Barriers.Track;
import Homework_1.Barriers.Wall;
import Homework_1.Enums_PlayerStatus.PlayerStatus;
import Homework_1.Interfaces.JumpAndRunsPlayers;
import Homework_1.Players.Cat;
import Homework_1.Players.Human;
import Homework_1.Players.Robot;

import java.util.Random;

public class Start {

    private static Random random = new Random();
    private static int playersCount = 3 + random.nextInt(5);
    private static int barrierCount = 5 + random.nextInt(5);

    private static Barrier[] barriers = new Barrier[barrierCount];
    private static JumpAndRunsPlayers[] jumpAndRunsPlayers = new JumpAndRunsPlayers[playersCount];

    public static void main(String[] args) {

        addBarriers(barriers);

        addPlayers(jumpAndRunsPlayers);

        startGame(jumpAndRunsPlayers,barriers);

    }

    private static void startGame(JumpAndRunsPlayers[] jumpAndRunsPlayers, Barrier[] barriers) {
        //начало прохождения линии препятствий
        for (JumpAndRunsPlayers pl : jumpAndRunsPlayers) {
            pl.info();
            int barrierCounter = 0;//Это для только для вывода что участник прошел всю дистанцию
            for (Barrier br : barriers) {
                if (pl.getPlayerStatus() != PlayerStatus.GAME_OVER) {
                    if (br.barrierPass(pl)) {
                        System.out.printf("%s преодолел препятствие\n", pl.getClass().getSimpleName());
                    } else {
                        pl.setPlayerStatus(PlayerStatus.GAME_OVER);
                        System.out.printf("%s не смог преодолеть препятствие и проиграл\n", pl.getClass().getSimpleName());
                    }
                }
            }
            if (pl.getPlayerStatus() != PlayerStatus.GAME_OVER) {
                System.out.println("Участник успешно прошел всю дистанцию!!! Поздравляем)");
            }
            System.out.println("\n");
        }
    }

    private static void addPlayers(JumpAndRunsPlayers[] pl) {
        //рандомно заполняю участников
        for (int i = 0; i < pl.length; i++) {
            int j = random.nextInt(3);
            switch (j) {
                case 0 -> pl[i] = new Cat("Cat player #" + (i + 1));
                case 1 -> pl[i] = new Human("Human player #" + (i + 1));
                case 2 -> pl[i] = new Robot("robot player #" + (i + 1));
            }
        }
    }

    private static void addBarriers(Barrier[] br) {
        //рандомно заполняю препятствия
        for (int i = 0; i < br.length; i++) {
            int j = random.nextInt(2);
            if (j == 1) {
                br[i] = new Track((75 + random.nextInt(50)));
            } else {
                br[i] = new Wall((50 + random.nextInt(150)));
            }
        }
    }


}
