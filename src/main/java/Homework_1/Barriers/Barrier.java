package Homework_1.Barriers;
/*
Абстрактный класс припятствий
Данный класс определяет основные характеристики бующего объекта и его поведеия.
При увеличении количества препятствий и усложнении можно еще больще абстрагироваться
Но по заданию это не потребовалось
 */
public abstract class Barrier {
    protected final int BARRIER_DISTANCE;

    public Barrier(int BARRIER_DISTANCE) {
        this.BARRIER_DISTANCE = BARRIER_DISTANCE;
    }

    public boolean barrierPass(int power){
        return power>=BARRIER_DISTANCE;
    }

    @Override
    public String toString() {
        return "Barrier{" +
                "BARRIER_DISTANCE=" + BARRIER_DISTANCE +
                '}';
    }

    public void info(){
        System.out.println(this.toString());
    }
}
