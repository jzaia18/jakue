// Team jakue -- Kenny Chen, Adeeb Rahman, Jake Zaia
// APCS2 p1
// LAB #02 -- All Hands on Deque!
// 2017-04-03

public interface Deque<T> extends Queue<T> {
    public void addFirst(T e);
    
    public void addLast(T e);

    public T peekFirst();

    public T peekLast();
    
    public T removeFirst();
    
    public T removeLast();
}
