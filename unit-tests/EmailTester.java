public class EmailTester {
	public static void main(String[] args) {
		EmailSender test = new EmailSender("mbookie213@gmail.com", "Billy");
		try {
            test.sendHtmlEmail();
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
	}

}