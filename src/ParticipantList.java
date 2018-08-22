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
    
    public void add(Participant p) {
    	list.add(p);
    }
    
    public void assignParticipants() {
    	boolean flag = false;
    	for (int i = 0; i < list.size(); i++) {
    		if (flag == false && i == list.size()-1) {
    			for (int k = 0; k < list.size(); k++) {
    				list.get(k).setTarget(-1);
    			}
    			assignParticipants();
    			return;
    		}
    		
    		while (list.get(i).getTarget() == -1) {
    			int index = randomGenerator.nextInt(list.size());
    			list.get(i).setTarget(index);
    			if ((list.get(i).getName()).equals(list.get(index).getName())) {
    				list.get(i).setTarget(-1);
    			}
    			
        		for (int j = 0; j < list.size(); j++) {
					if (i!= j && list.get(i).getTarget() == list.get(j).getTarget()) {
						list.get(i).setTarget(-1);
					}
    			}
    		}
    		System.out.println(list.get(i).getTarget());
    		if (list.get(i).getTarget() == list.size()-1) {
    			flag = true;
    		}
    	}
    	
    	
    }
   
}
