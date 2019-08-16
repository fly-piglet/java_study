package Collection;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStudy {

    @Test
    public void name() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("");
        deque.addLast("");
        deque.offerFirst("");
        deque.offerLast("");
        deque.removeFirst();
        deque.removeLast();
        deque.pollFirst();
        deque.pollLast();
        deque.getFirst();
        deque.getLast();
        deque.peekFirst();
        deque.peekLast();
        deque.removeFirstOccurrence(new Object());
        deque.removeLastOccurrence(new Object());
        deque.push("");
        deque.pop();
        deque.descendingIterator();
    }
}
