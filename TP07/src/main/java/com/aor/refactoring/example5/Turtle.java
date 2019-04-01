package com.aor.refactoring.example5;

public class Turtle {

    private class Position {
        public int column;
        public int row;

        public Position(int r, int c) {
            column = c;
            row = r;
        }
    }

    private Position pos;
    private char direction;

    public Turtle(int row, int column, char direction) {
        this.pos = new Position(row, column);
        this.direction = direction;
    }

    public int getRow() {
        return pos.row;
    }

    public int getColumn() {
        return pos.column;
    }

    public char getDirection() {
        return direction;
    }

    public void execute(char command) {
        if (command == 'L') {
            rotateLeft();
        } else if (command == 'R') {
            rotateRight();
        } else if (command == 'F'){
            moveForward();
        }
    }

    private void rotateLeft() {
        if (direction == 'N') direction = 'W';
        else if (direction == 'W') direction = 'S';
        else if (direction == 'S') direction = 'E';
        else if (direction == 'E') direction = 'N';
    }

    private void rotateRight() {
        if (direction == 'N') direction = 'E';
        else if (direction == 'E') direction = 'S';
        else if (direction == 'S') direction = 'W';
        else if (direction == 'W') direction = 'N';
    }

    private void moveForward() {
        if (direction == 'N') pos.row--;
        if (direction == 'S') pos.row++;
        if (direction == 'W') pos.column--;
        if (direction == 'E') pos.column++;
    }
}
