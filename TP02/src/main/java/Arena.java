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

    private boolean canHeroMove(Position position) {
        if (position.getX() > 0 && position.getX() < width && position.getY() > 0 && position.getY() < height)
            return true;
        return false;
    }

    private void moveHero(Position position) {
        if (canHeroMove(position))
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
