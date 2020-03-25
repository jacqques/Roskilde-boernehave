public class Kid {
    private String name;
    private String parent1Name;
    private int parent1Number;
    private String parent2Name;
    private int parent2Number;
    private boolean accepted;

    public Kid(String name, String parent1Name, int parent1Number) {
        this.name = name;
        this.parent1Name = parent1Name;
        this.parent1Number = parent1Number;
        this.parent2Name = "null";
        this.parent2Number = 00000000;
    }

    public Kid(String name, String parent1Name, int parent1Number, String parent2Name, int parent2Number) {
        this.name = name;
        this.parent1Name = parent1Name;
        this.parent1Number = parent1Number;
        this.parent2Name = parent2Name;
        this.parent2Number = parent2Number;
    }

    public Kid(String name, String parent1Name, int parent1Number, String parent2Name, int parent2Number, boolean accepted) {
        this.name = name;
        this.parent1Name = parent1Name;
        this.parent1Number = parent1Number;
        this.parent2Name = parent2Name;
        this.parent2Number = parent2Number;
        this.accepted = accepted;
    }

    public String getInfo(){
        return "Kid name: " + name + ", Parent names and numbers: " + parent1Name + ", " + parent1Number + " / " + parent2Name + ", " + parent2Number;
    }

    public String saveInfo(){
        return name.replaceAll(" ", "_") + " " + parent1Name.replaceAll(" ", "_") + " " + parent1Number + " " + parent2Name.replaceAll(" ", "_") + " " + parent2Number + " " + accepted;
    }

    public String getParent1Name() {
        return parent1Name;
    }

    public String getParent2Name() {
        return parent2Name;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setParent1Number(int parent1Number) {
        this.parent1Number = parent1Number;
    }

    public void setParent2Number(int parent2Number) {
        this.parent2Number = parent2Number;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
