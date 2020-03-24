public class Emp {
    private String name;
    private int number;
    private String username;
    private String password;

    public Emp(String name, int number) {
        this.name = name;
        this.number = number;
        this.username = "null";
        this.password = "null";
    }

    public Emp(String name, int number, String username, String password) {
        this.name = name;
        this.number = number;
        this.username = username;
        this.password = password;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo(){
        return "Employee name: " + name + ", number: " + number;
    }

    public String saveInfo(){
        return name.replaceAll(" ", "_") + " " + number + " " + username.replaceAll(" ", "_") + " " + password.replaceAll(" ", "_");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
