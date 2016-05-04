//package chat;//package chat;
//import chat.interfaces.AutoMailImpl;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import java.util.Properties;
//public class AutoEmail implements AutoMailImpl{
//	private MimeMessage mimeMsg;
//	private Session session;
//	private Properties props;
//	private String username;
//	private String password;
//	private Multipart mp;
//
//	public AutoEmail() {
//
//		System.out.println("Setting the mail.smtp.host=smtp.gmail.com");
//
//		/*
//		 * set the smtp mail host
//		 */
//		if (props == null) {
//			props = System.getProperties();
//		}
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", 587);
//		/*
//		 * set the mail session
//		 */
//		try {
//			System.out.println("Setting the mail session!");
//			session = Session.getDefaultInstance(props, null);
//		} catch (Exception e) {
//			System.out.println("fail to get mail session!" + e);
//		}
//
//		/*
//		 * set the MIME session
//		 */
//		System.out.println("Now creating MIME mail message");
//		try {
//			mimeMsg = new MimeMessage(session);
//			mp = new MimeMultipart();
//
//		} catch (Exception e) {
//			System.out.println("fail to create MIME mail message" + e);
//		}
//		/*
//		 * Enable the authentication
//		 */
//		props.put("mail.smtp.starttls.enable","true");
//		props.put("mail.smtp.auth", "true");
//
//		/*
//		 * set password and user name for auto-email
//		 */
//		username = "athensautoresponse";
//		password = "pizzapie";
//
//		/*
//		 * set the subject of mail
//		 */
//		System.out.println("Setting the subject of mail!");
//		try {
//			mimeMsg.setSubject("Athens Chatroom PW recovery");
//		} catch (Exception e) {
//			System.err.println("fail to set the subject of email");
//		}
//
//		/*
//		 * set the mail sender
//		 */
//		System.out.println("setting the mail sender!");
//		try {
//			mimeMsg.setFrom(new InternetAddress("athensautoresponse@gmail.com")); //sender address
//		} catch (Exception e) {
//			System.err.println("fail to set the sender of email");
//		}
//
//
//	}
//
//	/**
//	 * set the email body
//	 * @param mailBody
//	 * @return
//	 */
//	public boolean setBody(String mailBody) {
//		try {
//			BodyPart bp = new MimeBodyPart();
//			bp.setContent("" + mailBody, "text/html;charset=GBK");
//			mp.addBodyPart(bp);
//			return true;
//		} catch (Exception e) {
//			System.err.println("fail to set the body of email" + e);
//			return false;
//		}
//	}
//
//
//	/**
//	 * define the receiver email address
//	 * @param to
//	 * @return
//	 */
//	public boolean setTo(String to) {
//		if (to == null)
//			return false;
//		System.out.println("set the receiver address!");
//		try {
//			mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
//
//	/**
//	 * define who will be sent a copy of this mail
//	 * @param copyto
//	 * @return
//	 */
//	public boolean setCopyTo(String copyto) {
//		if (copyto == null)
//			return false;
//		try {
//			mimeMsg.setRecipients(Message.RecipientType.CC, (Address[]) InternetAddress
//					.parse(copyto));
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
//
//	/**
//	 * mail will be sent here
//	 * @return
//	 */
//	public boolean sendOut() {
//		try {
//			mimeMsg.setContent(mp);
//			mimeMsg.saveChanges();
//			System.out.println("the mail is now sending....");
//
//
//
//			Session mailSession = Session.getInstance(props, null);
//			Transport transport = mailSession.getTransport("smtp");
//			transport.connect("smtp.gmail.com", username, password);
//			transport.sendMessage(mimeMsg, mimeMsg
//			.getRecipients(Message.RecipientType.TO));
//			System.out.println("mail sent successfully");
//			transport.close();
//			return true;
//		} catch (Exception e) {
//			System.err.println("fail to send the mail!" + e);
//			return false;
//		}
//	}
//
//	/**
//	 * generate a mail with the 3 parameters
//	 * @param to
//	 * @param copyto
//	 * @param content
//	 * @return
//	 */
//	public static boolean sendMail(String to, String copyto, String content) {
//		AutoEmail auto = new AutoEmail();
//
//		if (!auto.setBody(content))
//			return false;
//		if (!auto.setTo(to))
//			return false;
//		if (!auto.setCopyTo(copyto))
//			return false;
//		if (!auto.sendOut())
//			return false;
//		return true;
//	}
//
//
//
//
//	public static String sendRandomString(String email) {
//		ChatroomSecurity random=new ChatroomSecurity();
//
//		String PWRC=random.randomString(20);
//
//		String receiver = email;// the receiver email
//		String copyto = "";// copy email address
//
//		String content =
//				"<p>Dear Athens Chatroom user:</p>"+
//				"<p>&nbsp;</p>"+
//				"<p>Now your are trying to reover your password. Please enter the following recovery message in the Chatroom App.</p>"+
//				"<p>&nbsp;</p>"+
//                "<p>Your recovery message is :</p>"+
//                "<p>&nbsp;</p>"+
//                "<p></p><h1>"+PWRC+"</h1><p></p>"+
//                "<p>&nbsp;</p>"+
//                "<p>Note that : This recovery message is only valid for 10 mins.</p>"+
//                "<p>&nbsp;</p>"+
//                "<p>This email is generated automatically, please <strong>DO NOT REPLY</strong> to this email address.</p>"+
//                "<p>&nbsp;</p>"+
//                "<p>Athens Team</p>";
//
//		AutoEmail.sendMail(receiver, copyto, content);
//
//		return PWRC;
//	}
//
//	public static void main(String args[]){
//		System.out.println(sendRandomString("wxh575@student.bham.ac.uk"));
//
//	}
//}