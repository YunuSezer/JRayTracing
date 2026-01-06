package jraytracing.main;

import jraytracing.entities.Light;
import jraytracing.entities.Obstacle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Canvas extends JPanel implements ActionListener {

    Timer timer;

    Light light;
    ArrayList<Obstacle> obstacles = new ArrayList<>();

    public Canvas() {
        timer = new Timer(16, this);
        timer.start();

        setBackground(Color.BLACK);

        light = new Light();
        obstacles.add(new Obstacle());
        obstacles.add(new Obstacle(400,400,25));
        obstacles.add(new Obstacle(300,300,50));

        addMouseMotionListener(light);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);



        light.drawLight(graphics2D, obstacles);

        for (Obstacle o: obstacles){
            o.updateObstacle(getWidth());
            o.drawObstacle(graphics2D);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}