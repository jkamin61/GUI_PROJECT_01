package gui;

import javax.swing.*;
import java.awt.*;

public class TopFrame extends JPanel{
    JPanel topFrame;
    JButton createButton;
    JButton editButton;
    JButton deleteButton;

    public TopFrame() {
        createTopPanel();
        this.add(topFrame);
    }

    public void createTopPanel() {
        topFrame = new JPanel();
        topFrame.setLayout(new BorderLayout());

        createButton = new JButton("Create");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        topFrame.add(createButton, BorderLayout.WEST);
        topFrame.add(editButton, BorderLayout.CENTER);
        topFrame.add(deleteButton, BorderLayout.EAST);

    }
}
