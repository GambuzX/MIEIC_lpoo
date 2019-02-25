import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int width;
    private int height;

    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena(int w, int h) {
        this.width = w;
        this.height = h;

        this.hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);

        for (Wall wall : walls)
            wall.draw(graphics);

        for (Coin coin : coins)
            coin.draw(graphics);

        for (Monster monster : monsters)
            monster.draw(graphics);
    }

    private List<Wall> createWalls() {

        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height-1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();

        int added = 0;
        while (added < 10) {
            Position new_position = new Position ( random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);

            if (!coinAtPosition(new_position)) {
                coins.add(new Coin(new_position.getX(), new_position.getY()));
                added++;
            }
        }
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();

        int added = 0;
        while (added < 5) {
            Position new_position = new Position ( random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);

            if (!monsterAtPosition(new_position)) {
                monsters.add(new Monster(new_position.getX(), new_position.getY()));
                added++;
            }
        }
        return monsters;
    }

    private boolean canHeroMove(Position position) {
        boolean can_move = false;
        if (position.getX() >= 0 && position.getX() < width && position.getY() >= 0 && position.getY() < height) {
            can_move = true;
        }

        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                return false;
            }
        }
        return can_move;
    }

    private boolean coinAtPosition(Position position) {
        if (coins == null)
            return false;

        for(Coin coin : coins)
            if (coin.getPosition().equals(position))
                return true;
        return false;
    }

    private boolean monsterAtPosition(Position position) {
        if (monsters == null)
            return false;

        for(Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }

    private void moveHero(Position position) {
        if (canHeroMove(position)) {
            this.hero.setPosition(position);
            retrieveCoins(position);
        }
    }

    private void moveMonsters() {
        for (Monster monster : monsters) {
            monster.setPosition(monster.move(width, height));
        }
    }

    private boolean verifyMonsterCollisions(Position position) {
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(position))
                return true;
        }
        return false;
    }

    private void retrieveCoins(Position position) {
        for (Coin coin : coins) {
            if (coin.getPosition().equals(position)) {
                coins.remove(coin);
                break;
            }
        }
    }

    public int processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                if (verifyMonsterCollisions(hero.getPosition())) return -1;
                moveMonsters();
                if (verifyMonsterCollisions(hero.getPosition())) return -1;
                break;

            case ArrowDown:
                moveHero(hero.moveDown());
                if (verifyMonsterCollisions(hero.getPosition())) return -1;
                moveMonsters();
                if (verifyMonsterCollisions(hero.getPosition())) return -1;
                break;

            case ArrowLeft:
                moveHero(hero.moveLeft());
                if (verifyMonsterCollisions(hero.getPosition())) return -1;
                moveMonsters();
                if (verifyMonsterCollisions(hero.getPosition())) return -1;
                break;

            case ArrowRight:
                moveHero(hero.moveRight());
                if (verifyMonsterCollisions(hero.getPosition())) return -1;
                moveMonsters();
                if (verifyMonsterCollisions(hero.getPosition())) return -1;
                break;

            default:
                System.out.println(key);
                break;
        }
        return 0;
    }
}
