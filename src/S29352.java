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

    public void initialize() {
        frame = new JFrame("Task Sphere");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        EmployeeDepartmentView departmentView = new EmployeeDepartmentView();
        EmployeeView employeeView = new EmployeeView();
        UserView userView = new UserView();
        ForemanView foremanView = new ForemanView();
        BrigadeView brigadeView = new BrigadeView();

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.add(departmentView, "DepartmentView");
        mainPanel.add(employeeView, "EmployeeView");
        mainPanel.add(userView, "UserView");
        mainPanel.add(foremanView, "ForemanView");
        mainPanel.add(brigadeView, "BrigadeView");

        TopFrame topFrame = new TopFrame(this, departmentView, employeeView, userView, foremanView, brigadeView);
        LeftFrame leftFrame = new LeftFrame(this);

        frame.add(topFrame, BorderLayout.NORTH);
        frame.add(leftFrame, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void showCard(String cardName) {
        cardLayout.show(mainPanel, cardName);
    }
}
