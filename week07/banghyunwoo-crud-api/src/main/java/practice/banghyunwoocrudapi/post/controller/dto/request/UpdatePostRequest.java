package practice.banghyunwoocrudapi.post.controller.dto.request;

import lombok.Getter;
import lombok.Setter;
import practice.banghyunwoocrudapi.member.entity.Member;
import practice.banghyunwoocrudapi.post.entity.Post;

@Getter
@Setter
public class UpdatePostRequest {
    private String title;
    private String content;
    private Member member;
}
