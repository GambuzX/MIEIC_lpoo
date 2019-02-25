import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
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

        arena = new Arena(60, 20);
    }

    private void draw() throws IOException {
        this.screen.clear();
        arena.draw(screen.newTextGraphics());
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
                int status = arena.processKey(key);
                if (status == -1) {
                    this.screen.close();
                    System.out.println("You dieded!!!! :(");
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
