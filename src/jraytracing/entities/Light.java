package jraytracing.entities;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Light extends Entity implements MouseMotionListener {

    ArrayList<Ray> rays = new ArrayList<>();

    public Light() {
        int rayAmount = Ray.getRayAmount();
        x = 200;
        y = 200;
        radius = 10;
        color = Color.YELLOW;

        for (int i = 0; i < rayAmount; i++) {
            rays.add(new Ray((360.0 / rayAmount) * i));
        }
    }

    public void drawLight(Graphics2D g, ArrayList<Obstacle> obstacles) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

        for (Ray r : rays) {
            r.castRay(g, x, y, obstacles);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        x = mouseX;
        y = mouseY;


    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

}