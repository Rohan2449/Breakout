package src;
import utilities.GDV5;

import java.awt.*;

public class Brick extends Rectangle{
     private static Color brickColor = Color.gray;
    private static int xBrick = 2;
    private static int yBrick = 0;


    //Width 145
    //Height 25
    private static int brickWidth = 145;
    private static int brickHeight = 25;
    private static int brickRow = GDV5.getMaxWindowX()/(brickWidth+5);
    private  static int row = 5;
    private static Brick[] bricks = new Brick[brickRow * row];

    private static int numBricks = brickRow * row;

    private boolean exists;

    public Brick(int x, int y, int w, int h){
        super(x,y, w,h );
         exists = true;

    }

    public static void setNumBricks(int numBricks) {
        Brick.numBricks = numBricks;
    }

    public static int getNumBricks() {
        return numBricks;
    }

    public boolean isExists() {
        return exists;
    }

    public static Brick[] getBricks() {
        return bricks;
    }

    public void breakBrick(){

        exists = false;
        Particle.makeParticles(this);

    }
    public static void createBricks(){
        for(int i =0; i < row * brickRow; i++){
            bricks[i]  = new Brick(xBrick, yBrick, brickWidth, brickHeight);
            xBrick += brickWidth +5;
            if(xBrick + brickWidth> GDV5.getMaxWindowX()){
                xBrick = 2;
                yBrick += brickHeight + 5;
            }
        }
    }
    public static void resetAllBricks(){
        for (Brick b : Brick.bricks) {
            b.exists = true;
        }
        numBricks = row * brickRow;
    }

    public static void drawBricks(Graphics2D pb){
        pb.setColor(brickColor);
        for (Brick b: Brick.bricks){
            if(b.exists) {
                pb.fill(b);
            }
        }
    }


   }

