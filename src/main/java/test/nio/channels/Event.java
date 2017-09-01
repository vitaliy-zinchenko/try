package test.nio.channels;

import java.nio.channels.SelectionKey;

/**
 * Created by Vitalii Zinchenko
 */
public class Event {

    private SelectionKey key;

    public Event(SelectionKey key) {
        this.key = key;
    }

    public SelectionKey getKey() {
        return key;
    }
}
