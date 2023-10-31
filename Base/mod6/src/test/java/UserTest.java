import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    //Функция тестирует можем ли мы создать объект на основе класса User, передав в него 2 параметра;
    @Test
    public void testCreateUserWithParam() {
        String login = "username";
        String email = "test@email.com";
        User user = new User(login, email);
        assertEquals(login, user.getLogin());
        assertEquals(email, user.getEmail());
    }

    //Функция тестирует можем ли мы создать объект на основе класса User, при этом не передав в него параметров;
    @Test
    public void testCreateUserWithoutParam() {
        User user = new User();
        assertNull(user.getLogin());
        assertNull(user.getEmail());
    }

    //Функция тестирует можно ли установить неккоректный Email адрес в переменную email в классе User.
    @Test
    public void testSetInvalidEmail() {
        User user = new User();
        String invalidEmail = "testemail.com";
        try {
            user.setEmail(invalidEmail);
        }
        catch (IllegalArgumentException e) {}
    }

    //Функция тестирует можно ли установить логин менее 5 символов в переменную login в классе User
    @Test
    public void testSetInvalidLogin() {
        User user = new User();
        String invalidLogin = "test";
        try {
            user.setLogin(invalidLogin);
        }
        catch (IllegalArgumentException e) {}
    }
}
