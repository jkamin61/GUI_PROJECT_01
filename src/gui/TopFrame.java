package gui;

import javax.swing.*;
import java.awt.*;

public class TopFrame extends JPanel {

    public TopFrame() {
        createTopPanel();
    }

    public void createTopPanel() {
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton createButton = new JButton("Create");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        JButton userButton = new JButton("Hello, $");

        actionPanel.add(createButton);
        actionPanel.add(editButton);
        actionPanel.add(deleteButton);
        actionPanel.add(userButton);



        container.add(actionPanel);

        add(container);

    }
}
