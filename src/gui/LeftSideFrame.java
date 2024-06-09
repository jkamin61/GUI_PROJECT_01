package gui;

import javax.swing.*;

public class LeftSideFrame extends JPanel {
    JPanel leftFrame;

    JButton employeeDepartmentButton;
    JButton employeeButton;
    JButton userButton;
    JButton foremanButton;
    JButton brigadeButton;
    JButton contractButton;
    JButton jobButton;
    JButton logoutButton;

    public LeftSideFrame() {
        createLeftPanel();
        this.add(leftFrame);
    }

    public void createLeftPanel() {
        leftFrame = new JPanel();
        leftFrame.setLayout(new BoxLayout(leftFrame, BoxLayout.Y_AXIS));

        employeeDepartmentButton = new JButton("Employee Department");
        employeeButton = new JButton("Employee");
        userButton = new JButton("User");
        foremanButton = new JButton("Foreman");
        brigadeButton = new JButton("Brigade");
        contractButton = new JButton("Contract");
        jobButton = new JButton("Job");
        logoutButton = new JButton("Logout");

        leftFrame.add(employeeDepartmentButton);
        leftFrame.add(employeeButton);
        leftFrame.add(userButton);
        leftFrame.add(foremanButton);
        leftFrame.add(brigadeButton);
        leftFrame.add(contractButton);
        leftFrame.add(jobButton);
        leftFrame.add(logoutButton);
    }

}
