import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class addKidToWait extends JFrame {

    private JPanel panel1;
    private JTextField kidNameField;
    private JTextField parent1NameField;
    private JTextField parent1NumField;
    private JTextField parent2NameField;
    private JTextField parent2NumField;
    private JButton addButton;
    private JButton saveAddButton;
    private String tempStr = "";

    MainInterface methods = new MainInterface();

    public addKidToWait (String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(addButton);
        this.setContentPane(panel1);
        this.pack();

        methods.load();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (parent2NameField.getText().equals("")){
                        parent2NameField.setText("null");
                    }if (parent2NumField.getText().equals("")){
                        parent2NumField.setText("0");
                    }if (!parent1NameField.getText().equals("") && !parent1NumField.getText().equals("") && !kidNameField.getText().equals("")) {
                        tempStr = "";
                        tempStr += kidNameField.getText().replaceAll(" ", "_") + " " + parent1NameField.getText().replaceAll(" ", "_") + " " + parent1NumField.getText() + " " + parent2NameField.getText().replaceAll(" ", "_") + " " + parent2NumField.getText();
                        Scanner wordStream = new Scanner(tempStr);
                        methods.getWaitingList().add(new Kid(wordStream.next().replaceAll("_", " "), wordStream.next().replaceAll("_", " "), wordStream.nextInt(), wordStream.next().replaceAll("_", " "), wordStream.nextInt()));
                        methods.save();
                        methods.saveWait();
                        kidNameField.setText(""); parent1NameField.setText(""); parent1NumField.setText(""); parent2NameField.setText(""); parent2NumField.setText("");
                        JOptionPane.showMessageDialog(null, "Kid added successfully.");
                        setVisible(false);
                    }else {
                        JOptionPane.showMessageDialog(null, "Please make sure all fields are filled.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                    kidNameField.setText(""); parent1NameField.setText(""); parent1NumField.setText(""); parent2NameField.setText(""); parent2NumField.setText("");
                }
            }
        });

        saveAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (parent2NameField.getText().equals("")){
                        parent2NameField.setText("null");
                    }if (parent2NumField.getText().equals("")){
                        parent2NumField.setText("0");
                    }if (!parent1NameField.getText().equals("") && !parent1NumField.getText().equals("") && !kidNameField.getText().equals("")) {
                        tempStr = "";
                        tempStr += kidNameField.getText().replaceAll(" ", "_") + " " + parent1NameField.getText().replaceAll(" ", "_") + " " + parent1NumField.getText() + " " + parent2NameField.getText().replaceAll(" ", "_") + " " + parent2NumField.getText();
                        Scanner wordStream = new Scanner(tempStr);
                        methods.getWaitingList().add(new Kid(wordStream.next().replaceAll("_", " "), wordStream.next().replaceAll("_", " "), wordStream.nextInt(), wordStream.next().replaceAll("_", " "), wordStream.nextInt()));
                        methods.save();
                        methods.saveWait();
                        kidNameField.setText(""); parent1NameField.setText(""); parent1NumField.setText(""); parent2NameField.setText(""); parent2NumField.setText("");
                        JOptionPane.showMessageDialog(null, "Kid added successfully.");
                    }else {
                        JOptionPane.showMessageDialog(null, "Please make sure all fields are filled.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                    kidNameField.setText(""); parent1NameField.setText(""); parent1NumField.setText(""); parent2NameField.setText(""); parent2NumField.setText("");
                }
            }
        });
    }
}
