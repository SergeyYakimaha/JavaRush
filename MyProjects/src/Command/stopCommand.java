package Command;

public class stopCommand implements Command {
    private Comp computer;

    public stopCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void Execute() {
        computer.stop();
    }
}
