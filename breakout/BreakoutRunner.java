package breakout;

import utilities.GDV5;

import java.awt.*;
import java.awt.event.KeyEvent;


public class BreakoutRunner extends GDV5 {

    /**
     * 0- Main Menu
     * 1- Run Game
     * 2- Winner Screen
     * 3- Loser Screen
     */

    private int gameStatus = 0;
    private static int gameLevel = 1;
    public static void lowerLives() {
         lives--;
    }

    public static int getGameLevel() {
        return gameLevel;
    }

    private static int lives = 3;

    public static int getLives() {
        return lives;
    }

    private Ball ball1 = new Ball(20);
    private Paddle paddle1 = new Paddle((GDV5.getMaxWindowX()-Paddle.getPaddleWidth())/2, GDV5.getMaxWindowY()-Paddle.getPaddleHeight()*3, Paddle.getPaddleWidth(), Paddle.getPaddleHeight());
    private UserInterface ui = new UserInterface();
    static BreakoutRunner bo = new BreakoutRunner();


    public BreakoutRunner(){
        Brick.createBricks();

    }
    public  void keyInputs() {
        if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
            gameStatus = 1;
        }
        if (gameStatus == 2 || gameStatus == 3) {
            if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE]) {
                gameStatus = 0;
                lives = 3;
                Brick.resetAllBricks();
                paddle1.setLocation((GDV5.getMaxWindowX() - Paddle.getPaddleWidth()) / 2, GDV5.getMaxWindowY() - Paddle.getPaddleHeight() * 3);
                gameLevel =1;
            }
        }


        //set ball in motion
        if (gameStatus == 1) {
            if (Ball.isCanStart() && KeysPressed[KeyEvent.VK_SPACE]) {
                Ball.setMove(true);
                Ball.setCanStart(false);
                Ball.setxVelocity(0);
            }
            if(ball1.isCanPierce() && KeysPressed[KeyEvent.VK_Q]){
                ball1.powerPierce();
                ball1.setCanPierce(false);
                System.out.println("Power UP");
            }
        }
    }

    public void brickCollision(){
        for (Brick b : Brick.getBricks()) {
            if (ball1.intersects(b) && b.isExists()) {
                Particle.setParticleCounter(20);
                b.breakBrick();
                Particle.moveParticles();




                Brick.setNumBricks(Brick.getNumBricks()-1);
            if(ball1.getNumPierces() > 0){
                ball1.setNumPierces(ball1.getNumPierces()-1);
            }
                // Returns the direction of collision (0 = right, 1 - top, 2 - left , 3 -Bottom
                if (ball1.getNumPierces() == 0) {
                    int direction = collisionDirection(b, ball1, Ball.getxVelocity(), Ball.getyVelocity());
                    if (direction == 1) {
                        Ball.setyVelocity( -Math.abs(Ball.getyVelocity()));
                    }
                    if (direction == 3) {
                        Ball.setyVelocity(Math.abs(Ball.getyVelocity()));
                    }

                    if (direction == 0) {
                        Ball.setxVelocity(Math.abs(Ball.getxVelocity())) ;
                    }
                    if (direction == 2) {
                        Ball.setxVelocity( -Math.abs(Ball.getxVelocity()));;
                    }
                }
            }
        }
        if(Particle.getParticleCounter() >0){
            Particle.moveParticles();
            Particle.setParticleCounter(Particle.getParticleCounter()-1);
        }
    }

    public void nextLevel(){
            ball1.resetBall();
            paddle1.resetPaddle();
            gameLevel++;
            Brick.resetAllBricks();
    }


    public static void main(String[] args) {

        bo.setBackground(Color.WHITE);
        bo.setTitle("");
        bo.start();


    }
    @Override
    public void update() {
        ball1.ballMotion(paddle1);

        //key inputs
            bo.keyInputs();
            ball1.ballBoundries();
            paddle1.paddleMovement();
            bo.brickCollision();
            if(Ball.getBallsOnScreen() == 0) ball1.resetBall();
            paddle1.resetPaddle();
            if(gameLevel <= 2 && Brick.getNumBricks() == 0) bo.nextLevel();
            if(lives == 0){
                gameStatus = 3;}
            if(Brick.getNumBricks() == 0 && gameLevel >2){
                gameStatus = 2;}
    }




    @Override
    public void draw(Graphics2D win) {
        if(Particle.getParticleCounter()>0)
                Particle.drawParticles(win);



        if(gameStatus ==0) {
            ui.mainMenu(win);
        }
        if(gameStatus ==1) {
            Brick.drawBricks(win);
            ball1.drawBall(win);
            paddle1.drawPaddle(win);
            ui.drawScoreBoard(win);

        }
        if(gameStatus == 2){
            ui.gameWIn(win);
        }
        if(gameStatus == 3) {

            ui.gameLoss(win);
        }
    }
}
