package Command;

public class resetCommand implements Command {
    private Comp computer;

    public resetCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void Execute() {
        computer.reset();
    }
}
