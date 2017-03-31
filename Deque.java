public interface Deque<T> extends Queue<T> {
    public void addFirst(T e);
    
    public void addLast(T e);

    public T peekFirst(T e);

    public T peekLast(T e);
    
    public T removeFirst();
    
    public T removeLast();
}
