

/**
 * Date 16 October 2018
 *    Author@_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    To Understand the project in enough detail please go to ReadMe file of Project1
 *     and Visit under the section under the name of this class.
 */

public class MobilePhoneSet  {                  //## 3rd class.......
	  class Node {
		  public MobilePhone data;
		  public Node next;
	  }
	  int size;
	  Node head;
	  Node head1 = head;
	  Myset c;
	 public boolean IsEmpty() {            // 1st method :- check whether set(linked list) is empty or not
		 if(head == null) {
			 return true;
		 }
		 return false ;
	 }
	 public  boolean IsMember(MobilePhone o) {     // 2nd method :- checks whether MobilePhone o is in the set(LL) or not.
		 Node travel = head;
	while(travel != null) {
			if(travel.data.id == o.id) {
                           return true;
			                  } 
				travel = travel.next;		
			}
		return false;
		}
		 public String printchildren() {
		 Node travel = head;
		 String s = "";
		 while(travel!=null) {
			 if(travel.data.status=="switchOn") {
				 s = s + " "+ Integer.toString(travel.data.id) + ",";
			 }
			 travel = travel.next;
		 }
		 return s;
	 }
	 public MobilePhone mobilewithidiforgivenexchange(int i) {       // return the mobilephone with identifier "id"
		 Node temp = head;
		 while(temp.data != null && temp.data.id != i) {
				if(temp.next!= null) { temp = temp.next;}
		 }
		 if(temp.data.id==i) {return temp.data;}
		 return null;
	 }
	 public boolean IsMember2(int i) {    // tells whether mobile with identifier i exists or not............
		 if(IsMember(mobilewithidiforgivenexchange(i)) == true) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }	
	  public MobilePhone ithelement( int k) {
		 Node travel = head;
		 for(int i = 0; i<k; i++) {
			 travel = travel.next;
		 }
		 return travel.data;
	 }
	 public void Insert2(MobilePhone o) {     // 3rd method :- insert a data of MobilePhone type :)
		 if(IsMember(o) == false) {
			 Node node = new Node();
			 node.data = o;
			 node.next = null;
			 Node travel1 = head;
			 if(head == null) {
				 head = node;
				 size++;
			 }
			 else {
				 while(travel1.next != null) {
					 travel1 = travel1.next;
				 }
				 travel1.next = node;
				 size++;
			 }
		}
	 } 
	 public void Delete(MobilePhone o) {                  // 4th method :- for deleting an MobilePhone from set(LL)
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
			System.out.print("");//"Given MobilePhone " +o+ " is not in the SET");
		}
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


  
 
