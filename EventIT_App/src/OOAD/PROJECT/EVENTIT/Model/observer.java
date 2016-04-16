/**
 * 
 */
package OOAD.PROJECT.EVENTIT.Model;

import javax.mail.MessagingException;

/**
 * @author NAVE
 *
 */
public interface observer {
	
	public void sendmessage(String msg, String u,String sub) throws MessagingException;

}
