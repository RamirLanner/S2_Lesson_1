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
    public static void main(String[] args) {
        Random random = new Random();
        int playersCount = 3+random.nextInt(5);
        int barrierCount = 5+ random.nextInt(5);

        Barrier[] barriers = new Barrier[barrierCount];
        JumpAndRunsPlayers[] jumpAndRunsPlayers = new JumpAndRunsPlayers[playersCount];

        //рандомно заполняю препятствия
        for (int i =0; i < barriers.length; i++){
            int j = random.nextInt(2);
            if(j==1){
                barriers[i] = new Track((75+random.nextInt(50)));
            }
            else {
                barriers[i] = new Wall((50+random.nextInt(150)));
            }
        }

        //рандомно заполняю участников
        for (int i =0; i < jumpAndRunsPlayers.length; i++){
            int j = random.nextInt(3);
            switch (j) {
                case 0 -> jumpAndRunsPlayers[i] = new Cat("Cat player #" + (i+1));
                case 1 -> jumpAndRunsPlayers[i] = new Human("Human player #" + (i+1));
                case 2 -> jumpAndRunsPlayers[i] = new Robot("robot player #" + (i+1));
            }
        }

        //начало прохождения линии препятствий
        for (JumpAndRunsPlayers pl:jumpAndRunsPlayers) {
            pl.info();
            int barrierCounter = 0;//Это для только для вывода что участник прошел всю дистанцию
            for (Barrier br:barriers) {
                if (pl.getPlayerStatus() != PlayerStatus.GAME_OVER){
                    barrierCounter++;
                    pl.barrierAttack(br);
                    if ((barrierCounter == barriers.length)&&(pl.getPlayerStatus() != PlayerStatus.GAME_OVER)){
                        System.out.println("WIN");
                    }
                }
            }
            System.out.println("\n");
        }


    }
}
