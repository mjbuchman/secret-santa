import java.util.*;

public class ParticipantList {

    private ArrayList<Participant> list;
    private Random randomGenerator;

    /**
    * Constructor for instantiating a job
    * @param list:
    */
    public ParticipantList() {
    	list = new ArrayList<>();
        randomGenerator = new Random();
    }
    
    public ArrayList<Participant> getList(){
    	return list;
    }
    
    public int size() {
    	return this.list.size();
    }
    
    public Participant get(int index) {
    	return list.get(index);
    }
    public void add(Participant p) {
    	list.add(p);
    }
    
    public void assignParticipants() {
    	boolean flag = false;  //Indicates whether or not the last participant has been assigned yet
    	
    	/* Set each participants target one at a time */
    	for (int i = 0; i < list.size(); i++) {
    		if (flag == false && i == list.size()-1) {  // If on last participant and that person has yet to be assigned
    			for (int k = 0; k < list.size(); k++) {
    				list.get(k).setTarget(-1);  // Reset all participants targets
    			}
    			assignParticipants();  // Reassign targets
    			return; 
    		}
    		
    		/* Loop through while participant does not have a valid target */
    		while (list.get(i).getTarget() == -1) {
    			int index = randomGenerator.nextInt(list.size());
    			list.get(i).setTarget(index);
    			
    			/* Check if participant was assigned themselves */
    			if ((list.get(i).getName()).equals(list.get(index).getName())) {
    				list.get(i).setTarget(-1);
    			}
    			
    			/* Iterate through all participants and check for duplicate assignments */
        		for (int j = 0; j < list.size(); j++) {
					if (i!= j && list.get(i).getTarget() == list.get(j).getTarget()) {
						list.get(i).setTarget(-1);
					}
    			}
    		}
    		
    		/* Sets true if last participant has been assigned */
    		if (list.get(i).getTarget() == list.size()-1) {
    			flag = true;
    		}
    	}	
    }
    
    public void printResults() {
    	for (int i = 0; i < list.size(); i++) {
        	System.out.println(list.get(i).getName() + " : " + list.get(i).getEmail() + " ---> " + list.get(list.get(i).getTarget()).getName());
		}
    }
   
}
