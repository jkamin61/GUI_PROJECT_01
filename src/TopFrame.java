import javax.swing.*;
import java.awt.*;

public class TopFrame extends JPanel {
    public JButton createButton;
    public JButton editButton;
    public JButton deleteButton;
    public JButton userButton;

    public TopFrame(EmployeeDepartmentView view) {
        createTopPanel(view);
    }

    public void createTopPanel(EmployeeDepartmentView departmentView) {
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        createButton = new JButton("Create");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        userButton = new JButton("Hello, $");

        actionPanel.add(createButton);
        actionPanel.add(editButton);
        actionPanel.add(deleteButton);
        actionPanel.add(userButton);

        container.add(actionPanel);
        add(container);

        createButton.addActionListener(e -> departmentView.createDepartment());
        editButton.addActionListener(e -> departmentView.editDepartment());
        deleteButton.addActionListener(e -> departmentView.deleteDepartment());
    }
}
