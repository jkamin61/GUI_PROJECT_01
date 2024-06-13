import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopFrame extends JPanel {
    public static JButton createButton;
    public static JButton editButton;
    public static JButton deleteButton;
    public JButton userButton;
    public static JButton employeesButton;

    private static EmployeeDepartmentView departmentView;
    private static EmployeeView employeeView;
    private static UserView userView;
    private static ForemanView foremanView;
    private static BrigadeView brigadeView;

    public TopFrame(S29352 mainApp, EmployeeDepartmentView departmentView, EmployeeView employeeView, UserView userView, ForemanView foremanView, BrigadeView brigadeView) {
        this.departmentView = departmentView;
        this.employeeView = employeeView;
        this.userView = userView;
        this.foremanView = foremanView;
        this.brigadeView = brigadeView;

        createTopPanel();
        updateActions("DepartmentView");
    }

    public void createTopPanel() {
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 10));

        createButton = new JButton("Create");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        User user = User.getUsers().get(0);
        userButton = new JButton("Hello, "+user.getInitial());
        employeesButton = new JButton("Employees");

        actionPanel.add(createButton);
        actionPanel.add(editButton);
        actionPanel.add(deleteButton);
        userPanel.add(userButton);
        userPanel.add(employeesButton);
        employeesButton.setVisible(false);

        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.X_AXIS));

        combinedPanel.add(actionPanel);
        combinedPanel.add(Box.createHorizontalGlue());
        combinedPanel.add(userPanel);

        container.add(combinedPanel, BorderLayout.CENTER);
        add(container);
    }

    public static void updateActions(String cardName) {
        for (ActionListener al : createButton.getActionListeners()) {
            createButton.removeActionListener(al);
        }
        for (ActionListener al : editButton.getActionListeners()) {
            editButton.removeActionListener(al);
        }
        for (ActionListener al : deleteButton.getActionListeners()) {
            deleteButton.removeActionListener(al);
        }

        if (cardName.equals("DepartmentView")) {
            createButton.setVisible(true);
            createButton.addActionListener(e -> departmentView.createDepartment());
            editButton.setText("Edit");
            editButton.addActionListener(e -> departmentView.editDepartment());
            deleteButton.setVisible(true);
            deleteButton.addActionListener(e -> departmentView.deleteDepartment());
            employeesButton.setVisible(true);
        } else if (cardName.equals("EmployeeView")) {
            createButton.setVisible(true);
            createButton.addActionListener(e -> employeeView.createEmployee());
            editButton.setText("Edit");
            editButton.addActionListener(e -> employeeView.editEmployee());
            deleteButton.setVisible(true);
            deleteButton.addActionListener(e -> employeeView.deleteEmployee());
            employeesButton.setVisible(false);
        } else if (cardName.equals("UserView")) {
            createButton.setVisible(false);
            editButton.setText("Change password");
            editButton.addActionListener(e -> userView.changeUserPassword());
            deleteButton.setVisible(false);
            employeesButton.setVisible(false);
        } else if (cardName.equals("ForemanView")) {
            createButton.setVisible(true);
            createButton.addActionListener(e -> foremanView.addForeman());
            editButton.setText("Edit");
            editButton.addActionListener(e -> foremanView.editForeman());
            deleteButton.setVisible(true);
            deleteButton.addActionListener(e -> foremanView.deleteForeman());
            employeesButton.setVisible(false);
        } else if (cardName.equals("BrigadeView")) {
            createButton.setVisible(true);
            createButton.addActionListener(e -> brigadeView.addBrigade());
            editButton.setText("Edit");
//            editButton.addActionListener(e -> brigadeView.editBrigade());
            deleteButton.setVisible(true);
//            deleteButton.addActionListener(e -> brigadeView.deleteBrigade());
            employeesButton.setVisible(false);
        }
    }
}
