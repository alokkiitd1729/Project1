/**
 * Project completion Date 16 October 2018
 *    Author@_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    To Understand the project in enough detail please go to ReadMe file of Project1
 *     and Visit under the section under the name of this class.
 */
public class Myset  {  // 1st class Myset.....	
	public class Node {
		public Object data;
		public Node next;
	}	
	 Node head;
	 Node headi = head;
	  Myset c;
	 public boolean IsEmpty() {            //  :- check whether set(linked list) is empty or not
		 if(head == null) {
			 return true;
		 }
		 return false ;
	 }
	 public  boolean IsMember(Object o) {     //  :- checks whether object o is in the set(LL) or not.
		 Node travel = head;
	while(travel != null) {
			if(travel.data == o) {
				     System.out.println("true");
                                   return true;
			                  } 
			travel = travel.next;
			}
			System.out.println("false");
		return false;
		}
	 public void Insert(Object o) {  //  :- insert a data of object type :)
		if(IsMember(o) == false) {
			 Node node = new Node();
			 node.data = o;
			 node.next = null;
			 if(head == null) {
				 head = node;
			 }
			 else {
				 node.next = head;
				 head = node;
			 }
		}
	 } 	 
	 public void Delete(Object o) {                  //  :- for deleting an object from set(LL)
		try {
			 if(IsMember(o) == true) {
				 Node travel = head;
				 Node temp1 = null;
				 Node temp2 = travel.next;
				 while(travel.data != o) {
					 temp1 = travel;
					 travel = travel.next;
					 temp2 = temp2.next;
				 }
				 temp1.next = temp2;
			 }
		}
		catch ( Exception e) {
			System.out.println("Given Object " +o+ " is not in the SET");
		}	 
      }
	 public int length() {
		 Node travel = head;
			int x = 0;
			while(travel != null) {
				x++;
			}
			return x;
	 }
	 public Myset reverse()
		{
			Myset b=new Myset();
			Node n=head;
			while(n!=null)
			{
				b.Insert(n.data);
				n=n.next;
			}
			return b;
		}
	 public Myset Union(Myset a) {
		 Node travel = head;
		 while(travel != null) {
				 a.Insert(travel.data);
			 travel = travel.next;
		 }
		 return a;
	 }
	 public  Myset Intersection(Myset a) {
		 Node travel = head;
		 while(travel != null) {
			 if(a.IsMember(travel.data) == true) {
				 c.Insert(travel.data);
			 travel = travel.next;
			 }
		 }
		 return c;
	 }
 }









