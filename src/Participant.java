public class Participant {

    private String name, email;
    private int target;

    /**
    * Constructor for instantiating a job
    * @param name: The provided name for this participant
    * @param email: The provided email for this participant
    */
    public Participant(String name, String email) {
    	this.name = name;
    	this.email = email;
    	this.target = -1;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public int getTarget() {
    	return this.target;
    }
    
    public void setTarget(int target) {
    	this.target = target;
    }
    
    public void printResults(ParticipantList people) {
    	System.out.println(this.getName() + " : " + this.getEmail() + " ---> " + people.getList().get(this.target).getName());
    }
}
