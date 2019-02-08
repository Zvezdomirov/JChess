import com.chess.engine.game.Board;
import com.chess.engine.game.ChessTile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTests {

    Board board;

    @BeforeEach
    public void createBoard() {
        board = new Board();
    }

}
