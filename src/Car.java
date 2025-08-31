/*
 * Zyale Brown-Sanger 
 * 11/16/2023 
 */
public class Car {
	  public String factory;
      public int stop;
      public String material;
      Car next;
   public Car(){
	   this("",0,"",null);
        // default constructor
   }
  
   public Car(String fact, int s, String m){
        // regular constructor sets next to null
	   this(fact,s,m,null);
    }

  
   public Car(String fact, int s, String m, Car next){
      // regular constructor sets   this.next=next;
	   factory = fact;
	   stop = s;
	   material = m;
	   this.next = next;
    }
   
}



