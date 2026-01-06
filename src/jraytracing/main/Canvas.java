package jraytracing.main;

import jraytracing.entities.Light;
import jraytracing.entities.Obstacle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Canvas extends JPanel implements ActionListener, KeyListener {

    Timer timer;

    Light light;
    ArrayList<Obstacle> obstacles = new ArrayList<>();

    public Canvas() {
        timer = new Timer(16, this);
        timer.start();

        setBackground(Color.BLACK);

        light = new Light();
        obstacles.add(new Obstacle());
        obstacles.add(new Obstacle(400, 400, 25));
        obstacles.add(new Obstacle(300, 300, 50));

        addMouseMotionListener(light);
        addKeyListener(this);

        this.setFocusable(true);
        this.requestFocusInWindow();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);


        light.drawLight(graphics2D, obstacles);

        for (Obstacle o : obstacles) {
            o.updateObstacle(getWidth());
            o.drawObstacle(graphics2D);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !Obstacle.isPaused()) {
            Obstacle.setPaused(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && Obstacle.isPaused()){
            Obstacle.setPaused(false);
        }

    }
}