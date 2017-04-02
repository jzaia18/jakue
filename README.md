# jakue
Pronounced "Jack"  

### Team Members
* Kenny Chen
* Adeebur Rahman
* Jake Zaia

## DLLDeque
A doubly-linked node-based Deque implementation  

### Our Method Selections
* `void addFirst(E e)` reasoning: implemented in the past.
* `void addLast(E e)` reasoning: implemented in the past.
* `boolean add(E e)` reasoning: same as `addLast(E e)`, but returns true.
* `boolean offerFirst(E e)` reasoning: same as `addFirst(E e)` since our Deque has no capacity restrictions, but returns true.
* `boolean offerLast(E e)` reasoning: same as `addLast(E e)` since our Deque has no capacity restrictions, but returns true.
* `boolean offer(E e)` reasoning: same as `offerLast(E e)`.
* `void push(E e)` reasoning: same as `addFirst(E e)`.
* `E element()` reasoning: same as `getFirst()`.
* `E getFirst()` reasoning: implemented in the past.
* `E getLast()` reasoning: implemented in the past.
* `E peekFirst()` reasoning: same as `getFirst()`, except returns null if dequq is empty.
* `E peekLast()` reasoning: same as `getLast()`, except returns null if deque is empty.
* `E removeFirst()` reasoning: implemented in the past.
* `E removeLast()` reasoning: implemented in the past.
* `E remove()` reasoning: same as `removeFirst()`.
* `E pollFirst()` reasoning: same as `removeFirst()`, except returns null if deque is empty.
* `E pollLast()` reasoning: same as `removeLast()`, except returns null if deque is empty.
* `E poll()` reasoning: same as `pollFirst()`.
* `E pop()` reasoning: same as `removeFirst()`.
* `boolean isEmpty()` reasoning: implemented in the past.
* `void clear()` reasoning: clears deque (repeated removal).
* `int size()` reasoning: implemented in the past.
* `boolean removeFirstOccurence(Object o)` reasoning: similar to `E remove( int index)` in class LList.
* `boolean removeLastOccurence(Object o)` reasoning: similar to `E remove( int index)` in class LList.
* `boolean remove(Object o)` reasoning: same as `removeFirstOccurence(Object o)`.
* `boolean contains(Object o)` reasoning: similar to `remove(Object o)`, but doesn't remove, returns true if o is found.
* `Iterator<E> iterator()` reasoning: implemented in the past.
* `Iterator<E> descendingIterator()` reasoning: similar to `iterator()`, except iterates backwards.  

### Deque Architecture
Our Deque implementation is based on doubly-linked nodes.

Reasoning:
* It makes for much more efficient methods. All of the methods besides `clear()`, `contains(Object o)`, `removeFirstOccurence(Object o)`, `removeLastOccurence(Object o)`, and `remove(Object o)` are O(1). The methods mentioned are O(n). Using an array or ArrayList architecture, would force all of the "first" methods or all of the "last" methods to be O(n), depending on the ordering of elements.  
* Using DLLNodes would be much cleaner than using arrays.  
* We didn't want to use ArrayLists, because the ArrayList class already has most of the methods in Deque and we wanted to implement them ourselves.  
* We think DLLNodes are the best (because they totally are).  