import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopFrame extends JPanel {
    public JButton createButton;
    public JButton editButton;
    public JButton deleteButton;
    public JButton userButton;

    private EmployeeDepartmentView departmentView;
    private EmployeeView employeeView;

    public TopFrame(S29352 mainApp, EmployeeDepartmentView departmentView, EmployeeView employeeView) {
        this.departmentView = departmentView;
        this.employeeView = employeeView;
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
        userButton = new JButton("Hello, USER");

        actionPanel.add(createButton);
        actionPanel.add(editButton);
        actionPanel.add(deleteButton);
        userPanel.add(userButton);

        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.X_AXIS));

        combinedPanel.add(actionPanel);
        combinedPanel.add(Box.createHorizontalGlue());
        combinedPanel.add(userPanel);

        container.add(combinedPanel, BorderLayout.CENTER);
        add(container);
    }

    public void updateActions(String cardName) {
        for (ActionListener al : createButton.getActionListeners()) {
            createButton.removeActionListener(al);
        }
        for (ActionListener al : editButton.getActionListeners()) {
            editButton.removeActionListener(al);
        }
        for (ActionListener al : deleteButton.getActionListeners()) {
            deleteButton.removeActionListener(al);
        }

        if ("DepartmentView".equals(cardName)) {
            createButton.addActionListener(e -> departmentView.createDepartment());
            editButton.addActionListener(e -> departmentView.editDepartment());
            deleteButton.addActionListener(e -> departmentView.deleteDepartment());
        } else if ("EmployeeView".equals(cardName)) {
            createButton.addActionListener(e -> employeeView.createEmployee());
            editButton.addActionListener(e -> employeeView.editEmployee());
//            deleteButton.addActionListener(e -> employeeView.deleteEmployee());
        }
    }
}
