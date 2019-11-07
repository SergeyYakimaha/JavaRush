package Observer;

// Объекты-издатели должны реализовать этот и интерфейс
public interface Observed {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
