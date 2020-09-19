package Homework_1.Interfaces;

import Homework_1.Barriers.Barrier;
import Homework_1.Enums_PlayerStatus.PlayerStatus;

/*
интерфейс для наших участников они все могут бегать и прыгать,
поэтому данный интерфейс наследует от интерфесов Run и Jump
 */

public interface JumpAndRunsPlayers extends Run,Jump {
    /*
        В теории препятствия будут разными, но конечный пользователь должен иметь возможность
        просто указать препятствия не подбирая логику.
        Поэтому разработчик должен обязательно реализовать метод для препятствий всех типов.
        для этого будет barrierAttack
     */
    void barrierAttack(Barrier barrier);
    PlayerStatus getPlayerStatus();
    void info();
}
