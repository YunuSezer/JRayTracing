package jraytracing.entities;

import java.awt.*;
import java.util.ArrayList;

class Ray {

    static int rayAmount = 360;
    int thickness = 1;
    int maxLength = 1920;
    double angle;

    public Ray(double angle) {
        this.angle = angle;
    }

    public void castRay(Graphics2D g2d, int originX, int originY, ArrayList<Obstacle> obstacles) {
        double rad = Math.toRadians(angle);
        int endX = originX;
        int endY = originY;
        int currentLength = 0;

        while (currentLength < maxLength) {
           currentLength += 2;

            endX = originX + (int) (Math.cos(rad) * currentLength);
            endY = originY + (int) (Math.sin(rad) * currentLength);

            boolean hitSomething = false;
            for (Obstacle o:obstacles) {
                double distance2obstacle = Math.sqrt(Math.pow(endX - o.x, 2) + Math.pow(endY - o.y, 2));
                if (distance2obstacle < o.radius) {
                    hitSomething = true;
                    break;
                }
            }
            if (hitSomething) break;
        }
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawLine(originX, originY, endX, endY);

        }
    public static int getRayAmount() {
        return rayAmount;
    }
}


