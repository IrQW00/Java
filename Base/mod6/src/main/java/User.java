public class User {

    private String login;
    private String email;
    public User() {
    }
    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email");
        } this.email = email;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login.length() < 5) {
            throw new IllegalArgumentException("Invalid login");
        } this.login = login;
    }
}
