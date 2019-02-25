import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Game {

    private Screen screen;
    private Arena arena;

    public Game() throws IOException{
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);

        this.screen.setCursorPosition(null);
        this.screen.startScreen();
        this.screen.doResizeIfNecessary();

        arena = new Arena(12, 12);
    }

    private void draw() throws IOException {
        this.screen.clear();
        arena.draw(this.screen);
        this.screen.refresh();
    }

    public void run() {
        try {
            while(true) {
                draw();
                KeyStroke key = this.screen.readInput();

                if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') || key.getKeyType() == KeyType.EOF) {
                    this.screen.close();
                    break;
                }
                arena.processKey(key);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
