package practice.banghyunwoocrudapi.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(CreateBoardRequest createBoardRequest) {
        Board board = createBoardRequest.toEntity();
        boardRepository.save(board);
    }

    public List<BoardResponse> getAllPost() {
        return boardRepository.getAllPost();
    }

    public BoardResponse getPost(int id) {
        Board board = boardRepository.getPost(id);
        return BoardResponse.from(board);
    }
}
