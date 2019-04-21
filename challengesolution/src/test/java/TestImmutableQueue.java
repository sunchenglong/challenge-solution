import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class TestImmutableQueue {
    @Test
    public void TestImmutableQueue() {
        ImmutableQueue<Integer> immutableQueue = new ImmutableQueue();
        Assert.assertEquals(immutableQueue.isEmpty(), true);
        immutableQueue.enQueue(1);
        immutableQueue.enQueue(2);

        // Verify  enQueue do not change the origin queue
        Assert.assertEquals(immutableQueue.isEmpty(), true);
        ImmutableQueue immutableQueue3 =
                immutableQueue
                        .enQueue(1)
                        .enQueue(2)
                        .enQueue(3);
        Assert.assertEquals(immutableQueue3.isEmpty(), false);
        Assert.assertEquals(immutableQueue3.head(), 1);
        List<Integer> queue3Array = new ArrayList<Integer>();
        queue3Array.add(1);
        queue3Array.add(2);
        queue3Array.add(3);
        Assert.assertEquals(immutableQueue3.transList(), queue3Array);

        ImmutableQueue del1Queue = immutableQueue3.deQueue();
        List<Integer> del1Array = new ArrayList<Integer>();
        del1Array.add(2);
        del1Array.add(3);
        Assert.assertEquals(del1Queue.transList(), del1Array);

        // Verify  delQueue do not change the origin queue
        Assert.assertEquals(immutableQueue3.transList(), queue3Array);
    }
}
