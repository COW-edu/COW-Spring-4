package practice.banghyunwoocrudapi.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public void createBoard(@RequestBody CreateBoardRequest createBoardRequest) {;
        boardService.createBoard(createBoardRequest);
    }

    @GetMapping("/boards")
    public List<BoardResponse> getAllPost(){
        return boardService.getAllPost();
    }
}
