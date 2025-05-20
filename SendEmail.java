package emails;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
/**
 * How to operate the email sender
 * 
 * Hey whoever is reading! Glad to see you trying out the email sender! If you're
 * seeing this and going insane, don't worry! It's not as bad as it looks :)
 * I took some email sender source code from a YT video (and now I can't find it)
 * and modified it so I could put everyone's personal name on the emails. 
 * 
 * You shouldn't have any issue sending the email because of this code unless Google turns
 * off less secure app access for G Suite accounts. If something's wrong, I found that it was some 
 * syntax error or that I needed to turn on less secure app access and turn 2FA off. A quick troubleshoot will fix
 * the problem.
 * 
 * 
 * Here's how you create your email and send it - 
 * 
 * First, you should write your email message! I recommend writing it in the gmail editor. After that,
 * go to wordtohtml.net and paste it into the left box. The HTML UTF-8 will be created for you. Paste the right box 
 * into the file email.html - check it in your browser to make sure the formatting is all good. Don't forget to change
 * the file path in Sender.java line 11! For all places where you are using the recipient's name, put 
 * 'uniqueStringName' in your email. For instance, if I was looking to get "Dear Person1, Investnment Club is..." and 
 * "Dear Person2, Investnment Club is..." in the email message, it would be written as "Dear uniqueStringName, Investnment Club is..."
 * in the email.html file. I was originally using just 'name' instead of 'uniqueStringName', but then I ran into a
 * problem where it would change all uses of the characters, and not just the names. Set the subject in line 44 of Sender.java.
 * 
 * Then, choose which list you want to send your email to in line 42 in Sender.java's for loop. There's a list for the general
 * club members, one for the officers, and a couple archived lists which I just commented out for now. You can create your own lists
 * with the HashMap class. If you want to send to officers (line 24), change to officers2324.keySet(). If you want to send 
 * to the club members, change line 42 to members.keySet(). For all other lists, it's the same practice (<listname>.keySet())
 * I highly recommend sending to the test list (line 31 and 32) before sending the email out. 
 * 
 * Before sending the message, add the jar files (also in this github page) into your environment as a referenced library. On Eclipse,
 * right-click on the Project → Build Path → Configure Build Path. Under Libraries tab, click Add Jars or Add External JARs and give the Jar.
 * There is probably a similar solution in IntelliJ as well. Then, add all the jar files in the repository.
 * 
 * Before you send your email, go to your google account (school acct) and turn on less secure app access. My 
 * practice was always to turn it on, send the email, and then immediately turn it off again
 * because of account security. After turning less secure apps on, it's as simple as hitting run!
 * 
 * 
 * @author archith
 *
 */
public class SendEmail {
	final String senderEmail = ""; //change email address
	final String senderPassword = ""; //put your google acct password here
	final String emailSMTPserver = "smtp.gmail.com";
	final String emailServerPort = "465";
	String receiverEmail = null;
	static String emailSubject;
	static String emailBody;
	Authenticator auth;
	Session session;
	MimeMessage msg;
	Properties props;
	SecurityManager security;
	public SendEmail(String receiverEmail, String subject, String body) {
		//receiver email
		this.receiverEmail = receiverEmail;
		//subject
		this.emailSubject = subject;
		//body
		this.emailBody = body;
			
	}
	public SendEmail() {
		props = new Properties();
		props.put("mail.smtp.user",senderEmail);
		props.put("mail.smtp.host", emailSMTPserver);
		props.put("mail.smtp.port", emailServerPort);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", emailServerPort);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		security = System.getSecurityManager();
		auth = new SMTPAuthenticator();
				session = Session.getInstance(props, auth);		
	}
	
	public void setbody(String newbod) {
		emailBody = newbod;
	}
	public void setsubject(String newsub) {
		emailSubject = newsub;
	}
	public void setreceiver(String newrec) {
		receiverEmail = newrec;
	}
	public void sendit() {
		try {
			msg = new MimeMessage(session);
			msg.setContent(emailBody, "text/html; charset=utf-8");
			msg.setSubject(emailSubject);
			msg.setFrom(new InternetAddress(senderEmail));
			//System.out.println(emailBody);
			msg.setFrom(new InternetAddress(senderEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
			Transport.send(msg);
			System.out.println("Message to " + receiverEmail +  " sent successfully");
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(senderEmail, senderPassword);
		}
	}				
}
