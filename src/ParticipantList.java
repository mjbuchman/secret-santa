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
    
    public void assignParticipants() {
    	for (int i = 0; i < list.size(); i++) {
    		while (list.get(i).getTarget() == -1) {
    			int index = randomGenerator.nextInt(list.size());
    			list.get(i).setTarget(index);
    			if (list.get(i).getName().equals(list.get(index).getName())) {
    				list.get(i).setTarget(-1);
    			}
    		}
    	}
    }
}
