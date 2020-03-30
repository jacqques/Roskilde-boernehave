public class Manager extends Emp {
    public Manager(String name, int number, String username, String password) {
        super(name, number, username, password);
    }

    public Manager(String name, int number) {
        super(name, number);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}