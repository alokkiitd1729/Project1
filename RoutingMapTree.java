


/**
 * Project completion Date 16 October 2018
 *    Author@_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    To Understand the project in enough detail please go to ReadMe file of Project1
 *     and Visit under the section under the name of this class.
 */

public class RoutingMapTree  {
		public Exchange root;
	   public RoutingMapTree()
		{
			root=new Exchange(0);
		}
	   public RoutingMapTree(Exchange e1)
		{
			root =e1;
		}
	   public Exchange findNode(int b) {
		   if(root.id==b) {return root;}
				for(int i=0;i<root.data2.length();i++) {
					Exchange P= root.subtree(i).findNode(b); // the DANGEROUS error### :(D
					if(P!=null)
					{return P;}
					}
		   return null;
	   }
	    public MobilePhone findphone(int id)
		{
			MobilePhoneSet s=root.residentSet();   
		    	return s.mobilewithidiforgivenexchange(id); 
		}	   
	    public void addExchangedemo(int a,int b)  throws Exception
		{
			Exchange x=new Exchange(b);
				Exchange y = findNode(a);
				y.data2.Insertinchildlist(x);
				x.parent = y;
		} 
		public Exchange queryNthChilddemo(int a,int b) throws Exception{
			  Exchange node=findNode(a);
			return node.child(b);
		}	   
	   public void switchOn(MobilePhone a,Exchange b)
		{
		    		a.parent=b;
					a.switchOn();
					b.residentSet().Insert2(a);
					Exchange e1=b.parent;
					while(e1!=null)
					{
						e1.residentSet().Insert2(a);
						e1=e1.parent;
					}
		}
	   public void switchOff(MobilePhone a)   // donot delete
		{ 
		            int k = a.id;
					a.switchOff();
					Exchange e1=a.parent;
					while(e1!=null)
					{
						e1.residentSet().mobilewithidiforgivenexchange(k).switchOff();;
						e1=e1.parent;
					}
		}
		 public void switchOnMobile(int a , int b) throws Exception{
			  Exchange z = findNode(b);
				  MobilePhone m2 = new MobilePhone(a);
				  switchOn(m2,z);
	   }
	   public void switchOffMobile(int a) throws Exception{
            	  MobilePhone m1 = findphone(a);
            	  switchOff(m1);
	   }
	   public String queryMobilePhoneSet(int a) throws Exception {  
		 Exchange e1 = findNode(a);
		 MobilePhoneSet ms = e1.residentSet();
		 String out="queryMobilePhoneSet "+a+":";
		  out = out + ms.printchildren();
		  return (out.substring(0,(out.length()-1)));
	 }
	
	   public Exchange findPhone(MobilePhone m) {              
	   		    	return m.parent;
	   }
	   public Exchange lowestRouter(Exchange a , Exchange b) {
		   if(a.id == b.id) {
			   return a;
		   }
		   Exchange e1 = a.parent;
		   Exchange e2 = b.parent;
		   while(e1.id != e2.id) {
			   e1 = e1.parent;
			   e2 = e2.parent;
		   }
		   return e1;
	   }
	   public ExchangeList routeCall(MobilePhone a , MobilePhone b) {
		   Exchange e1 = a.parent;
		   Exchange e2 = b.parent;
		   Exchange pointofintersection =  lowestRouter(e1,e2);
		   ExchangeList LLofe1 = new ExchangeList();
		   ExchangeList LLofe2 = new ExchangeList();
		   while(e1.id != pointofintersection.id) {
			   LLofe1.Insertinchildlist(e1);
			   e1 = e1.parent;
		   }
		   LLofe1.Insertinchildlist(pointofintersection);
		   while(e2.id != pointofintersection.id) {
			   LLofe2.Insertatfront(e2);
			   e2 = e2.parent;
		   }
		   int k = LLofe2.length();
		   for(int i = 0;i<k;i++) {
			  Exchange e = LLofe2.ithelement(i);
			   LLofe1.Insertinchildlist(e);
		   }
		        return LLofe1;
	   }
	   public void movePhone(MobilePhone a , Exchange b) {
		     switchOff(a);
			   if(b.data2.length()==0) {
				   switchOn(a,b);
			   }
	   }
	   public String queryFindPhone(int a) throws Exception{
		   MobilePhone m1 = findphone(a);
		   Exchange e1 = findPhone(m1);
		   int k = e1.id;
		   String out = "queryFindPhone " + a+":";
		   return (out +" "+Integer.toString(k));
	   }
	   public String queryLowestRouter(int a , int b) throws Exception{
		  Exchange e1 = findNode(a);
		  Exchange e2 = findNode(b);
		  Exchange e = lowestRouter(e1,e2);
		  int k = e.id;
		  String out="queryLowestRouter "+a+" "+b+":";
		  return (out +" "+Integer.toString(k));
	   }
	   public String queryFindCallPath(int a , int b) throws Exception{
		   MobilePhone m1 = findphone(a);
		   MobilePhone m2 = findphone(b);
		   ExchangeList e = routeCall(m1,m2);
		   String out="queryFindCallPath "+a+" "+b+":";
			  out = out + e.printchildren();
			  return (out.substring(0,(out.length()-1)));
	   }
	   public void movePhone(int a , int b) throws Exception{
		   MobilePhone e1 = findphone(a);
		   Exchange e2 = findNode(b);
		   movePhone(e1,e2);
	   }
	//  ###########################################################################################################################################    
     public  String performAction(String actionMessage) {   //perform action for all actions......
    	 
    	 try {
    		  if( actionMessage.length()>=1 && actionMessage.charAt(0) == 'a') {    //addexchange
       		   String[] partial=actionMessage.split(" ");
         			int x=Integer.parseInt(partial[1]);
         			int y=Integer.parseInt(partial[2]);
      			addExchangedemo(x,y);
       	   }
       	   else if(actionMessage.charAt(6) == 'O' && actionMessage.charAt(7) == 'n') {            // switchOnMobile
       		   String[] partial=actionMessage.split(" ");
      			int x=Integer.parseInt(partial[1]);
      			int y=Integer.parseInt(partial[2]);
       		  switchOnMobile(x,y);
       	   }
       	   else if(actionMessage.length()>=1 && actionMessage.charAt(7) == 'f') {           //switchOffMobile
       		   String[] partial=actionMessage.split(" ");
         			int x=Integer.parseInt(partial[1]);
      			switchOffMobile(x);
       	   }
       	   else if(actionMessage.length()>=1 && actionMessage.charAt(5) == 'N') {       //queryNthChild
       		   String[] partial=actionMessage.split(" ");
         			int x=Integer.parseInt(partial[1]);
         			int y=Integer.parseInt(partial[2]);
      			return ("queryNthChild "+x+" "+y+":" +" "+queryNthChilddemo(x,y).id);
       	   }
       	   else if(actionMessage.length()>=1 && actionMessage.charAt(5) == 'M'){    //queryMobilePhoneSet
       		   String[] partial=actionMessage.split(" ");
         			int x=Integer.parseInt(partial[1]);
       			 return (queryMobilePhoneSet(x));
       	    }
       	   else if(actionMessage.charAt(4) == 'P' && actionMessage.charAt(0) == 'f') {              //findPhone
       		   String[] partial=actionMessage.split(" ");
        			int x=Integer.parseInt(partial[1]);
        			return (queryFindPhone(x));
       	   }
       	   else if(actionMessage.length()>=1 && actionMessage.charAt(0) == 'l') {             //lowestRouter
       		   String[] partial=actionMessage.split(" ");
        			int x=Integer.parseInt(partial[1]);
        			int y=Integer.parseInt(partial[2]);
        			return (queryLowestRouter(x,y));
       	   }
       	   else if(actionMessage.length()>=1 && actionMessage.charAt(4) == 'C') {             //findCallPath
       		   String[] partial=actionMessage.split(" ");
       			int x=Integer.parseInt(partial[1]);
       			int y=Integer.parseInt(partial[2]);
				 MobilePhone m1 = findphone(x);
		         MobilePhone m2 = findphone(y);
       			if(m1.status=="switchOn" && m2.status=="switchOn"){
					return (queryFindCallPath(x,y));
				}
				else if(findphone(x).status=="switchOff"){
                     return("queryFindCallPath "+x+" "+y+": Error - Mobile phone with identifier "+x+" is currently switched off");
        			}
        			else{
        				 return("queryFindCallPath "+x+" "+y+": Error - Mobile phone with identifier "+y+" is currently switched off");
        			}
       	   }
       	   else if(actionMessage.length()>=1 && actionMessage.charAt(4) == 'P') {              //movePhone
       		   String[] partial=actionMessage.split(" ");
      			int x=Integer.parseInt(partial[1]);
      			int y=Integer.parseInt(partial[2]);
      			     movePhone(x,y);	    
       	   }
    	 }
    	  catch(Exception e) {
                if(actionMessage.length()>=1 && actionMessage.charAt(0) == 'a'){      //addexchange
                       	String[] partial=actionMessage.split(" ");
         			    int x=Integer.parseInt(partial[1]);
                       	return ("Error - No Exchange  with identifier "+x+" found in the network");
               }
               else if(  actionMessage.charAt(6) == 'O' && actionMessage.charAt(7) == 'n'){      //switchOnMobile
                       	       String[] partial=actionMessage.split(" ");
      			              // int x=Integer.parseInt(partial[1]);
      			               int y=Integer.parseInt(partial[2]);
       	   	                 return ("Error - No Exchange  with identifier "+y+" found in the network");
       	       }
       	       else if(actionMessage.length()>=1 && actionMessage.charAt(7) == 'f'){     //switchOffMobile
       	       	         String[] partial=actionMessage.split(" ");
         			     int x=Integer.parseInt(partial[1]);
       	       	         return("Error - No mobile phone  with identifier "+x+" found in the network");
       	       }
       	       else if(actionMessage.length()>=1 && actionMessage.charAt(5) == 'N'){      //queryNthChilddemo
       	       	     String[] partial=actionMessage.split(" ");
         			int x=Integer.parseInt(partial[1]);
         			int y=Integer.parseInt(partial[2]);
       	       	    return("Error - No "+y+" child of Exchange "+x+" found in the network");
       	       }
       	       else if(actionMessage.length()>=1 && actionMessage.charAt(5) == 'M'){    //queryMobilePhoneSet
       		        String[] partial=actionMessage.split(" ");
         			int x=Integer.parseInt(partial[1]);
       			    return("Error - No Exchange  with identifier "+x+" found in the network");
       	       }
   		       else if(actionMessage.length()>=1 && actionMessage.charAt(0) == 'f') {              //findPhone
   			       String[] partial=actionMessage.split(" ");
    			   int x=Integer.parseInt(partial[1]);
      		       return("queryFindPhone "+x+": Error - No mobile phone with identifier "+x+" found in the network");
   		       }
   		       else if(actionMessage.length()>=1 && actionMessage.charAt(4) == 'C') {             //findCallPath
        		    String[] partial=actionMessage.split(" ");
        			int x=Integer.parseInt(partial[1]);
        			int y=Integer.parseInt(partial[2]);
        			if(findphone(x).status=="switchOff"){
                     return("queryFindCallPath "+x+" "+y+": Error - Mobile phone with identifier "+x+" is currently switched off");
        			}
        			else{
        				 return("queryFindCallPath "+x+" "+y+": Error - Mobile phone with identifier "+y+" is currently switched off");
        			}
        	   }
        	   else if(actionMessage.length()>=1 && actionMessage.charAt(0) == 'l'){         //queryLowestRouter
        	   	    String[] partial=actionMessage.split(" ");
       			    int x=Integer.parseInt(partial[1]);
       			    int y=Integer.parseInt(partial[2]);
        	   	    if(findphone(x)==null){
                      return("Error - No Exchange  with identifier "+x+" found in the network");
        	   	    }
        	   	    else{
        	   	    	return("Error - No Exchange  with identifier "+y+" found in the network");
        	   	    }
        	   }
        	   else if(actionMessage.length()>=1 && actionMessage.charAt(4) == 'P'){     //movePhone
        	   	    String[] partial=actionMessage.split(" ");
     			    int x=Integer.parseInt(partial[1]);
     			    int y=Integer.parseInt(partial[2]);
     			    if(findphone(x)==null){
                        return("movePhone "+x+" "+y+": Error - No mobile phone with identifier "+x+" found in the network");
     			    }
     			    else{
                         return("movePhone "+x+" "+y+": Error - No mobile phone with identifier "+y+" found in the network");
     			    }
        	   }
			   else{
				   return("What the hell u r doing?? it's illegal!!");
			   }
   	 }
    		 return "";
       }  
}
























