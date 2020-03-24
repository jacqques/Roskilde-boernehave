import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainInterface {

    private static ArrayList<Kid> kidList = new ArrayList();
    private static ArrayList<Employee> employeeList = new ArrayList();
    private static Manager manager;

    public static void main(String[] args) {

        Kid kid1 = new Kid("Jonas Habas", "Jonathan Iversen", 23239946);

        System.out.println(kid1.getInfo());

        load();
        System.out.println(kidList.toString());
        System.out.println(employeeList.toString());
        System.out.println(manager.toString() + "\n" + manager.getInfo());
        loadWaitingList();
        login();
        save();
    }

    public static void load(){
        try{
            Scanner kidInStream = new Scanner(new File("C:\\Users\\joni2\\IdeaProjects\\RFB\\src\\Data\\kid_Info.txt"));
            Scanner empInStream = new Scanner(new File("C:\\Users\\joni2\\IdeaProjects\\RFB\\src\\Data\\employee_Info.txt"));
            Scanner manInStream = new Scanner(new File("C:\\Users\\joni2\\IdeaProjects\\RFB\\src\\Data\\manager_Info.txt"));
            Scanner wordStream;
            String temp;

                while (kidInStream.hasNextLine()) {
                    temp = kidInStream.nextLine();
                    wordStream = new Scanner(temp);
                    //nedenstående fjerner id nummeret fra filen
                    wordStream.nextInt();
                    kidList.add(new Kid(wordStream.next().replaceAll("_", " "), wordStream.next().replaceAll("_", " "), wordStream.nextInt(), wordStream.next().replaceAll("_", " "), wordStream.nextInt(), wordStream.nextBoolean()));
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
            System.out.println("OOOOF 2");
        }

    }

    public static void login(){
        if(true){
            managerInterface();
        }else{
            employeeInterface();
        }
    }

    public static void save(){
        try{
            PrintStream kidStream = new PrintStream(new FileOutputStream("C:\\Users\\joni2\\IdeaProjects\\RFB\\src\\Data\\kid_Info.txt", false));
            PrintStream empStream = new PrintStream(new FileOutputStream("C:\\Users\\joni2\\IdeaProjects\\RFB\\src\\Data\\employee_Info.txt", false));
            PrintStream manStream = new PrintStream(new FileOutputStream("C:\\Users\\joni2\\IdeaProjects\\RFB\\src\\Data\\manager_Info.txt", false));

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
            System.out.println("OOOOF 1");
        }
    }

    public static void managerInterface(){

    }
    public static void employeeInterface(){

    }

    public static void loadWaitingList(){

    }

}
