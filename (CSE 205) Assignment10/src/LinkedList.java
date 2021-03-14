// A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

import java.util.NoSuchElementException;

public class LinkedList
{
   //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
   }

   //only instance variable that points to the first node.
   private Node first;
  
   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex = new NoSuchElementException();
         throw ex;
       }
      else
       {
         Object element = first.data;
         first = first.next;  //change the reference since it's removed.
         return element;
       }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      //change the first reference to the new node.
      first = newNode;
   }
   
   // Return the size of the list
   public int size()
   {
	   LinkedListIterator iterator = new LinkedListIterator();
	   int a = 0;
	   while(iterator.hasNext())
	   {
		   iterator.next();
		   a++;
	   }
	   return a;
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   //concatenate strings in the linked list, and return a string
   public String toString() {
	   LinkedListIterator iterator = new LinkedListIterator();
	   iterator.position = first;
	   String output = "{ ";
	   
	   if(first != null)
		   output += first.data + " ";
	   
	   while(iterator.hasNext())
	   {
		   output += String.valueOf(iterator.next()) + " ";
	   }
	   output += "}\n";
	   return output;
   }
   
   //checks if linkedList is empty
   public boolean isEmpty() {
	   
	   if(first == null)
		   return true;
	   else
	   return false;
   }
   
   //adds element at the index
   public void addElementAt(Object element, int index) {
	   try {
		   LinkedListIterator iterator = new LinkedListIterator();
		   if(index < 0 || index >= size()+1) {
			   System.out.println("The index is out of bounds");
			   return;
		   }
		   if(index == 0)
		   {
			   addFirst(element);
			
		   }
		   else {
			  
			   for(int j = 0; j < index; j++) {
				   if(j > index+1) {
					   System.out.println("The index is out of bounds");
					   return;
				   }
				   iterator.next();
			   }
			   iterator.add(element);
		   	}
		   }
	   catch(IndexOutOfBoundsException ex) {
		   System.out.println(ex);
	   }
   }
   
   //adds parameter element into the linked list at the index specified by the second parameter for the number of times specify by the third parameter
   public void addSomeElementsAt(String element, int index, int howMany) {
	   try {
		   LinkedListIterator iterator = new LinkedListIterator();
		   if(howMany <= 0)
			   return;
		   for(int i = 0; i < index; i++) {
			   iterator.next();
		   }
		   for(int j = 0; j < howMany; j++) {
		   iterator.add(element);
		   
		   }
	   }
	   catch(IndexOutOfBoundsException ex) {
		   System.out.println(ex);
	   }
   }
   
   //get element at the index
   public String getElement(int index) throws IndexOutOfBoundsException {
	   String output = null;
	   
		   LinkedListIterator iterator = new LinkedListIterator();
		   iterator.position = first;
		   if(index < 0 || index >= size()+1) {
			   throw new IndexOutOfBoundsException();
			    
		   }
		   for(int i = 0; i < index; i++) 
		   {
			   iterator.next();
		   }
		   
		   output = (String) iterator.position.data;
	   
	   
	   return output;
   }
   
   //find the largest element and remove it
   public String findLargestAndRemove() {
	   LinkedListIterator iterator = new LinkedListIterator();
	   iterator.position = first;
	   int index = 0;
	   if (isEmpty()){
	        
	        return null;
	    }
	    
	      String largest = (String) getFirst();
	   while(iterator.hasNext())     
	   {
	        if(largest.compareTo((String)iterator.next()) < 0){
	            largest=(String) iterator.position.data;
	            index++;
	        }
	        
	   }
	   if(index<0)
	   {NoSuchElementException ex = new NoSuchElementException();
	   throw ex;}

	   if(index>size()-1)
	   {NoSuchElementException ex = new NoSuchElementException();
	   throw ex;}

	   LinkedListIterator it = new LinkedListIterator();
	   while(it.hasNext())
	   {
		   if(largest.compareTo((String)it.next()) == 0) {
			   it.remove();
		   }
	   }
	   
	    return largest;
	   }
   
   public int compare (String s1, String s2) {
       return Integer.compare(s1.length(), s2.length());
   }

   
   //counts how many time the parameter object appears in the linked list and return the count
   public int countHowMany(Object element) {
	   int count = 0;
	   LinkedListIterator iterator = new LinkedListIterator();
	   while(iterator.hasNext()) {
		   if(iterator.next().equals(element))
			   count++;
	   }
	   return count;
   }
   
   //reverses the order of the last some elements specified by the parameter howMany
   public void reverseLastSome(int howMany) {
	   LinkedListIterator iterator = new LinkedListIterator();
	   
	   if(!isEmpty() && size()>1)
	   {
		   
		   int lastIndex = size()-1;
		   int startIndex = lastIndex-howMany;
		   String temp = "";
		   
		 
		   
		   
		   for(int j = 0; j < howMany; j++) {
			 
			   //iterates to the end of the list
			   for(int i = 0; i < size(); i++) 
			   {
				   iterator.next();
			   }
			   
			   temp = getElement(lastIndex);
			   iterator.remove();
			   iterator = new LinkedListIterator();
			   addElementAt(temp, startIndex);
			   
			   
			   
			   
		   }
		   
	   }                  
   }


   //nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
      {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // Adds an element after the iterator position
      // and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) //never traversed yet
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           //this also means that remove() cannot be called twice in a row.
           position = previous;
      }
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
         if (position == null)
          {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class
} //end of LinkedList class
