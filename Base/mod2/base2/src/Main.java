public class Main {
    public static void main(String[] args){

        Player bot = new Player();
        Player alex = new Player(Player.VARIANTS.SCISSORS, "Alex");

        // Получаем результат
        System.out.println(bot.whoWins(bot, alex));

    }
}