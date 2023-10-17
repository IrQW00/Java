import java.io.*;
import java.util.Arrays;

class User implements Serializable {
    private String name;
    private String login;
    private int age;

    private String hobbies;

    public User(String name, String login, int age, String hobbies) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Пользователь: " +
                name +
                " с логином: " + login +
                ". Его возраст: " + age +
                ". Все хобби: " + hobbies;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите имя: ");
            String name = reader.readLine();
            System.out.print("Введите логин: ");
            String login = reader.readLine();
            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(reader.readLine());
            System.out.print("Введите хобби через запятую: ");
            String hobbies = reader.readLine();
            User user = new User(name, login, age, hobbies);

            // Сериализация объекта
            FileOutputStream fileOut = new FileOutputStream("user.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user);
            out.close();
            fileOut.close();

            // Десериализация объекта
            FileInputStream fileIn = new FileInputStream("user.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            User deserializedUser = (User) in.readObject();
            in.close();
            fileIn.close();

            System.out.println(deserializedUser.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
