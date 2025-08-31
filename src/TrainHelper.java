/*
 * Zyale Brown-Sanger 
 * 11/18/2023
 */
import java.util.Scanner;




public class TrainHelper {
	
    private static Scanner scan;
    private static Train train;

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
    
    public static void trainMenu()  {
    	
    	train = new Train("car.txt");
        scan = new Scanner(System.in);      
        boolean running = true;
        
        while (running) {
        	System.out.println("\nTrain Menu Options\n");
            System.out.println("Enter A to Attach a train car");
            System.out.println("Enter R to Detach car at factory");
            System.out.println("Enter D to Display all the train car details");
            System.out.println("Enter S to Search a train car");
            System.out.println("Enter M to Merge two train cars");
            System.out.println("Enter Q to Quit");
            System.out.print("Please enter your choice: ");


            String choice = scan.nextLine().toUpperCase();

            switch (choice) {
                case "D":
                    train.displayTrainCars();
                    break;
                case "A":
                    createCar();
                    break;
                case "R":
                    detachCar();
                    break;
                case "S":
                    searchCar();
                    break;
                case "M":
                    mergeCars();
                    break;
                case "Q":
                    running = false;
                    break;
                default:
                    System.out.println("\nIncorrect Input\n");
            }
        }

        // Close scanner to prevent resource leaks
        scan.close();
        
        System.out.println("GoodBye!");
    }
    
    
    //this method uses the attach method to link at a new car to the train
    public static void createCar() {
    	String factory, material, stop;
    	 
        System.out.print("Enter Factory Name: ");
        factory = scan.nextLine();
     

        System.out.print("Enter Stop Number: ");
        stop = scan.nextLine();
       

        System.out.print("Enter Material Name: ");
        material = scan.nextLine();
  
       
       
        System.out.println("Adding a new car " +factory+" "+stop+" "+material);
        train.attach(factory, Integer.parseInt(stop), material);
     
    }
    

    
    // method that calls detach method to delete car 
    public static void detachCar() {
        System.out.print("Enter Factory Name to detach cars: ");
        String name = scan.nextLine();
        System.out.println();
        train.detach(name);
        System.out.println("the car is detached at " + name);
  
    }

    // method that called search method to search for a factory name
    public static void searchCar() {
    	
        System.out.print("\nEnter Factory Name to search: ");
        String facName = scan.nextLine();
        System.out.println();
        train.search(facName);
       
    }

    
    // method that calls the merge method from the Train class that merges the cars that are read from the update.txt file
    public static void mergeCars() {
    	System.out.println("\nDisplaying The Exisiting Cars\n");
    	train.displayTrainCars();
    	System.out.println();
    	System.out.println("\nDisplaying the New Cars\n");
    	train.merge("update.txt");
    	
        

        
    }
}



