package Collection;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueStudy {

    @Test
    public void name() {
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("");
        queue.remove();
        queue.poll();
        queue.element();
        queue.peek();
    }
}
