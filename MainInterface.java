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
        //editInformation();
        System.out.println(kidList.toString());
        System.out.println(employeeList.toString());
        System.out.println(manager.toString());
        loadWaitingList();
        login();
        save();
    }

    public static void load(){
        try{
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
        Scanner userIn = new Scanner(System.in);
        String tempUsername;
        String tempPassword;
        boolean access = true;
        while (access) {
            System.out.print("Please enter your username(or type 1 to finish): ");
            tempUsername = userIn.next();
            System.out.print("Please enter your password(or type 1 to finish): ");
            tempPassword = userIn.next();

            for (Employee employee : employeeList){
                if (employee.getLogin().containsKey(tempUsername)){
                    if (employee.getLogin().containsValue(tempPassword)) {
                        employeeInterface(employee);
                        access = false;
                        break;
                    }
                }
            }

            if (manager.getLogin().containsKey(tempUsername)) {
                if (manager.getLogin().containsValue(tempPassword)) {
                    managerInterface();
                    access = false;
                }
            } else if (tempUsername.equals("1") || tempPassword.equals("1")){
                access = false;
                System.out.println("Goodbye cruel world.");
            } else if (access){
                System.out.println("Username or password is incorrect, please try again.");
            }
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
            System.out.println("OOOOF 1");
        }
    }

    public static void managerInterface(){
        int pagepick = 0;
        boolean access =true;
        Scanner userIn = new Scanner(System.in);
        while(access) {
            System.out.println("Welcome " + manager.getName() + ", please pick a function.");
            pagepick = userIn.nextInt();

            if (pagepick == 1) {
                viewInformation();
            } else if (pagepick == 2) {
                editInformation();
            }
        }

    }
    public static void employeeInterface(Employee employee){

        System.out.println("-------------------------------");
        System.out.println("Welcome " + employee.getName());
        System.out.println("-------------------------------");
        viewInformation();

    }

    public static void loadWaitingList(){

    }

    public static void viewInformation(){
        boolean access = true;
        int pagepick = 0;
        Scanner userIn = new Scanner(System.in);

        while (access) {
            System.out.print("Please pick information for kids or employees.");
            System.out.print("\n1. Kid information\n2. Employee information.\n3. Exit\nMenu pick: ");
            pagepick = userIn.nextInt();

            System.out.println("-------------------------------\n");
            if (pagepick == 1) {
                for (Kid kid : kidList) {
                    System.out.println(kid.getInfo());
                }
                System.out.println("\n-------------------------------");
            } else if (pagepick == 2) {
                for (Employee employee : employeeList) {
                    System.out.println(employee.getInfo());
                }
                System.out.println("\n-------------------------------");
            }else if (pagepick == 3){
                access = false;
            }else {
                System.out.println("Not a valid input");
                System.out.println("\n-------------------------------");
            }
        }
        save();
    }

    public static void editInformation() {
        boolean access = true;
        boolean notDone = true;
        String tempString;
        int tempInt;
        int pagepick = 0;
        int arrPick = 0;
        int cnt = 1;
        Scanner userIn = new Scanner(System.in);


        while (access) {
            System.out.print("Please pick information to edit.");
            System.out.print("\n1. Kid information\n2. Employee information.\n3. Exit\nMenu pick: ");
            pagepick = userIn.nextInt();


            if (pagepick == 1) {
                System.out.println("-------------------------------\n");
                System.out.print("Please pick a kid to edit.");
                System.out.println("\n-------------------------------\n");
                cnt = 1;
                for (Kid kid : kidList) {
                    System.out.println(cnt + ". " + kid.getInfo());
                    cnt++;
                }
                System.out.println("\n-------------------------------");
                System.out.print("Menu pick(use id number): ");
                arrPick = userIn.nextInt() - 1;

                System.out.print("\nPlease choose info to edit. ");
                System.out.println("\n-------------------------------");
                System.out.println("\n1. " + kidList.get(arrPick).getParent1Name() + "'s number\n2. " + kidList.get(arrPick).getParent2Name() + "'s number\n3. Exit");
                System.out.println("\n-------------------------------");
                System.out.print("Menu pick(use id number): ");
                pagepick = userIn.nextInt();
                if (pagepick == 1) {
                    while(notDone) {
                        System.out.println("-------------------------------");
                        System.out.print("Enter " + kidList.get(arrPick).getParent1Name() + "'s number: ");
                        tempInt = userIn.nextInt();
                        System.out.print("Check if entered data correct. " + kidList.get(arrPick).getParent1Name() + "'s number is " + tempInt +
                                "\n1 for yes, 2 for no: ");
                        pagepick = userIn.nextInt();
                        if (pagepick == 1) {
                            System.out.println("-------------------------------");
                            kidList.get(arrPick).setParent1Number(tempInt);
                            save();
                            notDone = false;
                        }
                    }
                } else if (pagepick == 2) {
                    while(notDone) {
                        System.out.println("-------------------------------");
                        System.out.print("Enter " + kidList.get(arrPick).getParent2Name() + "'s number: ");
                        tempInt = userIn.nextInt();
                        System.out.print("Check if entered data correct. " + kidList.get(arrPick).getParent2Name() + "'s number is " + tempInt +
                                "\n1 for yes, 2 for no: ");
                        pagepick = userIn.nextInt();
                        if (pagepick == 1) {
                            System.out.println("-------------------------------");
                            kidList.get(arrPick).setParent2Number(tempInt);
                            save();
                            notDone = false;
                        }
                    }
                } else if (pagepick == 3) {
                    access = false;
                } else {
                    System.out.println("Not a valid input!");
                }

            } else if (pagepick == 2) {
                    System.out.println("-------------------------------\n");
                    System.out.print("Please pick a employee to edit.");
                    System.out.println("\n-------------------------------\n");
                    cnt = 1;
                    for (Employee employee : employeeList) {
                        System.out.println(cnt + ". " + employee.getInfo());
                        cnt++;
                    }
                    System.out.println("\n-------------------------------");
                    System.out.print("Menu pick(use id number): ");
                    arrPick = userIn.nextInt() - 1;

                    System.out.print("\nPlease choose info to edit. ");
                    System.out.println("\n-------------------------------");
                    System.out.print("\n1. " + employeeList.get(arrPick).getName() + "'s number\n2. " + employeeList.get(arrPick).getName() +
                                       "'s password");
                    System.out.println("\n\n-------------------------------");
                    System.out.print("Menu pick(use id number): ");
                    pagepick = userIn.nextInt();
                    if (pagepick == 1){
                        notDone = true;
                        while(notDone) {
                            System.out.println("-------------------------------");
                            System.out.print("Enter " + employeeList.get(arrPick).getName() + "'s number: ");
                            tempInt = userIn.nextInt();
                            System.out.print("Check if entered data correct. " + employeeList.get(arrPick).getName() + "'s number is " + tempInt +
                                    "\n1 for yes, 2 for no: ");
                            pagepick = userIn.nextInt();
                            if (pagepick == 1) {
                                System.out.println("-------------------------------");
                                employeeList.get(arrPick).setNumber(tempInt);
                                save();
                                notDone = false;
                            }
                        }
                    }else if (pagepick == 2) {
                        notDone = true;
                        while (notDone) {
                            System.out.println("-------------------------------");
                            System.out.print("Enter " + employeeList.get(arrPick).getName() + "'s password: ");
                            tempString = userIn.next();
                            System.out.print("Check if entered data correct. " + employeeList.get(arrPick).getName() + "'s password is " + tempString +
                                    "\n1 for yes, 2 for no: ");
                            pagepick = userIn.nextInt();
                            if (pagepick == 1) {
                                System.out.println("-------------------------------");
                                employeeList.get(arrPick).setPassword(tempString);
                                save();
                                notDone = false;
                            }
                        }
                    }
            }else if (pagepick == 3){
                access = false;
            }else{
                System.out.println("Not a valid input!");
            }
        }
        save();
    }

}
