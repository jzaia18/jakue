//Adeebur Rahman
//APCS2 pd1
//HW19 -- Generically Speaking...
//2017-03-16

/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode<T> {

    private T _cargo;    //cargo may only be of type String
    private DLLNode<T> _nextNode; //pointer to next LLNode
    private DLLNode<T> _prevNode; //pointer to previous LLNode

    // constructor -- initializes instance vars
    public DLLNode ( T value, DLLNode<T> prev, DLLNode<T> next ) {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }
    
    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }

    public DLLNode<T> getNext() { return _nextNode; }

    public DLLNode<T> getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) {
	T tmp = getCargo();
	_cargo = newCargo;
	return tmp;
    }
    
    public DLLNode<T> setNext( DLLNode<T> newNext ) {
	DLLNode<T> tmp = getNext();
	_nextNode = newNext;
	return tmp;
    }

    public DLLNode<T> setPrev( DLLNode<T> newPrev ) {
	DLLNode<T> tmp = getPrev();
	_prevNode = newPrev;
	return tmp;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }
    
    //main method for testing
    public static void main( String[] args ) {
    
	///*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	//Below is an exercise in creating a linked list...

	//Create a node
	DLLNode first = new DLLNode( "cat", null, null );

	//Create a new node after the first
	first.setNext( new DLLNode( "dog", first, null ) );

	//Create a third node after the second
	first.getNext().setNext( new DLLNode( "cow", first.getNext(), null ) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	///* A naive list traversal:
	   while( first != null ) {
	       System.out.println( "prev: " + first.getPrev() + " current: " + first + " next: " + first.getNext());
	       first = first.getNext();
	   }
	   //*/
	
	//Q: When head ptr moves to next node in list,
	//   what happens to the node it just left?
    }//end main

}//end class DLLNode
