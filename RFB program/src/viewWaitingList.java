import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewWaitingList extends JFrame {
    static MainInterface methods = new MainInterface();
    private static JPanel watingListPanel;
    private static JTextArea showWait;
    private static JButton refreshButton;
    private static String tempStr = "";

    public viewWaitingList(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(refreshButton);
        this.setContentPane(watingListPanel);
        this.pack();

        methods.load();
        methods.loadWaitingList();
        methods.save();

        showWait.append("Kids: \n");

        int cnt = 1;
        for (Kid kid : methods.getWaitingList()) {
            tempStr += cnt + ". " + kid.getInfo() + "\n";
            cnt++;
        }

        showWait.append(tempStr);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showWait.setText("");
                methods.getWaitingList().clear();
                methods.load();
                methods.loadWaitingList();
                methods.save();

                tempStr = "";
                int cnt = 1;
                for (Kid kid : methods.getWaitingList()) {
                    tempStr += cnt + ". " + kid.getInfo() + "\n";
                    cnt++;
                }

                showWait.append("Kids: \n" + tempStr);
            }
        });
    }
}
