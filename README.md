# jakue
Pronounced "Jack"  

### Team Members
* Kenny Chen
* Adeebur Rahman
* Jake Zaia

## DLLDeque
A doubly-linked node-based Deque implementation  

### Our Method Selections

##### Add Methods
```
public void addFirst(E e);
public boolean offerFirst(E e);
public void push(E e);
public boolean add(E e);
public void addLast(E e);
public boolean offer(E e);
public boolean offerLast(E e);
```
Reasoning: Very similar to our past implementations of add/push.

##### Accessor Methods
```
public E element();
public E getFirst();
public E peek();
public E peekFirst();
public E getLast();
public E peekLast();
```
Reasoning: Very similar to our past implementations of get/peek.

##### Remove Methods
```
public E remove();
public E removeFirst();
public E pop();
public E poll();
public E pollFirst();
public E removeLast();
public E pollLast();
```
Reasoning: Very similar to our past implementations of remove/pop.

##### Specific Remove Methods
```
public boolean remove(Object o); 
public boolean removeFirstOccurrence(Object o);
public boolean removeLastOccurrence(Object o);
```
Reasoning: Very similar to removing from the middle of a DLList.

##### Iterators
```
public Iterator<E> iterator();
public Iterator<E> descendingIterator();
```
Reasoning: We created an iterator for DLList before, and descendingIterator is just an iterator going backwards.

##### Miscellaneous Methods
```
public void clear();
public boolean contains(Object o);
public boolean containsAll(Collection<?> c);
public boolean removeAll(Collection<?> c);
public boolean retainAll(Collection<?> c);
```
Reasoning: clear() is just repeated removal.  
contains(o) is just a simple .equals() check.  
containsAll(c) is repeated usage of contains.  
removeAll(c) can be done easily with an iterator.  
retainAll(c) can be done easily with an iterator.  

##### Helper Methods
```
public boolean isEmpty(); 
public int size();
```
Reasoning: these are very essential helper methods.

### Deque Architecture
Our Deque implementation is based on doubly-linked nodes.

Reasoning:
* It makes for much more efficient methods by allowing the simple accessor, add, and remove methods have a runtime of O(1). Using an array or ArrayList architecture, would force all of the "first" methods or all of the "last" methods to be O(n), depending on the ordering of elements.  
* Using DLLNodes would be much cleaner than using arrays.  
* We didn't want to use ArrayLists, because the ArrayList class already has most of the methods in Deque and we wanted to implement them ourselves.  
* We think DLLNodes are the best (because they totally are).  