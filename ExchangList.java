
/**
 * Date 16 October 2018
 *    Author@_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 */

public class ExchangeList {
	       class Node1 {
		  public Exchange data;
		  public Node1 next;
	  }
	  int size;
	 Node1 head;
	 Node1 head1 = head;
	public Node1 head2;
	 public boolean IsEmpty1() {                 //1st
		 if(head == null) {
			 return true;
		 }
		 return false ;
	 }
	  public  boolean IsMember1(Exchange o) {     //2nd method :- checks whether object o is in the set(LL) or not.
		 Node1 travel = head;
		 
	while(travel != null) {
			if(travel.data.id == o.id) {
                                   return true;
			                  } 
			travel = travel.next;
			}
		return false;
		}
	 public void Insertinchildlist(Exchange o) {  // 3rd method :- insert a data of object type :)
			if(IsMember1(o) == false) {
				 Node1 node = new Node1();
				 node.data = o;
				 node.next = null;
				 Node1 travel1 = head;
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
	 public void Insertatfront(Exchange o) {  // 3rd method :- insert a data of object type :)
			if(IsMember1(o) == false) {
				 Node1 node = new Node1();
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
	 public String printchildren() {
		 Node1 travel = head;
		 String s = "";
		 while(travel!=null) {
			 s = s + " "+ Integer.toString(travel.data.id) + ",";
			 travel = travel.next;
		 }
		 return s;
	 }
	 public ExchangeList combine(ExchangeList e1 , ExchangeList e2) {
		 int k = e1.length();
		 for(int i = 1;i<k;i++) {
			   e1.head1 = e1.head1.next;
		   }
		   e1.head1.next = e2.head;
		        return e1;
	 }
	 public void Delete1(Exchange o) {                  // 4th method :- for deleting an object from set(LL)
			try {
				 if(IsMember1(o) == true) {
					 Node1 travel = head;
					 Node1 temp1 = null;
					 Node1 temp2 = travel.next;
					 while(travel.data != o) {
						 temp1 = travel;
						 travel = travel.next;
						 temp2 = temp2.next;
					 }
					 temp1.next = temp2;
				 }
			}
			catch ( Exception e) {
				System.out.println("Given Object is not in the SET");
			}
	      }
	 public Exchange ithelement( int k) {
		 Node1 travel = head;
		 for(int i = 0; i<k; i++) {
			 travel = travel.next;
		 }
		 return travel.data;
	 }
	 public int length() {
		 
		 Node1 travel = head;
	
			int x = 0;
			while(travel!= null) {
				x++;
				travel=travel.next;	 
			}
			return x;
	 }
}















