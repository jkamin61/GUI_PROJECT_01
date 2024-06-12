import javax.swing.*;
import java.awt.*;

public class S29352 {
    public static JFrame frame;
    public static boolean isLoggedIn = false;

    public S29352() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Task Sphere");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        EmployeeDepartmentView departmentView = new EmployeeDepartmentView();

        TopFrame topFrame = new TopFrame(departmentView);
        frame.add(topFrame, BorderLayout.NORTH);
        LeftSideFrame leftSideFrame = new LeftSideFrame();
        frame.add(leftSideFrame, BorderLayout.WEST);
        frame.add(departmentView, BorderLayout.CENTER);
    }
}
