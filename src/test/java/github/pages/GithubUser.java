package github.pages;

public class GithubUser {
    public static final GithubUser DEFAULT_USER = new GithubUser("annaek", "WestHaven2020!");
    private final String login;
    private final String password;

    public GithubUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
