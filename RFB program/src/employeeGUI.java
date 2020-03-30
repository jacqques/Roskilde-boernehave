import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class employeeGUI extends JFrame {
    private JButton viewInformationButton;
    private JPanel panel1;
    private JButton viewWaitingButton;

    MainInterface methods = new MainInterface();

    public employeeGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();

        viewInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.viewInformation();
            }
        });

        viewWaitingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.viewWaitingList();
            }
        });
    }
}
