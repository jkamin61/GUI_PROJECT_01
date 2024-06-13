import javax.swing.*;
import java.awt.*;

public class LeftFrame extends JPanel {
    JPanel leftFrame;

    JButton employeeDepartmentButton;
    JButton employeeButton;
    JButton userButton;
    JButton foremanButton;
    JButton brigadeButton;
    JButton contractButton;
    JButton jobButton;
    JButton logoutButton;

    public LeftFrame(S29352 mainApp) {
        createLeftPanel(mainApp);
        this.add(leftFrame);
    }

    public void createLeftPanel(S29352 mainApp) {
        leftFrame = new JPanel();
        leftFrame.setLayout(new GridLayout(8, 1));

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

        logoutButton.setBackground(Color.LIGHT_GRAY);
        logoutButton.setForeground(Color.BLACK);

        employeeDepartmentButton.addActionListener(e -> {
            mainApp.showCard("DepartmentView");
            TopFrame.updateActions("DepartmentView");
        });
        employeeButton.addActionListener(e -> {
            mainApp.showCard("EmployeeView");
            TopFrame.updateActions("EmployeeView");
        });
        userButton.addActionListener(e -> {
            mainApp.showCard("UserView");
            TopFrame.updateActions("UserView");
        });
        foremanButton.addActionListener(e -> {
            mainApp.showCard("ForemanView");
            TopFrame.updateActions("ForemanView");
        });
        brigadeButton.addActionListener(e -> {
            mainApp.showCard("BrigadeView");
            TopFrame.updateActions("BrigadeView");
        });

    }
}
