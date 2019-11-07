package Observer;

import java.util.List;

// Объекты-подписчики должны реализовать этот интерфейс
public interface Observer {
    public void handlEvent(List<String> vacancies);
}
