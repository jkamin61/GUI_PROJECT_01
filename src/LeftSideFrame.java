import javax.swing.*;
import java.awt.*;

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

    public LeftSideFrame(S29352 mainApp) {
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

        employeeDepartmentButton.addActionListener(e -> mainApp.showCard("DepartmentView"));
        employeeButton.addActionListener(e -> mainApp.showCard("EmployeeView"));

    }
}
