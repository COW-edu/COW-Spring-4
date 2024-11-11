package practice.banghyunwoocrudapi.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(CreateBoardRequest createBoardRequest) {
        Board board = createBoardRequest.toEntity();
        boardRepository.save(board);
    }
}
