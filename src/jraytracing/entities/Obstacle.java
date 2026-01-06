package jraytracing.entities;

import java.awt.*;

public class Obstacle extends Entity {


    int moveSpeed = 6;
    boolean moveDirection;

    public Obstacle() {
        x = 400;
        y = 400;
        radius = 100;
        color = Color.WHITE;

        moveDirection = true;
    }

    public Obstacle(int x, int y,int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;

    }

    public void drawObstacle(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

    }

    public void updateObstacle(int windowWidth) {
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

