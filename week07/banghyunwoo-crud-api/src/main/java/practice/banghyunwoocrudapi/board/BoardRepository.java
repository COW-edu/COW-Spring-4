package practice.banghyunwoocrudapi.board;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BoardRepository {
    private final Map<Integer, Board> boardRepository= new ConcurrentHashMap<>();
    private int id;

    public void save(Board board) {
        ++id;
        boardRepository.put(id,board);
    }
}
