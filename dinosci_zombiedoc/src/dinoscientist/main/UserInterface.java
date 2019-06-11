package dinoscientist.main;

import java.util.List;

import dinoscientist.components.Doctor;

public class UserInterface {

	      private List<String> talk;

	      public UserInterface(List<String> talk) {
	        this.talk = talk;
	      }


	      public String[] getStringArray() {
	    	String[] array = talk.toArray(new String[talk.size()]);
	        return array;
	      }
	      
	      public void addAnswer(String s) {
	    	  talk.add(s);
	      }

	      public String[] getOrder() {
	         String[] order = new String[talk.size()];
	         int i = 2;
	         order[0] = "doctor";
	         order[1] = "doctor";

	         while(order.length > i) {
	           if(i % 2 == 0) {
	             order[i] = "pacient";
	           } else {
	             order[i] = "doctor";
	           }
	           i++;
	         }
	         i = 0;
	         return order;
	      }
} 

