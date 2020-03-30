import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editEmpInfo extends JFrame {
    private JTextArea infoArea;
    private JPanel panel1;
    private JTextField empEditPick;
    private JTextField newNumberField;
    private JButton submitButton;
    private JButton refreshButton;
    private JLabel empToEdit;
    private JLabel empNumberEdit;
    private JLabel password1;
    private JLabel password2;
    private JPasswordField newPass1Field;
    private JPasswordField newPass2Field;
    private JButton saveNumButton;
    private JButton savePassButton;
    private int cnt;
    private int tempPick;
    private String tempPass1;
    private String tempPass2;
    private String tempStr = "";

    MainInterface methods = new MainInterface();

    public editEmpInfo (String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(refreshButton);
        this.setContentPane(panel1);
        this.pack();

        methods.load();
        methods.loadWaitingList();
        methods.save();

        cnt = 1;
        for (Employee employee : methods.getEmployeeList()) {
            tempStr += cnt + ". " + employee.getInfo() + "\n";
            cnt++;
        }

        infoArea.append("Employees:\n" + tempStr);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoArea.setText("");
                methods.getEmployeeList().clear();
                methods.load();
                methods.loadWaitingList();
                methods.save();

                tempStr = "";
                cnt = 1;
                for (Employee employee : methods.getEmployeeList()) {
                    tempStr += cnt + ". " + employee.getInfo() + "\n";
                    cnt++;
                }

                infoArea.append("Employees: \n" + tempStr);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tempStr = empEditPick.getText();
                    //nedenstående minus' med en da arraylist er nul indexerede
                    tempPick = Integer.parseInt(tempStr) - 1;
                    empNumberEdit.setText(methods.getEmployeeList().get(tempPick).getName() + " number");
                    password1.setText(methods.getEmployeeList().get(tempPick).getName() + " new password");
                    JOptionPane.showMessageDialog(null, "Your choice was " + methods.getEmployeeList().get(tempPick).getName());
                    empEditPick.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    empEditPick.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    empEditPick.setText("");
                }
            }
        });

        saveNumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.getEmployeeList().get(tempPick).setNumber(Integer.parseInt(newNumberField.getText()));
                    methods.save();
                    methods.saveWait();
                    methods.load();
                    JOptionPane.showMessageDialog(null, "Information saved successfully.");
                    newNumberField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    newNumberField.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    newNumberField.setText("");
                }

            }
        });

        savePassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempPass1 = newPass1Field.getText();
                tempPass2 = newPass2Field.getText();

                if (tempPass1.equals(tempPass2) && !tempPass1.equals(methods.getEmployeeList().get(tempPick).getPassword())){
                    methods.getEmployeeList().get(tempPick).setPassword(tempPass1);
                    methods.save();
                    newPass1Field.setText("");
                    newPass2Field.setText("");
                    JOptionPane.showMessageDialog(null, "New password successfully saved.");
                }else if (tempPass1.equals(methods.getEmployeeList().get(tempPick).getPassword())){
                    newPass1Field.setText("");
                    newPass2Field.setText("");
                    JOptionPane.showMessageDialog(null, "Password cannot be the same as the last password.");
                }else{
                    newPass1Field.setText("");
                    newPass2Field.setText("");
                    JOptionPane.showMessageDialog(null, "Incorrect passwords entered, please try again.");
                }
            }
        });
    }
}
