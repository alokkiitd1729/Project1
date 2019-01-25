

/**
 * Project completion Date 16 October 2018
 *    Author@_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    To Understand the project in enough detail please go to ReadMe file of Project1
 *     and Visit under the section under the name of this class.
 */

public class MobilePhone  {                                ////## 2nd CLASS...........
	 int id;
	String status = "switchOff";
	Exchange parent;
	 MobilePhone(int Number) {
		 id = Number;
	 }
	 public int number() {
		return id;
	 }
	 public boolean status() {
		 if(status == "switchOn") {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 public void switchOn() {
		if(status == "switchOff") {
			status = "switchOn";
		}
		else {
			status = "switchOn";
		}
	 }
     public void switchOff() {
    	 if(status == "switchOn") {
 			status = "switchOff";
 		}
    	 else {
    		 status = "switchOff";
    	 }
     }
     public Exchange location() {
    	 return parent;
     } 
 }
