package practice.parksuehyuncrudapi.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponse {
    private String username;
    private String email;
}
