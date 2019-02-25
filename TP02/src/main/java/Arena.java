import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

public class Arena {

    private int width;
    private int height;

    private Hero hero;

    public Arena(int w, int h) {
        this.width = w;
        this.height = h;

        this.hero = new Hero(10, 10);
    }

    public void draw(Screen screen) {
        hero.draw(screen);
    }

    private void moveHero(Position position) {
        this.hero.setPosition(position);
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            default:
                System.out.println(key);
                break;
        }
    }
}
