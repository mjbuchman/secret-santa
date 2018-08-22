public class AssignmentTester {

	public static void main(String[] args) {
		Participant p1 = new Participant("Bob", "bob@gmail.com");
		Participant p2 = new Participant("Mike", "mike@gmail.com");
		Participant p3 = new Participant("Tim", "tim@gmail.com");
		Participant p4 = new Participant("Larry", "larry@gmail.com");
		Participant p5 = new Participant("Jason", "jason@gmail.com");
		Participant p6 = new Participant("David", "david@gmail.com");
	
		ParticipantList people = new ParticipantList();
		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
		people.add(p5);
		people.add(p6);
		
		people.assignParticipants();
		people.printResults();
	}

}
