import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
    	String message = "Your secret santa person is: " + this.getName();
    	
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
}
