package src;

import java.awt.*;

public class Particle extends Brick {
    private int dX;
    private int dY;
    private static Particle[] particles;
    private static boolean particlesMade = false;
    private static int particleCounter = 0;
    public Particle(int x, int y,int w, int h){
        super(x,y,w,h);
    }
    public static void makeParticles(Brick b){
        int partPerRow = 30;
        int rowPerArr = 6;
        particlesMade = true;
        particles =  new Particle[partPerRow*rowPerArr];
        int x =(int) b.getX();
        int y =(int) b.getY();
        for(int i =0; i < particles.length; i++){
            particles[i] = new Particle(x,y, (int)b.getWidth()/partPerRow, (int)b.getHeight()/rowPerArr);
            x+= (int)b.getWidth()/partPerRow ;
            if(x + (int)b.getWidth()/partPerRow >b.getX()+b.getWidth()){
                x = (int)b.getX();
                y+= (int)b.getHeight()/rowPerArr;
            }
        }
    }
    public void move() {
        if (Math.random () < 0.5) dX = 1;
        else dX = -1;
        if (Math.random () < 0.5)dY = 1;
        else dY = -1;
        this.x += dX; this.y += dY;
    }

    public static void moveParticles() {
        for (Particle p: particles)
        {
            if(particlesMade){
                p.move();
            }
        }
    }

    public void draw(Graphics2D pb){
        pb.setColor(Color.orange);
        pb.fill(this);
    }
    public static void drawParticles(Graphics2D pb){
        if(particlesMade) {
            for (Particle p : particles) {
                p.draw(pb);
            }
        }
    }


    public int getdX() {
        return dX;
    }

    public void setdX(int dX) {
        this.dX = dX;
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

    public static Particle[] getParticles() {
        return particles;
    }

    public static void setParticles(Particle[] particles) {
        Particle.particles = particles;
    }

    public static boolean isParticlesMade() {
        return particlesMade;
    }

    public static void setParticlesMade(boolean particlesMade) {
        Particle.particlesMade = particlesMade;
    }

    public static int getParticleCounter() {
        return particleCounter;
    }

    public static void setParticleCounter(int particleCounter) {
        Particle.particleCounter = particleCounter;
    }
}
