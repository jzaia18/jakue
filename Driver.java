public class Driver{

    public static void main( String[] args ) 
    {

	
	DLLDeque<String> que = new DLLDeque<String>();
	
	System.out.println("\nsize");
	System.out.println(que.size());

	System.out.println("\nnow addFirst..."); 
	que.addFirst("1");
	que.addFirst("2");
	que.addFirst("3");
	System.out.println( que ); //for testing toString()...
	System.out.println("\npeeking first");
	System.out.println(que.peekFirst()); 
	System.out.println("\npeeking last"); 	
	System.out.println(que.peekLast()); 

	System.out.println("\nnow addLast..."); 
	que.addLast("4");
	que.addLast("5");
	que.addLast("6");
	System.out.println( que ); //for testing toString()...
	System.out.println("\npeeking first");
	System.out.println(que.peekFirst()); 
	System.out.println("\npeeking last"); 	
	System.out.println(que.peekLast()); 
	
	System.out.println("\nsize");
	System.out.println(que.size());

	System.out.println("\nnow testing toString()..."); 
	System.out.println( que ); //for testing toString()...


	System.out.println("\nnow removing first..."); 
	System.out.println( que.removeFirst() );
	System.out.println( que.removeFirst() );
	System.out.println( que.removeFirst() );
	
	System.out.println("\nnow testing toString()..."); 
	System.out.println( que ); //for testing toString()...

	System.out.println("\nnow removing last..."); 
	System.out.println( que.removeLast() );
	System.out.println( que.removeLast() );
	System.out.println( que.removeLast() );
	
	System.out.println("\nsize");
	System.out.println(que.size());

	System.out.println("\nDequeuing from empty queue should yield error..."); 
	System.out.println( que.removeFirst() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	 ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}
