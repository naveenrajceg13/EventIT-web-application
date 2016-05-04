/**
 * 
 */
package OOAD.PROJECT.EVENTIT.Model;

/**
 * @author NAVE
 *
 */
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class EmailObserver implements observer {

	/**
	 * 
	 */
	public EmailObserver() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see OOAD.PROJECT.EVENTIT.Model.observer#sendmessage(java.lang.String, OOAD.PROJECT.EVENTIT.Model.User)
	 */
	@Override
	
		// TODO Auto-generated method stub
      
	
     public void sendmessage(String msg, String u,String sub) throws MessagingException
	{
		
		String host = "smtp.gmail.com";
	    String password = "Thenewlife1.";
	    String from = "naveenrajceg13@gmail.com";
	    String toAddress = u;
	   

	    Properties properties = System.getProperties();
	    properties.put("mail.smtp.host", host);
	    properties.put("mail.smtps.auth", true);
	    properties.put("mail.smtp.starttls.enable", true);
	    Session session = Session.getInstance(properties, null);

	    MimeMessage message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(from));
	    message.setRecipients(Message.RecipientType.TO, toAddress);
	    message.setSubject(sub);

	    BodyPart messageBodyPart = new MimeBodyPart();
	    messageBodyPart.setText(msg);

	    Multipart multipart = new MimeMultipart();
	    multipart.addBodyPart(messageBodyPart);
	    message.setContent(multipart);

	    try{
	        Transport transport = session.getTransport("smtps");
	        transport.connect(host, from, password);
	        transport.sendMessage(message, message.getAllRecipients());
	        //System.out.println("Mail Sent Successfully");
	        transport.close();
	    } catch (SendFailedException sfe){
	        System.out.println(sfe);
	    }
	
	}

}
