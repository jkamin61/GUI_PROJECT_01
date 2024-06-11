package gui;

import javax.swing.*;
import java.awt.*;

public class S29352 {
public JFrame frame;

public S29352() {
    initialize();
}

    private void initialize() {
        frame = new JFrame("Task Sphere");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLayout(new BorderLayout());

        TopFrame topFrame = new TopFrame();
        frame.add(topFrame, BorderLayout.NORTH);
        LeftSideFrame leftSideFrame = new LeftSideFrame();
        frame.add(leftSideFrame, BorderLayout.WEST);
        }

}
