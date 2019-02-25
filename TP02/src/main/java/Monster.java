import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {


    public Monster(int x, int y) {
        super(x,y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "Y");
    }

    public Position move(int width, int height) {
        Random random = new Random();
        Position newPos = position;

        boolean valid_choice = false;
        while (!valid_choice) {
            int choice = random.nextInt(4);
            switch (choice) {
                case 0:
                    newPos = new Position(position.getX() - 1, position.getY());
                    break;
                case 1:
                    newPos = new Position(position.getX() + 1, position.getY());
                    break;
                case 2:
                    newPos = new Position(position.getX(), position.getY() - 1);
                    break;
                case 3:
                    newPos = new Position(position.getX(), position.getY() + 1);
                    break;
                default:
                    newPos = position;
            }
            if (newPos.getX() > 0 && newPos.getX() < width-1 && newPos.getY() > 0 && newPos.getY() < height-1)
                valid_choice = true;
        }
        return newPos;
    }
}
