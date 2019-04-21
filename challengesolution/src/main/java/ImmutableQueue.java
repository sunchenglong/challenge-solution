import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ImmutableQueue<T> implements Queue<T> {
    private QueueNode<T> headNode = null;
    private QueueNode<T> tailNode = null;

    public ImmutableQueue<T> constructImmutableQueue(ImmutableQueue<T> immutableQueue) {
        ImmutableQueue<T> resultImmutableQueue = new ImmutableQueue<T>();
        resultImmutableQueue.headNode = immutableQueue.headNode;
        resultImmutableQueue.tailNode = immutableQueue.tailNode;
        return resultImmutableQueue;
    }

    public void enqueueConstruct(T t) {
        if (headNode == null) {
            headNode = new QueueNode<T>(t, null, null);
            tailNode = headNode;
        } else {
            QueueNode<T> node = new QueueNode<T>(t, tailNode, null);
            tailNode.next = node;
            tailNode = node;
        }
    }


    public ImmutableQueue<T> enQueue(T t) {
        if (t == null)
            throw new IllegalArgumentException();
        ImmutableQueue<T> immutableQueue = constructImmutableQueue(this);
        if (this.isEmpty()) {
            immutableQueue.headNode = new QueueNode<T>(t, null, null);
            immutableQueue.tailNode = immutableQueue.headNode;
        } else {
            QueueNode<T> node = new QueueNode<T>(t, immutableQueue.tailNode, null);
            immutableQueue.tailNode.next = node;
            immutableQueue.tailNode = node;
        }
        return immutableQueue;
    }

    public ImmutableQueue<T> deQueue() {
        if (headNode == null && tailNode == null) {
            throw new NoSuchElementException();
        } else {
            ImmutableQueue<T> immutableQueue = constructImmutableQueue(this);
            QueueNode<T> delNode = immutableQueue.headNode;
            immutableQueue.headNode.next.previous = null;
            immutableQueue.headNode = immutableQueue.headNode.next;
            delNode = null;
            return immutableQueue;
        }
    }

    public T head() {
        return headNode.element;
    }

    public List<T> transList() {
        QueueNode<T> queueNode = new QueueNode<T>();
        queueNode = headNode;
        List<T> result = new ArrayList<T>();
        while (queueNode != null) {
            result.add(queueNode.element);
            if (queueNode.equals(tailNode)) {
                break;
            }
            queueNode = queueNode.next;
        }
        return result;
    }

    public boolean isEmpty() {
        return headNode == null;
    }
}
