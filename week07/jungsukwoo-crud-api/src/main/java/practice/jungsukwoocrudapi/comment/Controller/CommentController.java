package practice.jungsukwoocrudapi.comment.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.jungsukwoocrudapi.comment.entity.Comment;
import practice.jungsukwoocrudapi.comment.service.CommentService;
import practice.jungsukwoocrudapi.member.controller.dto.request.CreateMemberRequest;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private CommentService commentService;

    @PostMapping()
    public void commentUp(@RequestBody CreateMemberRequest createMemberRequest){
        memberService.commentUp(createMemberRequest);
    }
}
