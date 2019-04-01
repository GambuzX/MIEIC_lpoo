package com.aor.refactoring.example5;

public class RotateRightCmd implements Command{

    private Position pos;
    public RotateRightCmd(Position pos) {
        this.pos = pos;
    }
    public void execute() {
        pos.rotateRight();
    }
}
