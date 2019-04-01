package com.aor.refactoring.example5;

public class Turtle {

    private Position pos;

    public Turtle(int row, int column, char direction) {
        this.pos = new Position(row, column, direction);
    }

    public int getRow() {
        return pos.getRow();
    }

    public int getColumn() {
        return pos.getColumn();
    }

    public char getDirection() {
        return pos.getDirection();
    }

    public Position getPos() {
        return pos;
    }

    public void execute(Command command) {
        command.execute();
    }
}
