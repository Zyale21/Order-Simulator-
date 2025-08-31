/*
 *  Zyale Brown-Sanger 
 * 11/18/2023
 */

import java.util.*;
import java.io.*;

public class Train {
	private Car front; 
	
	
	// default constructor 
	public Train(){
		front = null;	
	}

	
	// constructor: reads each train car details from the file into the LinkedList
	public Train(String carFile){
		
		Scanner file = null;
		try{
		 file = new Scanner(new File(carFile));
		}catch(FileNotFoundException e){
			System.out.println("\nFile was not found\n");
		}
		
		
			while (file.hasNextLine()) {
				String token [] = file.nextLine().split(",");
				
				
		
			//attach(token[0],Integer.parseInt(token[1]), token[2]);
				if (token.length >= 3) {
			        attach(token[0], Integer.valueOf(token[1]), token[2]);
			    
			    }
		
			
		}
		file.close();
		
	

	}

	
	
	// remove a car given factoryName, this should delete the node in the LinkedList.
	public void detach(String factoryName) {
		if (front == null) {
	        return; // If the train is empty, nothing to detach
	    }

	    // Check if the front car needs to be detached
	    while (front != null && front.factory.equalsIgnoreCase(factoryName)) {
	        front = front.next; // Move front to the next car
	    }

	    Car current = front, prev = null;

	    while (current != null) {
	        if (current.factory.equalsIgnoreCase(factoryName)) {
	            // Detach the current car by updating the previous car's next pointer
	            prev.next = current.next;
	        } else {
	            // Move to the next car if the current car doesn't match the factory name
	            prev = current;
	        }
	        current = current.next;
	    }
	}
	
	
	


	
	//add a new car(node) to the LinkedList
	public void attach(String factoryName, int stopNumber, String materialName) {
		
		
		if(front == null){
			front = new Car(factoryName, stopNumber, materialName);
			
		}else{
			Car current = front;
			
			while(current.next != null){
				current = current.next;
			}
			current.next = new Car(factoryName, stopNumber, materialName);
			
		}
		sort();
	}

	
	
	
	/*
	 * search for cars that correspond the given factory name. 
	 * Note there may be more than one car so you may use helper method that follows
	*/
	public void search(String factName) {
		List<String> materials = getCars(factName);
		if (!materials.isEmpty()) {
            System.out.println("The car " + factName + " is carrying the following materials: ");
            System.out.print(materials.get(0));
            for (int i = 1; i < materials.size(); i++) {
                System.out.print(", " + materials.get(i));
            }
        } else
            System.out.println("That car does not exist in the train");
    }


	
	
	

	
	
	// material name lookup given factory name
	public List<String> getCars(String factoryName) {
		List<String> materials = new LinkedList<>();
		
		 Car current = front;

		    while (current != null) {
		        if (current.factory.equalsIgnoreCase(factoryName)) {
		            // If the current car's factory name matches the given factoryName,
		            // add the material to the list
		            materials.add(current.material);
		        }
		        // Move to the next car in the list
		        current = current.next;
		    }

		    return materials;
		}
	
	
	
	
	
	
	
	
	// display all the train cars in sorted order
	public void displayTrainCars() {
		sort();
		Car current = front;

		while (current != null) {
			System.out.print("\n"+current.factory +"  " +current.stop +"  " +current.material);
			current = current.next;

		}

	}

	
	
	// this method helps with displaying new cars
	public void displayNewCar(String factoryName, int stopNumber, String materialName) {
	   System.out.println("\nMerged new car: " + factoryName + " " + stopNumber + " " + materialName);
	}

	// reads from update.txt and merges it with the new train car. Merge two
	public void merge(String update) {

		Scanner file = null;
		String [] info = null; 
		try{
			file = new Scanner(new File(update));
			
		}catch (FileNotFoundException e){
			System.out.println("File was Not Found");
		}
		while(file.hasNextLine()){
			 while (file.hasNextLine()) {
			        info = file.nextLine().split(",");
			        if (info.length >= 3) {
			            attach(info[0], Integer.valueOf(info[1]), info[2]);
			            displayNewCar(info[0], Integer.valueOf(info[1]), info[2]);
			        }
			    }

			    System.out.println();
			    sort(); // Trains are sorted when they have merged
			}
	}
			
	
	
	
	
	 
	// LinkedLists and should maintain the sorted order
	public void sort(){
		Car current = front, index = null;
		int temp;
		String tempFact, tempMaterial;
		
		if(front == null){     // if front of the list is empty nothing happens 
			return;
		
		
		}else{ 
			while(current != null){
	index = current.next;
				
				while(index != null){
					
					if(current.stop > index.stop){
						temp = current.stop;
						tempFact = current.factory;
						tempMaterial = current.material;
						
						current.stop = index.stop;
						current.factory = index.factory;
						current.material = index.material;
						
						index.stop = temp;
						index.factory = tempFact;
						index.material = tempMaterial;
					
					}
					index = index.next;
				}
				current = current.next;
			}
			
			
		}
	}

}
