package com.aor.refactoring.example5;

public class RotateLeftCmd implements Command {

    private Position pos;
    public RotateLeftCmd(Position pos) {
        this.pos = pos;
    }
    public void execute() {
        pos.rotateLeft();
    }
}
