package jraytracing.main;

import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
    private static final int sizeWidth = 1024;
    private static final int sizeHeight = 768;

    public Window() throws HeadlessException {
        setTitle("JRayTracing");
        setSize(sizeWidth,sizeHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Canvas Canvas = new Canvas();
        add(Canvas);

        setVisible(true);

    }


}
