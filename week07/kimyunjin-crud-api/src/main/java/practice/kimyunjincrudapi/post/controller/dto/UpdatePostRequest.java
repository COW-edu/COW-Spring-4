package practice.kimyunjincrudapi.post.controller.dto;

import lombok.Getter;

@Getter
public class UpdatePostRequest {
    private String title;
    private String content;
}
