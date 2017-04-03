// Team jakue -- Kenny Chen, Adeebur Rahman, Jake Zaia
// APCS2 p1
// LAB #02 -- All Hands on Deque!
// 2017-04-03

public interface Deque<E> {
    
    // Adds to the front of the Deque
    public void addFirst(E e);
    public boolean offerFirst(E e);
    public void push(E e);

    // Adds to the end of the Deque
    public boolean add(E e);
    public void addLast(E e);
    public boolean offer(E e);
    public boolean offerLast(E e);

    // Returns information about the Deque
    public boolean isEmpty();    
    public boolean contains(Object o);
    
    // Peek elements in the front of the Deque
    public E element();
    public E getFirst();
    public E peek();
    public E peekFirst();
    
    // Peek elements in the back of the Deque
    public E getLast();
    public E peekLast();
        
    // Remove 1st element
    public E poll();
    public E pollFirst();
    public E remove();
    public E removeFirst();
    public E pop();

    // Remove last element
    public E pollLast();
    public E removeLast();
    
    // Remove a specified element
    public boolean remove(Object o); // Front
    public boolean removeFirstOccurence(Object o);
    public boolean removeLastOccurence(Object o);
}
