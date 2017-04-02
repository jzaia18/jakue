// Team jakue -- Kenny Chen, Adeebur Rahman, Jake Zaia
// APCS2 p1
// LAB #02 -- All Hands on Deque!
// 2017-04-03

public interface Queue<E> {
    public boolean add(E e);

    public boolean offer(E e);
    
    public E remove();

    public boolean remove(Object o);
    
    public E poll();

    public E element();

    public E peek();
    
    public boolean isEmpty();
}//end interface Queue                                                                                           
