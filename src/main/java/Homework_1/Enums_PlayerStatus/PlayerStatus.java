package Homework_1.Enums_PlayerStatus;
/*
Статус участника
 */
public enum PlayerStatus {
    IN_GAME("Участник в Игре"),
    GAME_OVER("Участник выбыл"),
    PLAYER_WIN("Участник прошел дистанцию");

    private String russianTitle;

    PlayerStatus(String russianTitle) {
        this.russianTitle = russianTitle;
    }

    @Override
    public String toString() {
        return russianTitle;
    }
}
