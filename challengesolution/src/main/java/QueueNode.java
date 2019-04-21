public class QueueNode<T> {

    public T element;
    public QueueNode<T> previous;
    public QueueNode<T> next;


    public QueueNode() {
    }

    public QueueNode(T element, QueueNode<T> previous, QueueNode<T> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }
}
