import java.util.Random;

public class Player {
    public enum VARIANTS {
        ROCK,
        PAPER,
        SCISSORS
    }
    private String name;
    private VARIANTS choice;

    // Конструктор устанавливает случайное значение из перечисления, а также имя «Bot».
    public Player() {
        Random random = new Random();
        VARIANTS[] values = VARIANTS.values();
        this.choice = values[random.nextInt(values.length)];
        this.name = "Bot";
    }

    // Конструктор принимает определенный вариант из перечисления и имя для объекта.
    public Player(VARIANTS choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    // Функция whoWins, которая принимает два объекта и возвращает либо строку «Ничья», либо информацию про игрока, который победил.
    public String whoWins(Player player1, Player player2) {
        if (player1.choice == player2.choice) {
            return "Ничья";
        } else if ((player1.choice == VARIANTS.ROCK && player2.choice == VARIANTS.SCISSORS) ||
                (player1.choice == VARIANTS.PAPER && player2.choice == VARIANTS.ROCK) ||
                (player1.choice == VARIANTS.SCISSORS && player2.choice == VARIANTS.PAPER)) {
            return "Победил игрок с именем: " + player1.name;
        } else {
            return "Победил игрок с именем: " + player2.name;
        }
    }
}
