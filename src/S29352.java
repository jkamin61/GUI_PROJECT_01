import javax.swing.*;
import java.awt.*;

public class S29352 {
    public static JFrame frame;
    public static boolean isLoggedIn = false;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public S29352() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Task Sphere");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Create views
        EmployeeDepartmentView departmentView = new EmployeeDepartmentView();
        EmployeeView employeeView = new EmployeeView();

        // Create main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.add(departmentView, "DepartmentView");
        mainPanel.add(employeeView, "EmployeeView");

        TopFrame topFrame = new TopFrame(this, departmentView, employeeView);
        LeftSideFrame leftSideFrame = new LeftSideFrame(this);

        frame.add(topFrame, BorderLayout.NORTH);
        frame.add(leftSideFrame, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void showCard(String cardName) {
        cardLayout.show(mainPanel, cardName);
    }
}
