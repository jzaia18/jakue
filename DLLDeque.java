// Team jakue -- Kenny Chen, Adeebur Rahman, Jake Zaia
// APCS2 p1
// LAB #02 -- All Hands on Deque!
// 2017-04-04

/*****************************************************
 * class DLLDeque                                    *
 * Implements a doubly-linked node-based Deque       *
 *****************************************************/

import java.util.NoSuchElementException;
import java.lang.NullPointerException;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

public class DLLDeque<E> implements Deque<E> {

    //instance vars
    DLLNode<E> _front, _end; //pointers to first and last nodes
    int _size; //size attribute


    // constructor -- initializes instance vars
    public DLLDeque() {
	_front = _end = null; //at birth, a list has no elements
	_size = 0; //and size is 0
    }
    
    //addition methods

    //add node at the front of deque
    //throws NullPointerException if input is null
    public boolean offerFirst(E e) {
	if (e == null) { throw new NullPointerException(); }
	else if (isEmpty()) { _front = _end = new DLLNode<E>(e, null, null); }
	else {
	    _front.setPrev(new DLLNode<E>(e, null, _front));
	    _front = _front.getPrev();
	}
	_size++;
	return true; //per Java API spec
    }//O(1)
    
    //add node at the front of deque
    //throws NullPointerException if input is null
    public boolean offerLast(E e) {
	if (e == null) { throw new NullPointerException(); }
	else if (isEmpty()) { _front = _end = new DLLNode<E>(e, null, null); }
	else {
	    _end.setNext(new DLLNode<E>(e, _end, null));
	    _end = _end.getNext();
	}
	_size++;
	return true; //per Java API spec
    }//O(1)

    //same as offerLast
    public boolean offer(E e) {	return offerLast(e); } //O(1)

    //same as offerFirst no return 
    public void addFirst(E e) { offerFirst(e); } //O(1)

    //same as offerLast no return 
    public void addLast(E e) { offerLast(e); } //O(1)

    //same as offerLast
    public boolean add(E e) { return offerLast(e); } //O(1)

    //same as addFirst no return
    public void push(E e) { addFirst(e); } //O(1)

    
    //accessor methods
    //returns value at _front, null if _front is null
    public E peekFirst() {
	if (isEmpty()) { return null; }
	return _front.getCargo();
    }//O(1)
    
    //returns value at _end, null if _end is null
    public E peekLast() {
	if (isEmpty()) { return null; }
	return _end.getCargo();
    }//O(1)

    //same as peekFirst
    public E peek() { return peekFirst(); } //O(1)

    //returns value at _front, throws NoSuchElementException if Deque is empty
    public E element() {
	if (isEmpty()) { throw new NoSuchElementException(); }
	return _front.getCargo();
    }//O(1)

    //same as element
    public E getFirst() { return element(); } //O(1)
    
    //returns value at _end, throws NoSuchElementException if Deque is empty
    public E getLast() {
	if (isEmpty()) { throw new NoSuchElementException(); }
	return _end.getCargo();
    }//O(1)

    //removal methods

    //removes node at _front, returns old value at _front
    //returns null if deque is empty
    public E pollFirst() {
	if (isEmpty()) { return null; }
        E ret = getFirst();
	if (size() == 1) { _front = _end = null; }
	else {
	    _front = _front.getNext();
	    _front.setPrev(null);
	}
	_size--;
	return ret;
    }//O(1)


    //removes node at _end, returns old value at _end
    //returns null if deque is empty
    public E pollLast() {
	if (isEmpty()) { return null; }
        E ret = getLast();
	if ( size() == 1 ) { _front = _end = null; }
        else {
	    _end = _end.getPrev();
            _end.setNext( null );
        }
	_size--;
	return ret;
    }//O(1)

    //same as pollFirst
    public E poll() { return pollFirst(); } //O(1)

    //removes node at _front, returns old value at _front
    //throws NoSuchElementException if deque is empty
    public E removeFirst() {
	if (isEmpty()) { throw new NoSuchElementException(); }
        E ret = getFirst();
	if (size() == 1) { _front = _end = null; }
	else {
	    _front = _front.getNext();
	    _front.setPrev(null);
	}
	_size--;
	return ret;
    }//O(1)
    
    //removes node at _end, returns old value at _end
    //throws NoSuchElementException if deque is empty
    public E removeLast() {
	if (isEmpty()) { throw new NoSuchElementException(); }
        E ret = getLast();
	if ( size() == 1 ) { _front = _end = null; }
        else {
	    _end = _end.getPrev();
            _end.setNext( null );
        }
	_size--;
	return ret;
    }//O(1)

    //same as removeFirst
    public E remove() { return removeFirst(); } //O(1)

    //same as removeFirst
    public E pop() { return removeFirst(); } //O(1)
        
    //misc methods

    //returns true if deque is empty
    public boolean isEmpty() { return _size == 0; } //O(1)

    //empties the deque
    public void clear() { while (!isEmpty()) { pollFirst(); } } //O(n)

    //returns the size of the deque
    public int size() { return _size; } //O(1)

    //removes first Occurrence of o
    //throws NullPointerException if input is null
    public boolean removeFirstOccurrence(Object o) {
	if (o == null) { throw new NullPointerException(); }
	Iterator<E> it = iterator();
	while(it.hasNext()) {
	    if (o.equals(it.next())) {
		it.remove();
		return true;
	    }
	}
	return false;
    }//O(n)

    //removes last Occurrence of o
    //throws NullPointerException if input is null
    public boolean removeLastOccurrence(Object o) {
	if (o == null) { throw new NullPointerException(); }
	Iterator<E> it = descendingIterator();
	while(it.hasNext()) {
	    if (o.equals(it.next())) {
		it.remove();
		return true;
	    }
	}
	return false;
    }//O(n)

    //same as removeFirstOccurrence
    public boolean remove(Object o) { return removeFirstOccurrence(o); } //O(n)

    //toString as per java.util.AbstractCollection
    public String toString() {
	if (size() == 0) { return "[]"; }
	String ret = "[";
	for (DLLNode<E> tmp = _front; tmp!= null; tmp = tmp.getNext()) {
	    ret += tmp.getCargo() + ", ";
	}
	ret = ret.substring(0,ret.length()-2) + "]";
	return ret;
    }//O(n)

    //returns true if o is in the deque
    //throws NullPointerException if input is null
    public boolean contains(Object o) {
	if (o == null ) { throw new NullPointerException(); }	
	for (DLLNode<E> tmp = _front; tmp!= null; tmp = tmp.getNext()) {
	    if (o.equals(tmp.getCargo())) { return true; }
	}
	return false;
    }//O(n)


    //returns true if deque contains all elements in Collection c.
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }//O(n)

    //removes all Occurrences of elements from collection c in deque.
    //returns true if deque changed.
    public boolean removeAll(Collection<?> c) {
	Iterator<E> it = iterator();
	boolean changed = false;
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
		changed = true;
	    }
	}
	return changed;
    }//O(n)

    //removes elements which aren't in collection c from deque.
    //returns true if deque changed.
    public boolean retainAll(Collection<?> c) {
        Iterator<E> it = iterator();
        boolean changed = false;
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                changed = true;
            }
        }
        return changed;
    }//O(n)

    //return an Iterator over this list
    public Iterator<E> iterator() { return new MyAscendingIterator(); } //O(1)

    //return a Descending Iterator over this list
    public Iterator<E> descendingIterator() { return new MyDescendingIterator(); } //O(1)

    
    /*****************************************************
     * inner class MyAscendingIterator
     * Adheres to specifications given by Iterator interface.
     * Uses dummy node to facilitate iterability over LList.
     *****************************************************/
    private class MyAscendingIterator implements Iterator<E> {

	private DLLNode<E> _dummy; // dummy node to tracking pos
	private boolean _okToRemove; //flag indicates next() was called

	//constructor 
	public MyAscendingIterator() {
	    //place dummy node in front of _front
	    _dummy = new DLLNode<E>( null, null, _front );
	    //set oktorem flag
	    _okToRemove = false;
	}

	//--------------v  Iterator interface methods  v-------------
	//return true if iteration has more elements.
	public boolean hasNext() { return _dummy.getNext() != null; } //O(1)

	//return next element in this iteration
	public E next() {
	    _dummy = _dummy.getNext();
	    if ( _dummy == null )
		throw new NoSuchElementException();
	    _okToRemove = true;
	    return _dummy.getCargo();
	}//O(1)


	//remove last element returned by this iterator (from last next() call)
	public void remove() {
	    if ( ! _okToRemove )
		throw new IllegalStateException("must call next() beforehand");
	    _okToRemove = false;

	    //If removing only remaining node...
	    //maintain invariant that _dummy always points to a node
	    //   (...so that hasNext() will not crash)
	    if ( _front == _end ) {
		_front = _end = null;
	    }
	    //if removing first node...
	    else if ( _front == _dummy ) {
		_front = _front.getNext();
		_front.setPrev( null ); //just to save mem
	    }
	    //if removing last node...
	    else if ( _end == _dummy ) {
		_end = _end.getPrev();
		_end.setNext( null );
	    }
	    //if removing an interior node...
	    else {
		_dummy.getNext().setPrev( _dummy.getPrev() );
		_dummy.getPrev().setNext( _dummy.getNext() );
	    }
	    _size--; //decrement size attribute of outer class LList
	}//O(1)
	//--------------^  Iterator interface methods  ^--------------
    }//*************** end inner class MyAscendingIterator ***************

    
    /*****************************************************
     * inner class MyDescendingIterator
     * Adheres to specifications given by Iterator interface.
     * Uses dummy node to facilitate iterability over LList.
     *****************************************************/
    private class MyDescendingIterator implements Iterator<E> {

	private DLLNode<E> _dummy; // dummy node to tracking pos
	private boolean _okToRemove; //flag indicates next() was called

	//constructor 
	public MyDescendingIterator() {
	    //place dummy node after _end 
	    _dummy = new DLLNode<E>( null, _end, null );
	    //set oktorem flag
	    _okToRemove = false;
	}

	//--------------v  Iterator interface methods  v-------------
	//return true if iteration has more elements.
	public boolean hasNext() { return _dummy.getPrev() != null; }//O(1)


	//return next element in this iteration
	public E next() {
	    _dummy = _dummy.getPrev();
	    if ( _dummy == null )
		throw new NoSuchElementException();
	    _okToRemove = true;
	    return _dummy.getCargo();
	}//O(1)


	//remove last element returned by this iterator (from last next() call)
	public void remove() {
	    if ( ! _okToRemove )
		throw new IllegalStateException("must call next() beforehand");
	    _okToRemove = false;

	    //If removing only remaining node...
	    //maintain invariant that _dummy always points to a node
	    //   (...so that hasNext() will not crash)
	    if ( _front == _end ) {
		_front = _end = null;
	    }
	    //if removing first node...
	    else if ( _front == _dummy ) {
		_front = _front.getNext();
		_front.setPrev( null ); //just to save mem
	    }
	    //if removing last node...
	    else if ( _end == _dummy ) {
		_end = _end.getPrev();
		_end.setNext( null );
	    }
	    //if removing an interior node...
	    else {
		_dummy.getNext().setPrev( _dummy.getPrev() );
		_dummy.getPrev().setNext( _dummy.getNext() );
	    }
	    _size--; //decrement size attribute of outer class LList
	}//O(1)
	//--------------^  Iterator interface methods  ^--------------
    }//*************** end inner class MyDescendingIterator ***************

    //main method for testing
    public static void main (String[] args){


	System.out.println("\n\nException Checking");
	Deque<String> deck = new DLLDeque<String>();
	//get testing
	String s = "test";
	try {
	    s = deck.getFirst(); //should throw exception. s should still be test.
	    if (!s.equals("test")) { System.out.println("getFirst() wrongly returned a value"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("getFirst() properly threw an exception");
	}
	
	//element testing
	s = "test";
	try {
	    s = deck.element(); //should throw exception. s should still be test.
	    if (!s.equals("test")) { System.out.println("element() wrongly returned a value"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("element() properly threw an exception");
	}
	
	//peek testing
	s = "test";
	try {
	    s = deck.peekFirst(); //s should be null;
	    if (s == null) { System.out.println("peekFirst() properly returned null"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("peekFirst() wrongly threw an exception");
	}
	
	//removeFirst testing
	s = "test";
	try {
	    s = deck.removeFirst(); //should throw exception. s should still be test.
	    if (!s.equals("test")) { System.out.println("removeFirst() wrongly returned a value"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("removeFirst() properly threw an exception");
	}

	//pop  testing
	s = "test";
	try {
	    s = deck.pop(); //should throw exception. s should still be test.
	    if (!s.equals("test")) { System.out.println("pop() wrongly returned a value"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("pop() properly threw an exception");
	}

	//poll testing
	s = "test";
	try {
	    s = deck.pollFirst(); //s should be null;
	    if (s == null) { System.out.println("pollFirst() properly returned null"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("pollFirst() wrongly threw an exception");
	}
	
	//add testing
	try {
	    deck.addFirst(null);
	    System.out.println("addFirst(null) should have thrown an exception but didn't");
	}
	catch (NullPointerException e) {
	    System.out.println("addFirst(null) properly threw an exception");
	}

	//offer testing
	try {
	    deck.offerFirst(null);
	    System.out.println("offerFirst(null) should have thrown an exception but didn't");
	}
	catch (NullPointerException e) {
	    System.out.println("offerFirst(null) properly threw an exception");
	}

	//push testing
	try {
	    deck.push(null);
	    System.out.println("push(null) should have thrown an exception but didn't");
	}
	catch (NullPointerException e) {
	    System.out.println("push(null) properly threw an exception");
	}

	//contains testing
	try {
	    deck.contains(null);
	    System.out.println("contains(null) should have thrown an exception but didn't");
	}
	catch (NullPointerException e) {
	    System.out.println("contains(null) properly threw an exception");
	}

	//removeFirstOccurrence testing
	try {
	    deck.removeFirstOccurrence(null);
	    System.out.println("removeFirstOccurrence(null) should have thrown an exception but didn't");
	}
	catch (NullPointerException e) {
	    System.out.println("removeFirstOccurrence(null) properly threw an exception");
	}


	//removeLastOccurrence testing
	try {
	    deck.removeLastOccurrence(null);
	    System.out.println("removeLastOccurrence(null) should have thrown an exception but didn't");
	}
	catch (NullPointerException e) {
	    System.out.println("removeLastOccurrence(null) properly threw an exception");
	}

	System.out.println("\n\nGeneral Testing");	
	System.out.println("\nDLLDeque<Object> d = new DLLDeque<Object>()");
	DLLDeque<Object> d = new DLLDeque<Object>();
	
	System.out.println("\ntesting various add methods");
	System.out.println("d.offerFirst(\"c\")");
	d.offerFirst("c"); 
	System.out.println("d: " + d); //d: [c]
	System.out.println("d.addFirst(\"b\")");
	d.addFirst("b"); 
	System.out.println("d: " + d); //d: [b, c]
	System.out.println("d.push(\"a\")");
	d.push("a");
	System.out.println("d: " + d); //d: [a, b, c]
	System.out.println("d.offerLast(\"y\")");
	d.offerLast("y");
	System.out.println("d: " + d); //d: [a, b, c, y]
	System.out.println("d.addLast(\"z\"): ");
	d.addLast("z");
	System.out.println("d: " + d); //d: [a, b, c, y, z]

	System.out.println("\ntesting various accessor methods");
	System.out.println("d.getFirst(): " + d.getFirst()); //d.getFirst(): a
	System.out.println("d.peekFirst(): " + d.peekFirst()); //d.peekFirst(): a
	System.out.println("d.element(): " + d.element()); //d.element(): a
	System.out.println("d.getLast(): " + d.getLast()); //d.getLast(): z
	System.out.println("d.peekLast(): " + d.peekLast()); //d.peekLast(): z

	System.out.println("\ntesting size() and isEmpty()");
	System.out.println("d: " + d); //d: [a, b, c, y, z]
	System.out.println("d.size(): " + d.size()); //d.size(): 5
	System.out.println("d.isEmpty(): " + d.isEmpty()); //d.isEmpty(): false

	System.out.println("\ntesting clear() and size() and isEmpty()");
	System.out.println("d: " + d); //d: [a, b, c, y, z]
	System.out.println("d.clear()");
	d.clear();
	System.out.println("d: " + d); //d: []
	System.out.println("d.size(): " + d.size()); //d.size(): 0
	System.out.println("d.isEmpty(): " + d.isEmpty()); //d.isEmpty(): true

	System.out.println("\ntesting misc methods");
	System.out.println("d.offer(\"p\")"); 
	d.offer("p");
	System.out.println("d: " + d); //d: [p]
	System.out.println("d.offer(\"L\")");
	d.offer("L");
	System.out.println("d: " + d); //d: [p, L]
	System.out.println("d.offer(\"b\")");
	d.offer("b");
	System.out.println("d: " + d); //d: [p, L, b]
	System.out.println("d.offer(\"L\")");
	d.offer("L");
	System.out.println("d: " + d); //d: [p, L, b, L]
	System.out.println("d.offer(\"p\")");
	d.offer("p");
	System.out.println("d: " + d); //d: [p, L, b, L, p]
	System.out.println("d.offer(\"L\")");
	d.offer("L");
	System.out.println("d: " + d); //d: [p, L, b, L, p, L]
	System.out.println("d.offer(\"b\")");
	d.offer("b");
	System.out.println("d: " + d); //d: [p, L, b, L, p, L, b]

	System.out.println("\ntesting contains(Object o)");
	System.out.println("d.contains(\"L\"): " + d.contains("L")); //d.contains("L"): true
	System.out.println("\ntesting removeFirstOccurrence(Object o)");	
	System.out.println("d: " + d); //d: [p, L, b, L, p, L, b]
	System.out.println("d.removeFirstOccurrence(\"L\"): " + d.removeFirstOccurrence("L")); //d.removeFirstOccurrence("L"): true
	System.out.println("d: " + d); //d: [p, b, L, p, L, b]
	System.out.println("\ntesting removeLastOccurrence(Object o)");
	System.out.println("d: " + d); //d: [p, b, L, p, L, b]
	System.out.println("d.removeLastOccurrence(\"L\"): " + d.removeLastOccurrence("L")); //d.removeLastOccurrence("L"): true
	System.out.println("d: " + d); //d: [p, b, L, p, b]

	System.out.println("\nd.offerLast(\"b\")");
	d.offerLast("b");
	System.out.println("d: " + d); //d: [p, b, L, p, b, b]

	System.out.println("\nd.offerFirst(\"p\")");
	d.offerFirst("p");
	System.out.println("d: " + d); //d: [p, p, b, L, p, b, b]

	System.out.println("\ntesting removeFirstOccurrence(Object o)");
	System.out.println("d: " + d); //d: [p, p, b, L, p, b, b]
        System.out.println("d.removeFirstOccurrence(\"p\"): " + d.removeFirstOccurrence("p")); //d.removeFirstOccurrence("p"): true
        System.out.println("d: " + d); //d: [p, b, L, p, b, b]
        System.out.println("\ntesting removeLastOccurrence(Object o)");
        System.out.println("d: " + d); //d: [p, b, L, p, b, b]
        System.out.println("d.removeLastOccurrence(\"b\"): " + d.removeLastOccurrence("b")); //d.removeLastOccurrence("b"): true
        System.out.println("d: " + d); //d: [p, b, L, p, b]
	
	System.out.println("\ntesting various remove methods");
	System.out.println("d.pollFirst(): " + d.pollFirst()); //d.pollFirst(): p
	System.out.println("d: " + d); //d: [b, L, p, b]
	System.out.println("d.removeFirst(): " + d.removeFirst()); //d.removeFirst(): b
	System.out.println("d: " + d); //d: [L, p, b]
	System.out.println("d.pop(): " + d.pop()); //d.pop(): L
	System.out.println("d: " + d); //d: [p, b]
	System.out.println("d.pollLast(): " + d.pollLast()); //d.pollLast(): b
	System.out.println("d: " + d); //d: [p]
	System.out.println("d.removeLast(): " + d.removeLast()); //d.removeLast(): p
	System.out.println("d: " + d); //d: []

	System.out.println("\ntesting for null output");
	System.out.println("d.peekFirst(): " + d.peekFirst()); //d.peekFirst(): null
	System.out.println("d.peekLast(): " + d.peekLast()); //d.peekLast(): null
	System.out.println("d.pollFirst(): " + d.pollFirst()); //d.pollFirst(): null
	System.out.println("d.pollLast(): " + d.pollLast()); //d.pollLast(): null


	System.out.println("\ntesting iterator()");
	System.out.println("d.offer(\"a\")");
	d.offer("a");
	System.out.println("d: " + d); //d: [a]
	System.out.println("d.offer(\"b\")");
	d.offer("b");
	System.out.println("d: " + d); //d: [a, b]
	System.out.println("d.offer(\"c\")");
	d.offer("c");
	System.out.println("d: " + d); //d: [a, b, c]
	System.out.println("d.offer(\"d\")");
	d.offer("d");
	System.out.println("d: " + d); //d: [a, b, c, d]

	System.out.println("Iterator<Object> ascIt = d.iterator()");
	Iterator<Object> ascIt = d.iterator();

	System.out.println("ascIt.hasNext(): " + ascIt.hasNext()); //ascIt.hasNext(): true
	System.out.println("ascIt.next(): " + ascIt.next()); //ascIt.next(): a
	System.out.println("ascIt.hasNext(): " + ascIt.hasNext()); //ascIt.hasNext(): true
	System.out.println("ascIt.next(): " + ascIt.next()); //ascIt.next(): b
	System.out.println("ascIt.hasNext(): " + ascIt.hasNext()); //ascIt.hasNext(): true
	System.out.println("ascIt.next(): " + ascIt.next()); //ascIt.next(): c
	System.out.println("ascIt.remove()");
	ascIt.remove();
	System.out.println("d: " + d); //d: [a, b, d]
	System.out.println("ascIt.hasNext(): " + ascIt.hasNext()); //ascIt.hasNext(): true
	System.out.println("ascIt.next(): " + ascIt.next()); //ascIt.next(): d
	System.out.println("ascIt.hasNext(): " + ascIt.hasNext()); //ascIt.hasNext(): false

	System.out.println("\nd.clear()");
	d.clear();
	System.out.println("d: " + d);//d: []

	System.out.println("\ntesting descendingIterator()");
	System.out.println("d.offer(\"a\")");
	d.offer("a");
	System.out.println("d: " + d); //d: [a]
	System.out.println("d.offer(\"b\")");
	d.offer("b");
	System.out.println("d: " + d); //d: [a, b]
	System.out.println("d.offer(\"c\")");
	d.offer("c");
	System.out.println("d: " + d); //d: [a, b, c]
	System.out.println("d.offer(\"d\")");
	d.offer("d");
	System.out.println("d: " + d); //d: [a, b, c, d]

	System.out.println("Iterator<Object> descIt = d.descendingIterator()");
	Iterator<Object> descIt = d.descendingIterator();
	
	System.out.println("descIt.hasNext(): " + descIt.hasNext()); //descIt.hasNext(): true
	System.out.println("descIt.next(): " + descIt.next()); //descIt.next(): d
	System.out.println("descIt.hasNext(): " + descIt.hasNext()); //descIt.hasNext(): true
	System.out.println("descIt.next(): " + descIt.next()); //descIt.next(): c
	System.out.println("descIt.hasNext(): " + descIt.hasNext()); //descIt.hasNext(): true
	System.out.println("descIt.next(): " + descIt.next()); //descIt.next(): b
	System.out.println("descIt.remove()");
	descIt.remove();
	System.out.println("d: " + d); //d: [a, c, d]
	System.out.println("descIt.hasNext(): " + descIt.hasNext()); //descIt.hasNext(): true
	System.out.println("descIt.next(): " + descIt.next()); //descIt.next(): a
	System.out.println("descIt.hasNext(): " + descIt.hasNext()); //descIt.hasNext(): false

	System.out.println("\ntesting containsAll(Collection c)");
	System.out.println("ArrayList<Object> con = new ArrayList<Object>()");
	ArrayList<Object> con = new ArrayList<Object>();
	System.out.println("con.add(\"a\")");
	con.add("a");
	System.out.println("con: " + con); //con: [a]
	System.out.println("con.add(\"d\")");
	con.add("d");
	System.out.println("con: " + con); //con: [a, d]
	System.out.println("d: " + d); //d: [a, c, d]
	System.out.println("d.containsAll(con): " + d.containsAll(con));

	System.out.println("\ntesting retainAll(Collection c)");
	System.out.println("d.retainAll(con): " + d.retainAll(con));
	System.out.println("d: " + d); //d: [a, d]	
	
	System.out.println("\ntesting removeAll(Collection c)");
	System.out.println("d.removeAll(con): " + d.removeAll(con));
	System.out.println("d: " + d); //d: []	
	
    }//end main
    
}//end class DLLDeque
