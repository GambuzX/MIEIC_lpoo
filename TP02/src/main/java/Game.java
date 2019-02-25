import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;
import java.io.IOException;

public class Game {

    private Screen screen;
    private int x = 10;
    private int y = 10;

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);

            this.screen.setCursorPosition(null);
            this.screen.startScreen();
            this.screen.doResizeIfNecessary();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        this.screen.clear();
        this.screen.setCharacter(x, y, new TextCharacter('X'));
        this.screen.refresh();
    }

    private void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                y -= 1;
                break;
            case ArrowDown:
                y += 1;
                break;
            case ArrowLeft:
                x -= 1;
                break;
            case ArrowRight:
                x += 1;
                break;
            default:
                System.out.println(key);
                break;
        }
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
                processKey(key);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
