public class Participant {

    private String name, email;  // Strings containing identifying information
    private int target;  // Index of participants assigned target

    /**
    * Constructor for instantiating a participant
    * @param name: The provided name for this participant
    * @param email: The provided email for this participant
    */
    public Participant(String name, String email) {
    	this.name = name;
    	this.email = email;
    	this.target = -1;
    }
    
    /**
    * Get method for name field
    * 
    * @return this object's name
    */
    public String getName() {
    	return this.name;
    }
    
    /**
    * Get method for email field
    * 
    * @return this object's email
    */
    public String getEmail() {
    	return this.email;
    }
    
    /**
    * Get method for target field
    * 
    * @return this object's target
    */
    public int getTarget() {
    	return this.target;
    }
    
    /**
    * Set method for name field
    * 
    * @param target: integer to set this object's target to
    */
    public void setTarget(int target) {
    	this.target = target;
    }
    
    /**
    * Print method for all fields of a Participant object
    */
    public void print() {
    	System.out.println(this.getName() + " : " + this.getEmail() + " : " + this.getTarget());
    }
}
