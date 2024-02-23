package src;

import utilities.GDV5;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {
    private static int paddleWidth = 150;
    private static int paddleHeight = 20;
    private static int paddleSpeed = 18;
    private Color paddleColor = Color.black;


    public Paddle(int x, int y , int width, int height) {
        super(x,y, width ,height);
    }
    public void right() {
        translate(paddleSpeed,0);
    }
    public void left() {
        translate(-1 * paddleSpeed,0);
    }

    public void drawPaddle(Graphics2D pb){
            pb.setColor(paddleColor);
            pb.fill(this);
    }
    public void paddleMovement(){
        if (this.getX() > 0) {
            if (GDV5.KeysPressed[KeyEvent.VK_LEFT]) {
                this.left();
            }
        }
        if (this.getX() + this.getWidth() < GDV5.getMaxWindowX()) {
            if (GDV5.KeysPressed[KeyEvent.VK_RIGHT]) {
                this.right();
            }
        }
    }

    public void resetPaddle() {
        if (Ball.getBallsOnScreen() == 0) {
            this.setLocation((GDV5.getMaxWindowX() - Paddle.paddleWidth) / 2, GDV5.getMaxWindowY() - Paddle.paddleHeight * 3);
        }
    }

    public static int getPaddleWidth() {
        return paddleWidth;
    }


    public static int getPaddleHeight() {
        return paddleHeight;
    }


}
