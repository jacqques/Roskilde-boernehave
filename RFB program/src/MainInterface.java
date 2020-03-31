import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainInterface {

    private static ArrayList<Kid> kidList = new ArrayList();
    private static ArrayList<Kid> waitingList = new ArrayList();
    private static ArrayList<Employee> employeeList = new ArrayList();
    private static Manager manager;

    public static JFrame manGUI = new managerGUI("Manager menu");
    public static JFrame empGUI = new employeeGUI("Employee menu");

    public static void load(){
        try{
            kidList.clear();
            employeeList.clear();
            waitingList.clear();
            Scanner kidInStream = new Scanner(new File(".\\resources\\kid_Info.txt"));
            Scanner empInStream = new Scanner(new File(".\\resources\\employee_Info.txt"));
            Scanner manInStream = new Scanner(new File(".\\resources\\manager_Info.txt"));
            Scanner wordStream;
            String temp;

            while (kidInStream.hasNextLine()) {
                temp = kidInStream.nextLine();
                wordStream = new Scanner(temp);
                //nedenstående fjerner id nummeret fra filen
                wordStream.nextInt();
                kidList.add(new Kid(wordStream.next().replaceAll("_", " "), wordStream.next().replaceAll("_", " "), wordStream.nextInt(), wordStream.next().replaceAll("_", " "), wordStream.nextInt()));
            }

            while (empInStream.hasNextLine()) {
                temp = empInStream.nextLine();
                wordStream = new Scanner(temp);
                //nedenstående fjerner id nummeret fra filen
                wordStream.nextInt();
                employeeList.add(new Employee(wordStream.next().replaceAll("_", " "), wordStream.nextInt(), wordStream.next().replaceAll("_", " "), wordStream.next().replaceAll("_", " ")));
            }

            while (manInStream.hasNextLine()) {
                temp = manInStream.nextLine();
                wordStream = new Scanner(temp);
                manager = (new Manager(wordStream.next().replaceAll("_", " "), wordStream.nextInt(), wordStream.next().replaceAll("_", " "), wordStream.next().replaceAll("_", " ")));
            }

        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Something went wrong. Error msg 2.");
        }

    }

    public static void login(String username, String password){
        load();
        loadWaitingList();
        save();
        saveWait();
        boolean access = false;
        String tempUsername;
        String tempPassword;
        tempUsername = username;
        tempPassword = password;

        for (Employee employee : employeeList){
            if (employee.getLogin().containsKey(tempUsername)) {
                if (employee.getLogin().containsValue(tempPassword)) {
                    empGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    empGUI.setVisible(true);
                    access = true;
                    break;
                }
            }else if (manager.getLogin().containsKey(tempUsername)) {
                if (manager.getLogin().containsValue(tempPassword)) {
                    manGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    manGUI.setVisible(true);
                    access = true;
                    break;
                }
            }
        }if (!access){
            JOptionPane.showMessageDialog(null, "Username or password incorrect, try again.");
        }

    }

    public static void save(){
        try{
            PrintStream kidStream = new PrintStream(new FileOutputStream(".\\resources\\kid_Info.txt", false));
            PrintStream empStream = new PrintStream(new FileOutputStream(".\\resources\\employee_Info.txt", false));
            PrintStream manStream = new PrintStream(new FileOutputStream(".\\resources\\manager_Info.txt", false));

            int kidCnt = 1;
            int empCnt = 1;

            //først gemmes børnene
            for(Kid kid : kidList){
                kidStream.println(kidCnt + " " + kid.saveInfo());
                kidCnt++;
            }

            //her gemmes de ansatte
            for(Employee emp : employeeList){
                empStream.println(empCnt + " " + emp.saveInfo());
                empCnt++;
            }

            //her gemmes manager
            manStream.println(manager.saveInfo());

            manStream.close();
            empStream.close();
            kidStream.close();
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Something went wrong. Error msg 1");
        }
    }

    public static void loadWaitingList(){
        try {
            Scanner loadWait = new Scanner(new File(".\\resources\\waiting_List.txt"));
            String temp;
            Scanner wordStream;
            while (loadWait.hasNextLine()) {
                temp = loadWait.nextLine();
                wordStream = new Scanner(temp);
                waitingList.add(new Kid(wordStream.next().replaceAll("_", " "), wordStream.next().replaceAll("_", " "), wordStream.nextInt(), wordStream.next().replaceAll("_", " "), wordStream.nextInt()));
            }
            while (kidList.size() < 5){
                if (waitingList.size() == 0){
                    break;
                }else {
                    kidList.add(waitingList.get(0));
                    waitingList.remove(0);
                }
                saveWait();
            }
        }catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Something went wrong. Error msg 3");
        }
    }

    public static void saveWait(){
        try {
            PrintStream waitStream = new PrintStream(new FileOutputStream(".\\resources\\waiting_List.txt", false));

            //først gemmes børnene
            for (Kid kid : waitingList) {
                waitStream.println(kid.saveInfo());
            }
            //waitStream.println();
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Something went wrong. Error msg 1");
        }
    }

    public static ArrayList<Kid> getKidList() {
        return kidList;
    }

    public static ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public static ArrayList<Kid> getWaitingList() {
        return waitingList;
    }
}