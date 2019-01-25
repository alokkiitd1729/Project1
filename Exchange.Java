/**
 * Date 16 October 2018
 *    Author@_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    To Understand the project in enough detail please go to ReadMe file of Project1
 *     and Visit under the section under the name of this class.
 */
public class Exchange  {
      
    	   Exchange parent = null;
    	   ExchangeList data2;
    	   MobilePhoneSet data3;
	       int id;
		  Exchange (int number) {     //constructor
			  id = number;
			  data2 = new ExchangeList();
			  data3 = new MobilePhoneSet();
		  }  
		public Exchange parent() {
			return parent ;
		}
		public int numChildren() {
		  return data2.length();
		}
		public Exchange child(int i) {
			return (data2.ithelement(i));
		}
		public boolean isRoot() {
			if(id ==0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public RoutingMapTree subtree(int i) {
			Exchange ex = child(i);
			RoutingMapTree stree = new RoutingMapTree(ex);
			return stree;
		}
		public MobilePhoneSet residentSet() {
			return (data3);
		}
		
	
}













