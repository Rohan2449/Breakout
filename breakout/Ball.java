package breakout;

import utilities.GDV5;

import java.awt.*;

public class Ball extends Rectangle  {
    private static int ballsOnScreen= 1;
   private static int xVelocity = 0;
   private static int yVelocity = 15;
    private static int speed = 12;
    private Color ballColor = Color.orange;
   private static boolean canStart = true;
    private static boolean move = false;

    private int numPierces = 0;
    private boolean canPierce;
private boolean paddleMade = false;

    public Ball(int length) {
        super((GDV5.getMaxWindowX() -length)/2,(GDV5.getMaxWindowY()-length)/3, length,length);
        canPierce = true;

    }
    public void ballBoundries(){
        if (this.getX() < 0) {
           xVelocity = Math.abs(xVelocity);
        }
        if (this.getX() + this.getWidth() > GDV5.getMaxWindowX()) {
            xVelocity = -Math.abs(xVelocity);
        }
        if (this.getY() < 0) {
            yVelocity = Math.abs(yVelocity);
        }
        if (this.getY() > GDV5.getMaxWindowY() + 20) {
            ballsOnScreen--;

            move = false;
        }

    }
    public static int calcYSpeed(){
        return (int)(Math.sqrt(Math.abs(Math.pow(speed,2)) - Math.pow(xVelocity,2)));
    }
    public void resetBall(){
        if (ballsOnScreen == 0) {

            this.setLocation((int) (GDV5.getMaxWindowX() - this.getWidth()) / 2, (int) (GDV5.getMaxWindowY() - this.getHeight()) / 3);
            canStart = true;
            ballsOnScreen++;
            BreakoutRunner.lowerLives();

        }
    }

    public void drawBall(Graphics2D pb){
        pb.setColor(ballColor);
        pb.fill(this);
    }

    public void velocity(int xS, int yS) {
            this.x += xS;
            this.y += yS;

    }

    public void powerPierce(){
        numPierces = 3;
    }
    public void ballMotion(Paddle paddle1){
        if(BreakoutRunner.getGameLevel() ==1){
            speed = 12;
        }
        if(BreakoutRunner.getGameLevel() ==2){
            speed = 17;
        }
        if(BreakoutRunner.getGameLevel() == 3) {
            speed = 22;
            //paddle1.setLocation(GDV5.getMaxWindowX(), GDV5.getMaxWindowY() + 200);
          /*  if (paddleMade == false) {
                paddleMade = true;
                paddle1 = new Paddle((GDV5.getMaxWindowX() - Paddle.getPaddleWidth()) / 2, GDV5.getMaxWindowY() - Paddle.getPaddleHeight() * 3, 75, 20);
            }
            */

        }

        if(move) {
            this.velocity(xVelocity, yVelocity);
        }

        if (this.intersects(paddle1)) {

            double ballPaddleLoc = this.getCenterX() - paddle1.getCenterX();
            xVelocity = (int) (ballPaddleLoc / 7);
            yVelocity = -calcYSpeed();

            if (xVelocity == 0) {
                xVelocity = 1;
            }
        }
    }







    public static void setBallsOnScreen(int ballsOnScreen) {
        Ball.ballsOnScreen = ballsOnScreen;
    }

    public static int getxVelocity() {
        return xVelocity;
    }

    public static void setxVelocity(int xVelocity) {
        Ball.xVelocity = xVelocity;
    }

    public static int getyVelocity() {
        return yVelocity;
    }

    public static void setyVelocity(int yVelocity) {
        Ball.yVelocity = yVelocity;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Ball.speed = speed;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
    }

    public static boolean isCanStart() {
        return canStart;
    }

    public static void setCanStart(boolean canStart) {
        Ball.canStart = canStart;
    }

    public static boolean isMove() {
        return move;
    }

    public static void setMove(boolean move) {
        Ball.move = move;
    }

    public int getNumPierces() {
        return numPierces;
    }

    public void setNumPierces(int numPierces) {
        this.numPierces = numPierces;
    }

    public boolean isCanPierce() {
        return canPierce;
    }
    public static int getBallsOnScreen() {
        return ballsOnScreen;
    }

    public void setCanPierce(boolean canPierce) {
        this.canPierce = canPierce;
    }
}
