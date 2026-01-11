package jraytracing.entities;

import java.awt.*;

public class Obstacle extends Entity {


    int moveSpeed = 6;
    boolean moveDirection;

    public static boolean isPaused() {
        return isPaused;
    }

    static boolean isPaused;

    public static void setPaused(boolean paused) {
        isPaused = paused;
    }


    public Obstacle() {
        super(400,400,100,Color.WHITE);

        moveDirection = true;
    }

    public Obstacle(int x, int y,int radius) {
        super(x,y,radius,Color.WHITE);
    }

    public void drawObstacle(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

    }

    public void updateObstacle(int windowWidth) {
        if(!isPaused) {
            if (moveDirection) x += moveSpeed;
            else x -= moveSpeed;

            if (x >= windowWidth - radius) {
                x = windowWidth - radius;
                moveDirection = false;
            } else if (x <= radius) {
                x = radius;
                moveDirection = true;
            }
        }
    }
}

