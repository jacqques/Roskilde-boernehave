import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removeEmployee extends JFrame{
    private JTextArea infoArea;
    private JPanel panel1;
    private JButton removeButton;
    private JButton refreshButton;
    private JTextField empToRemoveField;
    private JLabel empToRemoveLabel;
    private String tempStr = "";
    private int tempPick;
    private int cnt;

    MainInterface methods = new MainInterface();

    public removeEmployee(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(removeButton);
        this.setContentPane(panel1);
        this.pack();

        methods.load();
        methods.save();

        tempStr = "";
        cnt = 1;
        for (Employee employee : methods.getEmployeeList()) {
            tempStr += cnt + ". " + employee.getInfo() + "\n";
            cnt++;
        }

        infoArea.append("Employees: \n" + tempStr + "\n");

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tempPick = Integer.parseInt(empToRemoveField.getText()) - 1;
                    JOptionPane.showMessageDialog(null, methods.getEmployeeList().get(tempPick).getName() + " has been removed from employee list.");
                    methods.getEmployeeList().remove(tempPick);
                    empToRemoveField.setText("");
                    methods.save();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    empToRemoveField.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    empToRemoveField.setText("");
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.load();
                methods.save();

                infoArea.setText("");
                tempStr = "";
                cnt = 1;
                for (Employee employee : methods.getEmployeeList()) {
                    tempStr += cnt + ". " + employee.getInfo() + "\n";
                    cnt++;
                }

                infoArea.append("Employees: \n" + tempStr + "\n");
            }
        });
    }
}
