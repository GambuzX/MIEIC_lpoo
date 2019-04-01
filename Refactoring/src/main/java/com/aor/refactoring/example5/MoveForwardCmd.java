package com.aor.refactoring.example5;

public class MoveForwardCmd implements Command{

    private Position pos;
    public MoveForwardCmd(Position pos) {
        this.pos = pos;
    }
    public void execute() {
        pos.moveForward();
    }
}
