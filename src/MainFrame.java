import javax.swing.*;
import java.util.List;

public class MainFrame extends JFrame {
    private static DefaultListModel<String> listModelDepartment;
    private static DefaultListModel<String> listModelEmployee;
    private static DefaultListModel<String> listModelUser;
    private DefaultListModel<String> listModelSupervisor;
    private static DefaultListModel<String> listModelBrigade;
    private DefaultListModel<String> listModelOrder;
    private DefaultListModel<String> listModelWork;
    private List<String> objects;
    private static JList<String> listData;
    private JScrollPane scrollPane;

    public void createLists() {
        listModelDepartment = new DefaultListModel<>();
        listModelEmployee = new DefaultListModel<>();
        listModelUser = new DefaultListModel<>();
        listModelSupervisor = new DefaultListModel<>();
        listModelBrigade = new DefaultListModel<>();
        listModelOrder = new DefaultListModel<>();
        listModelWork = new DefaultListModel<>();

        listData = new JList<>(listModelDepartment);
        listData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollPane = new JScrollPane(listData);
    }

}
