import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RFB_GUI extends JFrame{
    private JPanel mainPanel;
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;

    public static JFrame rfbLogin = new RFB_GUI("Roskilde Frie Børnehave");

    MainInterface methods = new MainInterface();

    public RFB_GUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setDefaultButton(loginButton);
        this.setContentPane(mainPanel);
        this.pack();

        methods.load();
        methods.loadWaitingList();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // tag tekst og indsæt i username og password
                methods.login(usernameField.getText(), passwordField.getText());
            }
        });
    }

    public static void main(String[] args) {
        rfbLogin.setVisible(true);
        rfbLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
