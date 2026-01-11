package jraytracing.entities;

import java.awt.*;

class Entity {
    protected int x;
    protected int y;
    protected int radius;
    protected Color color;

    public Entity(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }
}
