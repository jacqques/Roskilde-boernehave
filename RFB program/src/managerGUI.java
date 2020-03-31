import javax.swing.*;
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

    public static JFrame displayInfoGUI = new showInfo("View information");
    public static JFrame displayWait = new viewWaitingList("View waiting list");
    public static JFrame chooseEditKid = new chooseKidEdit("Choose kid to edit");
    public static JFrame chooseEditEmp = new editEmpInfo("Choose employee to edit");
    public static JFrame chooseEditWait = new editWaitInfo("Choose kid to edit");
    public static JFrame removeKidFrame = new removeKid("Choose kid to remove");
    public static JFrame removeEmpFrame = new removeEmployee("Choose employee to remove");
    public static JFrame addKidFrame = new addKidToWait("Add kid to waiting list");
    public static JFrame addEmpFrame = new addEmp("Add employee");

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
                    displayInfoGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    displayInfoGUI.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        editKidInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    chooseEditKid.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    chooseEditKid.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        editEmpInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    chooseEditEmp.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    chooseEditEmp.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        viewWaitingListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    displayWait.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    displayWait.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        editWaitingListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    chooseEditWait.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    chooseEditWait.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        addKidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addKidFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                addKidFrame.setVisible(true);
            }
        });

        addEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmpFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                addEmpFrame.setVisible(true);
            }
        });

        removeKidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeKidFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    removeKidFrame.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
        });

        removeEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeEmpFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    removeEmpFrame.setVisible(true);
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
