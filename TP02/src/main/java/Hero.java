import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {

    private int x;
    private int y;

    public Hero(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        y -= 1;
        if (y < 0) y = 0;
    }

    public void moveDown() {
        y += 1;
    }

    public void moveLeft() {
        x -= 1;
        if (x < 0) x = 0;
    }

    public void moveRight() {
        x += 1;
    }

    public void draw(Screen screen) {
        screen.setCharacter(x, y, new TextCharacter('X'));
    }
}
