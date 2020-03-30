import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class managerGUI extends JFrame {
    private JPanel managerPanel;
    private JButton viewInfoButton;
    private JButton editKidInfoButton;
    private JButton viewWaitingListButton;
    private JButton editWaitingListButton;
    private JButton removeKidButton;
    private JButton addKidButton;
    private JButton saveButton;
    private JButton editEmpInfoButton;
    private JButton removeEmpButton;
    private JButton addEmpButton;

    MainInterface methods = new MainInterface();


    public managerGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(managerPanel);
        this.pack();

        methods.load();
        methods.loadWaitingList();
        methods.save();

        viewInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.viewInformation();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        editKidInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.editKidInfo();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        editEmpInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.editEmpInfo();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        viewWaitingListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.viewWaitingList();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        editWaitingListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.editWaitingList();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        addKidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.addKid();
            }
        });

        addEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.addEmp();
            }
        });

        removeKidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.removeKid();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        removeEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.removeEmployee();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    methods.save();
                    methods.saveWait();
                    methods.load();
                    methods.loadWaitingList();
                    JOptionPane.showMessageDialog(null, "Information saved successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });
    }
}
