package practice.parksuehyuncrudapi.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdatePostRequest {
    private String title;
    private String content;
}
