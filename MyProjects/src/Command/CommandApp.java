package Command;

public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User u = new User(new startCommand(comp), new stopCommand(comp), new resetCommand(comp));
        u.startComputer();
        u.stopComputer();
        u.startComputer();
        u.resetComputer();
    }
}
