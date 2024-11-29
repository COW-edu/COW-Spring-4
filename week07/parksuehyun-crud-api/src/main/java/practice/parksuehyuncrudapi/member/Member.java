package practice.parksuehyuncrudapi.member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {
    private static long idCounter = 0;
    private final long id;
    private String name;
    private String email;
    private String password;

    @Builder
    private Member(String name, String email, String password) {
        this.id = ++idCounter;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public void updateProfile(String name, String email) {
        this.name = name;
        this.email = email;
    }

}


