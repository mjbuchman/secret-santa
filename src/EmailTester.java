public class EmailTester {
	public static void main(String[] args) {
		EmailSender test = new EmailSender("mbookie213@gmail.com", "Billy");  // Create EmailSender object with test information

		/* Attempt to send and provide feedback */
		try {
			test.sendHtmlEmail();
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Failed to send email.");
		}
	}
}
