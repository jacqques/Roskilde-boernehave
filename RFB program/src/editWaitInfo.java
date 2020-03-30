import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editWaitInfo extends JFrame {
    private JTextArea infoArea;
    private JPanel panel1;
    private JTextField editPick;
    private JButton submitButton;
    private JLabel editPickLabel;
    private JLabel parent1NumLabel;
    private JLabel parent2NumLabel;
    private JTextField parent1NumField;
    private JTextField parent2NumField;
    private JButton saveNum1Button;
    private JButton saveNum2Button;
    private JButton refreshButton;
    private String tempStr;
    private int tempPick;
    private int cnt;

    MainInterface methods = new MainInterface();

    public editWaitInfo(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(refreshButton);
        this.setContentPane(panel1);
        this.pack();

        infoArea.setText("");
        methods.load();
        methods.loadWaitingList();
        methods.save();

        tempStr = "";
        cnt = 1;
        for (Kid kid : methods.getWaitingList()) {
            tempStr += cnt + ". " + kid.getInfo() + "\n";
            cnt++;
        }

        infoArea.append("Kids: \n" + tempStr + "\n");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tempStr = editPick.getText();
                    //nedenstående minus' med en da arraylist er nul indexerede
                    tempPick = Integer.parseInt(tempStr) - 1;
                    parent1NumLabel.setText(methods.getWaitingList().get(tempPick).getParent1Name() + " number");
                    parent2NumLabel.setText(methods.getWaitingList().get(tempPick).getParent2Name() + " number");
                    JOptionPane.showMessageDialog(null, "Your choice was " + methods.getWaitingList().get(tempPick).getName());
                    editPick.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    editPick.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    editPick.setText("");
                }

            }
        });

        saveNum1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.getWaitingList().get(tempPick).setParent1Number(Integer.parseInt(parent1NumField.getText()));
                    methods.save();
                    methods.saveWait();
                    methods.load();
                    JOptionPane.showMessageDialog(null, "Information saved successfully");
                    parent1NumField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    parent1NumField.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    parent1NumField.setText("");
                }
            }
        });

        saveNum2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.getWaitingList().get(tempPick).setParent2Number(Integer.parseInt(parent2NumField.getText()));
                    methods.save();
                    methods.saveWait();
                    methods.load();
                    JOptionPane.showMessageDialog(null, "Information saved successfully");
                    parent2NumField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    parent2NumField.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    parent2NumField.setText("");
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoArea.setText("");
                methods.load();
                methods.loadWaitingList();
                methods.save();

                tempStr = "";
                cnt = 1;
                for (Kid kid : methods.getWaitingList()) {
                    tempStr += cnt + ". " + kid.getInfo() + "\n";
                    cnt++;
                }

                infoArea.append("Kids: \n" + tempStr + "\n");
            }
        });
    }

}
