import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removeKid extends JFrame{
    private JTextArea infoArea;
    private JPanel panel1;
    private JTextField removeKidField;
    private JButton removeButton;
    private JButton refreshButton;
    private JLabel kidRemoveLabel;
    private String tempStr = "";
    private int tempPick;
    private int tempPick2;
    private int cnt;

    MainInterface methods = new MainInterface();

    public removeKid(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(removeButton);
        this.setContentPane(panel1);
        this.pack();

        methods.getKidList().clear();
        methods.getWaitingList().clear();
        methods.load();
        methods.loadWaitingList();
        methods.save();
        methods.saveWait();

        tempStr = "";
        cnt = 1;
        for (Kid kid : methods.getKidList()) {
            tempStr += cnt + ". " + kid.getInfo() + "\n";
            cnt++;
        }

        infoArea.append("Kids: \n" + tempStr + "\n");

        infoArea.append("Waiting list kids: \n");
        tempStr = "";
        for (Kid kid : methods.getWaitingList()) {
            tempStr += cnt + ". " + kid.getInfo() + "\n";
            cnt++;
        }

        infoArea.append(tempStr);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tempPick = Integer.parseInt(removeKidField.getText()) - 1;
                    if(tempPick < methods.getKidList().size()){
                        JOptionPane.showMessageDialog(null, methods.getKidList().get(tempPick).getName() + " has been removed from the kindergarten.");
                        methods.getKidList().remove(tempPick);
                        removeKidField.setText("");
                        methods.save();
                        methods.saveWait();
                    }else if (tempPick >= methods.getWaitingList().size()){
                        tempPick2 = tempPick - methods.getKidList().size();
                        JOptionPane.showMessageDialog(null, methods.getWaitingList().get(tempPick2).getName() + " has been removed from the waiting list.");
                        methods.getWaitingList().remove(tempPick2);
                        removeKidField.setText("");
                        methods.save();
                        methods.saveWait();
                    }else{
                        removeKidField.setText("");
                        JOptionPane.showMessageDialog(null, "Not a valid pick, try again.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    removeKidField.setText("");
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    removeKidField.setText("");
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Not a valid input, try again.");
                    removeKidField.setText("");
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoArea.setText("");
                tempStr = "";
                cnt = 1;
                methods.getWaitingList().clear();
                methods.getKidList();
                methods.load();
                methods.loadWaitingList();
                methods.save();
                methods.saveWait();

                for (Kid kid : methods.getKidList()) {
                    tempStr += cnt + ". " + kid.getInfo() + "\n";
                    cnt++;
                }

                infoArea.append("Kids: \n" + tempStr + "\n");

                infoArea.append("Waiting list kids: \n");
                tempStr = "";
                for (Kid kid : methods.getWaitingList()) {
                    tempStr += cnt + ". " + kid.getInfo() + "\n";
                    cnt++;
                }

                infoArea.append(tempStr);
            }
        });
    }
}
