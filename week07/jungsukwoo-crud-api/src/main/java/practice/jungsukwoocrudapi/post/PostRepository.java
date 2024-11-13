package practice.jungsukwoocrudapi.post;

import practice.jungsukwoocrudapi.member.Member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostRepository {
    private final Map<String, Member> postRepository = new ConcurrentHashMap<>();

}
