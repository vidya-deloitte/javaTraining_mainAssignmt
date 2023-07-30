import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Jtable extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    //Creates a table to display employee CTC Structure in table format using Java Swing
    public Jtable() {
        // Set the frame title
        super("Employee Details");

        // Create a table model with column names
        String[] columnNames = {"","Basic", "HRA", "LTA", "CTC","PF","SODEXO","SPECIAL ALLOWANCE","VPF"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Create the JTable using the table model
        table = new JTable(tableModel);

        // Set table properties
        table.setPreferredScrollableViewportSize(new Dimension(500, 150)); // Set size as needed
        table.setFillsViewportHeight(true);

        // Create a scroll pane to contain the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addEmployeeRow(EmployeeDetails employee) {
        // Add a new row to the table with the data from the Employee object
        Object[] rowData = { "Monthly",employee.getBasic(),
                employee.getHra(), employee.getLta(), employee.getCtc(),employee.getPf(),employee.getSodexo(),employee.getSpecialAllowance(),employee.getVpf()};
        tableModel.addRow(rowData);

        // Calculate the projected amounts
        double projectedBasic = employee.getBasic() * 12;
        double projectedHRA = employee.getHra() * 12;
        double projectedLTA = employee.getLta() * 12;
        double projectedCTC = employee.getCtc() * 12;
        double projectedPF = employee.getPf() * 12;
        double projectedSod = employee.getSodexo() * 12;
        double projectedsp = employee.getSpecialAllowance() * 12;
        double projectedvpf= employee.getVpf() * 12;



        // Add a new row for projected amounts
        Object[] projectedRowData = {"Fixed", projectedBasic, projectedHRA, projectedLTA, projectedCTC,projectedPF,projectedSod,projectedsp,projectedvpf};
        tableModel.addRow(projectedRowData);

    }
}



