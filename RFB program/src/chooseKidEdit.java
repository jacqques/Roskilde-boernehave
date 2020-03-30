import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chooseKidEdit extends JFrame {

    private JPanel panel1;
    private JTextArea infoArea;
    private JButton submitButton;
    private JTextField kidChoice;
    private JTextField parent1Number;
    private JTextField parent2Number;
    private JButton saveParent1;
    private JButton saveParent2;
    private JLabel parent2Label;
    private JLabel parent1Label;
    private JLabel editPick;
    private JButton refreshButton;
    private String tempStr = "";
    private int cnt = 1;
    private int tempPick;

    MainInterface methods = new MainInterface();

    public chooseKidEdit(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(refreshButton);
        this.setContentPane(panel1);
        this.pack();

        methods.load();
        methods.loadWaitingList();
        methods.save();

        for (Kid kid : methods.getKidList()) {
            tempStr += cnt + ". " + kid.getInfo() + "\n";
            cnt++;
        }

        infoArea.append("Kids: \n" + tempStr + "\n");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tempStr = kidChoice.getText();
                    //nedenstående minus' med en da arraylist er nul indexerede
                    tempPick = Integer.parseInt(tempStr) - 1;
                    parent1Label.setText(methods.getKidList().get(tempPick).getParent1Name() + " number");
                    parent2Label.setText(methods.getKidList().get(tempPick).getParent2Name() + " number");
                    JOptionPane.showMessageDialog(null, "Your choice was " + methods.getKidList().get(tempPick).getName());
                    kidChoice.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    kidChoice.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    kidChoice.setText("");
                }
            }
        });


        saveParent1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.getKidList().get(tempPick).setParent1Number(Integer.parseInt(parent1Number.getText()));
                    methods.save();
                    methods.saveWait();
                    methods.load();
                    JOptionPane.showMessageDialog(null, "Information saved successfully");
                    parent1Number.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    parent1Number.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    parent1Number.setText("");
                }
            }
        });

        saveParent2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.getKidList().get(tempPick).setParent2Number(Integer.parseInt(parent2Number.getText()));
                    methods.save();
                    methods.saveWait();
                    methods.load();
                    JOptionPane.showMessageDialog(null, "Information saved successfully");
                    parent2Number.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    parent2Number.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    parent2Number.setText("");
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
                for (Kid kid : methods.getKidList()) {
                    tempStr += cnt + ". " + kid.getInfo() + "\n";
                    cnt++;
                }

                infoArea.append("Kids: \n" + tempStr + "\n");
            }
        });
    }
}
