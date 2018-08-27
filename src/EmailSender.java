import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
	
	private String recepientEmail, targetName;
	
    /**
    * Constructor for instantiating an EmailSender
    * @param recepientEmail: The email of the recepient
    * @param targetName: The recepient's secret santa person
    */
    public EmailSender(String email, String name) {
    	recepientEmail = email;
    	targetName = name;
    }
    
    public String getEmail() {
    	return this.recepientEmail;
    }
    
    public String getName() {
    	return this.targetName;
    }
    
    public void sendHtmlEmail() throws AddressException, MessagingException {
    	final String userName = "secretsantajapp@gmail.com";
    	final String password = "Christmas!123";
    	String subject = "Secret Santa Results";
    	String message = createMessage();
    	
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(this.getEmail()) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        // set plain text message
        msg.setContent(message, "text/html");
 
        // sends the e-mail
        Transport.send(msg);
    }
    
    public String createMessage() {
    	return "<p style=\"background-color: #21e688; border: solid #ff4f4f 30px; height: 400px; padding-top: 340px; text-align: center; "
    			+ "font-size: 48px;color: white;\">You have <span style=\"color: #ff4f4f\"> " + this.getName() + " </span>for Secret Santa!</p><p style=\"font-size: 24px;color: black;margin-top: 50%;\">";
    	
    						

    }
}
