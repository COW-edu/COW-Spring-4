package practice.banghyunwoocrudapi.board;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class BoardRepository {
    private final Map<Integer, Board> boardRepository= new ConcurrentHashMap<>();
    private int id;

    public void save(Board board) {
        ++id;
        board.setId(id);
        boardRepository.put(id,board);
    }

    public List<BoardResponse> getAllPost() {
        return boardRepository.entrySet().stream().map(entry -> BoardResponse.from(entry.getValue())).collect(Collectors.toList());
    }

    public Board getPost(int id) {
        return boardRepository.get(id);
    }
}
