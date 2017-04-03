// Team jakue -- Kenny Chen, Adeebur Rahman, Jake Zaia
// APCS2 p1
// LAB #02 -- All Hands on Deque!
// 2017-04-04

import java.util.Collection;
import java.util.Iterator;

public interface Deque<E> {
    
    // Adds to the front of the Deque
    // throws NullPointerException if input == null
    public void addFirst(E e);
    public boolean offerFirst(E e);
    public void push(E e);

    // Adds to the end of the Deque
    // throws NullPointerException if input == null
    public boolean add(E e);
    public void addLast(E e);
    public boolean offer(E e);
    public boolean offerLast(E e);

    // Peek elements in the front of the Deque
    // throws NoSuchElementException if Deque is empty
    public E element();
    public E getFirst();
    // returns null if Deque is empty
    public E peek();
    public E peekFirst();
    
    // Peek elements in the back of the Deque
    // throws NoSuchElementException if Deque is empty
    public E getLast();
    // returns null if Deque is empty
    public E peekLast();
        
    // Remove 1st element
    // throws NoSuchElementException if Deque is empty
    public E remove();
    public E removeFirst();
    public E pop();
    // returns null if Deque is empty
    public E poll();
    public E pollFirst();

    // Remove last element
    // throws NoSuchElementException if Deque is empty
    public E removeLast();
    // returns null if Deque is empty
    public E pollLast();

    // Remove a specified element
    // throws NullPointerException if input == null
    public boolean remove(Object o); // FirstOccurence
    public boolean removeFirstOccurence(Object o);
    public boolean removeLastOccurence(Object o);

    // Returns information about the Deque 
    public boolean isEmpty(); // Returns true if Deque is empty.
    public int size(); // returns size.

    // Iterators
    public Iterator<E> iterator();
    public Iterator<E> descendingIterator();

    //misc methods

    // clears deque
    public void clear();

    // throws NullPointerException if input == null or contains null
    public boolean contains(Object o);
    public boolean containsAll(Collection<?> c);

    // Return true if deque modified
    public boolean removeAll(Collection<?> c); //removes all elements from c
    public boolean retainAll(Collection<?> c); //retains only elements from c
    
}
