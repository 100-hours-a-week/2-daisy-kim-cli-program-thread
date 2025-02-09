package services;
import models.User;

public class UserService {
    private User user;
    private boolean isLoggedIn = false;

    public UserService() {
        this.user = new User("김다은", "daisy", "1234");
    }

    public boolean login(String userId, String password) {
        if (user.login(userId, password)) {
            isLoggedIn = true;
            System.out.println("✅ 로그인 성공! 환영합니다, " + user.getName() + "님.");
            return true;
        } else {
            System.out.println("❌ 로그인 실패! 아이디 또는 비밀번호가 잘못되었습니다.");
            return false;
        }
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public User getUser() {
        return user;
    }
}