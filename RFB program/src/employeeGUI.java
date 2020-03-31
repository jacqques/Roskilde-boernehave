import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class employeeGUI extends JFrame {
    private JButton viewInformationButton;
    private JPanel panel1;
    private JButton viewWaitingButton;

    public static JFrame displayInfoGUI = new showInfo("View information");
    public static JFrame displayWait = new viewWaitingList("View waiting list");

    public employeeGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();

        viewInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInfoGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
                displayInfoGUI.setVisible(true);
            }
        });

        viewWaitingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayWait.setExtendedState(JFrame.MAXIMIZED_BOTH);
                displayWait.setVisible(true);
            }
        });
    }
}
