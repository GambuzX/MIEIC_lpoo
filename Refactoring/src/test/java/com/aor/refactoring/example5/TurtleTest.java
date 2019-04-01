package com.aor.refactoring.example5;

import org.junit.Test;

import static org.junit.Assert.*;

public class TurtleTest {

    @Test
    public void testRotateLeft() {
        Turtle turtle = new Turtle(5, 5, 'N');
        Command rotateLeft = new RotateLeftCmd(turtle.getPos());
        turtle.execute(rotateLeft); assertEquals('W', turtle.getDirection());
        turtle.execute(rotateLeft); assertEquals('S', turtle.getDirection());
        turtle.execute(rotateLeft); assertEquals('E', turtle.getDirection());
        turtle.execute(rotateLeft); assertEquals('N', turtle.getDirection());
        assertEquals(5, turtle.getRow());
        assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testRotateRight() {
        Turtle turtle = new Turtle(5, 5, 'N');
        Command rotateRight = new RotateRightCmd(turtle.getPos());
        turtle.execute(rotateRight); assertEquals('E', turtle.getDirection());
        turtle.execute(rotateRight); assertEquals('S', turtle.getDirection());
        turtle.execute(rotateRight); assertEquals('W', turtle.getDirection());
        turtle.execute(rotateRight); assertEquals('N', turtle.getDirection());
        assertEquals(5, turtle.getRow());
        assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testForward() {
        Turtle turtleN = new Turtle(5, 5, 'N');
        Command moveForward = new MoveForwardCmd(turtleN.getPos());
        turtleN.execute(moveForward);
        assertEquals(4, turtleN.getRow());
        assertEquals(5, turtleN.getColumn());

        Turtle turtleW = new Turtle(5, 5, 'W');
        Command moveForward2 = new MoveForwardCmd(turtleW.getPos());

        turtleW.execute(moveForward2);
        assertEquals(5, turtleW.getRow());
        assertEquals(4, turtleW.getColumn());

        Turtle turtleS = new Turtle(5, 5, 'S');
        Command moveForward3 = new MoveForwardCmd(turtleS.getPos());

        turtleS.execute(moveForward3);
        assertEquals(6, turtleS.getRow());
        assertEquals(5, turtleS.getColumn());

        Turtle turtleE = new Turtle(5, 5, 'E');
        Command moveForward4 = new MoveForwardCmd(turtleE.getPos());

        turtleE.execute(moveForward4);
        assertEquals(5, turtleE.getRow());
        assertEquals(6, turtleE.getColumn());
    }

}