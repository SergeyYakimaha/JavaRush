package Command;

//ConcreteCommand
public class startCommand implements Command {
    private Comp computer;

    public startCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void Execute() {
        computer.start();
    }
}
