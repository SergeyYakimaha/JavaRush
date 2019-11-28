package Command;

//Invoker
public class User {
    private Command start;
    private Command stop;
    private Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    public void startComputer() {
        start.Execute();
    }

    public void stopComputer() {
        stop.Execute();
    }

    public void resetComputer() {
        reset.Execute();
    }


}
