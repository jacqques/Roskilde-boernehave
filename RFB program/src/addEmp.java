import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class addEmp extends JFrame {
    private JPanel panel1;
    private JTextField empNameField;
    private JButton addButton;
    private JTextField empNumField;
    private JTextField empUserField;
    private JTextField empPassField;
    private JButton saveAddButton;
    private String tempStr = "";
    private String tempName = "";
    private String tempUser = "";
    private String tempPass = "";
    private int tempNum = 0;

    MainInterface methods = new MainInterface();

    public addEmp (String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(addButton);
        this.setContentPane(panel1);
        this.pack();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (0 < empNameField.getText().length() && 0 < empNumField.getText().length() && 0 < empUserField.getText().length() && 0 < empPassField.getText().length()) {
                        for (Employee employee : methods.getEmployeeList()) {
                            if (!employee.getLogin().containsKey(empUserField.getText())) {
                                // Den buggede da jeg prøvede at bruge en wordstream så det blev med temp values
                                tempName = empNameField.getText().replaceAll(" ", "_");
                                tempNum = Integer.parseInt(empNumField.getText());
                                tempUser = empUserField.getText().replaceAll(" ", "_");
                                tempPass = empPassField.getText().replaceAll(" ", "_");
                                methods.getEmployeeList().add(new Employee(tempName, tempNum, tempUser, tempPass));
                                methods.save();
                                methods.saveWait();
                                empNameField.setText(""); empNumField.setText(""); empUserField.setText(""); empPassField.setText("");
                                JOptionPane.showMessageDialog(null, "Employee added successfully.");
                                setVisible(false);
                            }else {
                                JOptionPane.showMessageDialog(null, "Username is taken.");
                                empUserField.setText("");
                                break;
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Please make sure all fields are filled.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                    empNameField.setText(""); empNumField.setText(""); empUserField.setText(""); empPassField.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                    empNameField.setText(""); empNumField.setText(""); empUserField.setText(""); empPassField.setText("");
                } catch (Exception ex) {
                    empNameField.setText(""); empNumField.setText(""); empUserField.setText(""); empPassField.setText("");
                }
            }
        });

        saveAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (0 < empNameField.getText().length() && 0 < empNumField.getText().length() && 0 < empUserField.getText().length() && 0 < empPassField.getText().length()) {
                        for (Employee employee : methods.getEmployeeList()) {
                            if (!employee.getLogin().containsKey(empUserField.getText())) {
                                // Den buggede da jeg prøvede at bruge en wordstream så det blev med temp values
                                tempName = empNameField.getText().replaceAll(" ", "_");
                                tempNum = Integer.parseInt(empNumField.getText());
                                tempUser = empUserField.getText().replaceAll(" ", "_");
                                tempPass = empPassField.getText().replaceAll(" ", "_");
                                methods.getEmployeeList().add(new Employee(tempName, tempNum, tempUser, tempPass));
                                methods.save();
                                methods.saveWait();
                                empNameField.setText(""); empNumField.setText(""); empUserField.setText(""); empPassField.setText("");
                                JOptionPane.showMessageDialog(null, "Employee added successfully.");
                            }else {
                                JOptionPane.showMessageDialog(null, "Username is taken.");
                                empUserField.setText("");
                                break;
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Please make sure all fields are filled.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                    empNameField.setText(""); empNumField.setText(""); empUserField.setText(""); empPassField.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                    empNameField.setText(""); empNumField.setText(""); empUserField.setText(""); empPassField.setText("");
                } catch (Exception ex) {
                    empNameField.setText(""); empNumField.setText(""); empUserField.setText(""); empPassField.setText("");
                }
            }
        });
    }
}
