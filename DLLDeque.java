public class DLLDeque<T> implements Deque<T> {
    DLLNode<T> _front, _end;

    public DLLDeque() {
    }

    //add to front (queue)
    public void add( T x ) {
	addFirst(x);
    }

    //remove from back (queue)
    public T remove() {
	return removeLast();
    }
    
    public boolean isEmpty() {
	return _front == null;
    }

    //retrieves element from front (queue)
    public T peek() {
	return peekFirst();
    }

    public void addFirst(T e){
	DLLNode<T> node = new DLLNode<T>(e, null, null);
	if (_front == null) {
	    _end = node;
	} else {
	    node.setNext(_front);
	    _front.setPrev(node);
	}
	_front = node;
    }
    
    public void addLast(T e) {
	DLLNode<T> node = new DLLNode<T>(e, null, null);
	if (_end == null) {
	    _front = node;
	} else {
	    _end.setNext(node);
	    node.setPrev(_end);
	}
	_end = node;
    }

    public T peekFirst() {
	return _front.getCargo();
    }

    public T peekLast() {
	return _end.getCargo();
    }
    
    public T removeFirst() {
	T cargo = _front.getCargo();
	_front = _front.getNext();
	return cargo;
    }
    
    public T removeLast() {
	T cargo = _end.getCargo();
	_end = _end.getPrev();
	return cargo;
    }

    public static void main (String[] args){
	DLLDeque<String> d = new DLLDeque<String>();
	d.addLast("armadillo");
	d.addLast("boar");
	d.addLast("cat");
	d.addLast("dog");
	d.addLast("emu");
	
	System.out.println(d.peekFirst());
	System.out.println(d.peekLast());
	System.out.println(d.removeFirst());
	System.out.println(d.peekFirst());
	System.out.println(d.peekLast());
	System.out.println(d.removeLast());
	System.out.println(d.peekFirst());
	System.out.println(d.peekLast());
    }
}
