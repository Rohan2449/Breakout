package src;

import utilities.GDV5;

import java.awt.*;

public class UserInterface {

    private static Font fgtSS = new Font("Founders Grotesk Text", Font.BOLD, 10);
    private static Font fgtS =new Font("Founders Grotesk Text",Font.BOLD, 25);

    private static Font fgt =new Font("Founders Grotesk Text",Font.BOLD, 40);
    private String name = "Rohan";


    public static void drawCenteredString(String str, int desiredX,int desiredY, Graphics2D win){
        FontMetrics fm = win.getFontMetrics();
        int x = desiredX - fm.stringWidth(str) /2;
        int y = desiredY + fm.getHeight()/2 ;
        win.drawString(str, x,y);
    }
    public void mainMenu(Graphics2D pb){
        pb.setFont(fgt);
        pb.setColor(Color.black);
        drawCenteredString("THE BEST BREAKOUT", GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/4, pb);
        drawCenteredString("", GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/4 + 40, pb);

        drawCenteredString("ENTER", GDV5.getMaxWindowX()/2 , GDV5.getMaxWindowY()/2 + 40, pb);
        drawCenteredString("<", GDV5.getMaxWindowX()*3/8, GDV5.getMaxWindowY()*3/4, pb);
        drawCenteredString("Q for Power", GDV5.getMaxWindowX()*4/8, GDV5.getMaxWindowY()*7/8, pb);

        drawCenteredString(">", GDV5.getMaxWindowX() *5/8, GDV5.getMaxWindowY()*3/4, pb);
    }

    public void drawScoreBoard(Graphics2D pb){
        pb.setFont(fgt);
        pb.setColor(Color.black);
        drawCenteredString(""+ Brick.getNumBricks(), GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2, pb);
        drawCenteredString("LVL: "+ BreakoutRunner.bo.getGameLevel(), 100, GDV5.getMaxWindowY()-100, pb);
        drawCenteredString("Lives: "+ BreakoutRunner.getLives(), GDV5.getMaxWindowX() -100, GDV5.getMaxWindowY()-100, pb);

    }
    public void gameLoss(Graphics2D pb){
        pb.setFont(fgtS);
        pb.setColor(Color.BLACK);
        drawCenteredString("GOOD JOB! YOU LOST", GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2, pb);
        pb.setFont(fgtS);
        drawCenteredString("ESC", GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()*3/4, pb);

    }

    public void gameWIn(Graphics2D pb){
        pb.setFont(fgtS);

        pb.setColor(Color.BLACK);
        drawCenteredString("GOOD JOB! YOU WON", GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2, pb);
        pb.setFont(fgtSS);

        drawCenteredString("Glad you’re doing this mindless **** instead of studying for finals",
        GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()*2/3 -20, pb);
        drawCenteredString("What are you flexing exactly " + name +"? It’s all pointless at the end of the day. ",
        GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()*2/3 -10, pb);
        drawCenteredString("Just another number on a game no one cares about. Is this truly where your values lie? ",
        GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()*2/3 , pb);
        drawCenteredString("You would rather play a mindless video game than spend quality time with your friends.",
        GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()*2/3 + 10, pb );
        drawCenteredString("I understand now.",
        GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()*2/3 + 10*2, pb);

        pb.setFont(fgtS);
        drawCenteredString("ESC", GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()*3/4, pb);

    }
}
