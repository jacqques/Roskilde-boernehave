public class Employee extends Emp {
    public Employee(String name, int number) {
        super(name, number);
    }

    public Employee(String name, int number, String username, String password) {
        super(name, number, username, password);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
