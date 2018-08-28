public class AssignmentTester {

	public static void main(String[] args) {
		
		/* Create Participants */
		Participant p1 = new Participant("Bob", "bob@gmail.com");
		Participant p2 = new Participant("Mike", "mike@gmail.com");
		Participant p3 = new Participant("Tim", "tim@gmail.com");
		Participant p4 = new Participant("Larry", "larry@gmail.com");
		Participant p5 = new Participant("Jason", "jason@gmail.com");
		Participant p6 = new Participant("David", "david@gmail.com");
	
		/* Add Participants to new ParticipantList */
		ParticipantList people = new ParticipantList();
		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
		people.add(p5);
		people.add(p6);
		
		/* Assign and print results */
		people.assignParticipants();
		people.printResults();
	}

}
