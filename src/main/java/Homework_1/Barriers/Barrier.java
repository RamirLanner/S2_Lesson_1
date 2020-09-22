package Homework_1.Barriers;

import Homework_1.Interfaces.JumpAndRunsPlayers;

/*
Абстрактный класс припятствий
Данный класс определяет основные характеристики бующего объекта и его поведеия.
При увеличении количества препятствий и усложнении можно еще больще абстрагироваться
Но по заданию это не потребовалось
 */
public abstract class Barrier {
    protected final int barrierDistance;

    public Barrier(int barrierDistance) {
        this.barrierDistance = barrierDistance;
    }

    @Override
    public String toString() {
        return "Barrier{" +
                "BARRIER_DISTANCE=" + barrierDistance +
                '}';
    }

    public void info(){
        System.out.println(this.toString());
    }

    //логика прохождения препятствий ушла сюда
    abstract public boolean barrierPass(JumpAndRunsPlayers player);

}
