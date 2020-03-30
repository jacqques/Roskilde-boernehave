import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showInfo extends JFrame {
    private JPanel showInfoPanel;
    private JTextArea infoArea;
    private JButton refreshButton;
    private String tempStr = "";

    MainInterface methods = new MainInterface();

    public showInfo(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(refreshButton);
        this.setContentPane(showInfoPanel );
        this.pack();

        methods.getKidList().clear();
        methods.load();
        methods.loadWaitingList();
        methods.save();

        for (Kid kid : methods.getKidList()) {
            tempStr += kid.getInfo() + "\n";
        }

        infoArea.append("Kids: \n" + tempStr + "\n");

        tempStr = "";
        for (Employee employee : methods.getEmployeeList()) {
            tempStr += employee.getInfo() + "\n";
        }

        infoArea.append("Employees: \n" + tempStr);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
    }

    public void refresh(){
        infoArea.setText("");
        methods.getKidList().clear();
        methods.getEmployeeList().clear();
        methods.load();
        methods.loadWaitingList();
        methods.save();

        tempStr ="";
        for (Kid kid : methods.getKidList()) {
            tempStr += kid.getInfo() + "\n";
        }


        infoArea.append("Kids: \n" + tempStr + "\n");

        tempStr = "";
        for (Employee employee : methods.getEmployeeList()) {
            tempStr += employee.getInfo() + "\n";
        }

        infoArea.append("Employees: \n" + tempStr);
    }
}
