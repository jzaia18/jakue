// Team jakue -- Kenny Chen, Adeebur Rahman, Jake Zaia
// APCS2 p1
// LAB #02 -- All Hands on Deque!
// 2017-04-03

public interface Deque<E> extends Queue<E> {
    public void addFirst(E e);
    
    public void addLast(E e);

    public boolean contains(Object o);

    public E element();

    public E getFirst();

    public E getLast();

    public boolean offerFirst(E e);

    public boolean offerLast(E e);

    public E peekFirst();

    public E peekLast();

    public E pollFirst();

    public E pollLast();

    public E pop();

    public void push(E e);
        
    public E removeFirst();
    
    public E removeLast();

    public boolean removeFirstOccurence(Object o);

    public boolean removeLastOccurence(Object o);
    
}
