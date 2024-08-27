package ReportMail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import Utilities.ExcelRead;



public class EmailSender {
	private static ArrayList<String> result = new ArrayList<>(Collections.nCopies(20, "Skip"));
	
	static DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
	static Date date = new Date();
	static String reportDate = df.format(date);
	
	private static ArrayList<String> dateTimeList = new ArrayList<>(Collections.nCopies(20, reportDate)); 
	
	public static void setResult(int index, String value)
	{
		result.set(index, value);
	}
	public static void setDateTime(int index, String value)
	{
		dateTimeList.set(index, value);
	}
	static{
		
	}
	
	public static void esend() {
		 
		ExcelRead excel = new ExcelRead("C:/POC_Automation/TestData.xlsx");
		
			Map<String, String> color = new HashMap<>();
		 	color.put("Pass", "green");
		 	color.put("Fail", "red");
		 	color.put("Skip", "blue");
		 	
		 	
			
			 
		 
	        // Email properties
	        String host = excel.getCellData("MailSenderData", 0, 2);
	        String port = excel.getCellData("MailSenderData", 1, 2); // or "465" for SSL
	        String username = excel.getCellData("MailSenderData", 2, 2);
	        
	        String password = excel.getCellData("MailSenderData", 3, 2);
	        String recipients[] = excel.getCellData("MailSenderData", 4, 2).split(",");
	        
	        // Create properties object
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", port);

	        // Create session
	        Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        });

	        try {
	            // Create message
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            for (String recipient : recipients) {
	                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	               // message.addRecipient(Message.RecipientType.CC, new InternetAddress(recipientCC));
	               // message.addRecipient(Message.RecipientType.BCC, new InternetAddress(recipientBCC));
	            }
	            message.setSubject("Test Report");

	            // HTML content for the email body
	            String htmlContent = "<html><body>" +
	                    "<table style=\"text-align:left;font-family:Sans-serif;" +
	                    "border-collapse:separate;border-spacing: 2px;border:solid black 1px;border-radius:6px;-moz-border-radius:6px;\">" +
	                    "<tr style=\"background-color:#A3E4D7\">" +
	                    "<th align=center bgcolor=\"#044368\"><font color=\"#F7EEEE\">Test Case</font></th>" +
	                    "<th align=center bgcolor=\"#044368\"><font color=\"#F7EEEE\">Status</font></th>" +
	                    "<th align=center bgcolor=\"#044368\"><font color=\"#F7EEEE\">Date</font></th>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#E8F8F5\">" +
	                    "<td align=left>Login to the application</td><td style=\"color:"+ color.get(result.get(0)) +";\">"+result.get(0)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(0)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#A3E4D7\">" +
	                    "<td align=left>Create PS in Basic flow</td><td style=\"color:"+ color.get(result.get(1)) +";\">"+result.get(1)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(1)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#E8F8F5\">" +
	                    "<td align=left>Create Guarantor in the Basic flow</td><td style=\"color:"+ color.get(result.get(2)) +";\">"+result.get(2)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(2)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#A3E4D7\">" +
	                    "<td align=left>Create Admission in the Basic flow</td><td style=\"color:"+ color.get(result.get(3)) +";\">"+result.get(3)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(3)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#E8F8F5\">" +
	                    "<td align=left>Add Payor/Plan in the Basic flow</td><td style=\"color:"+ color.get(result.get(4)) +";\">"+result.get(4)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(4)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#A3E4D7\">" +
	                    "<td align=left>Create Authorization in the Basic flow</td><td style=\"color:"+ color.get(result.get(5)) +";\">"+result.get(5)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(5)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#E8F8F5\">" +
	                    "<td align=left>Create DCS in DCS</td><td style=\"color:"+ color.get(result.get(6)) +";\">"+result.get(6)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(6)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#A3E4D7\">" +
	                    "<td align=left>Create Employment in DCS</td><td style=\"color:"+ color.get(result.get(7)) +";\">"+result.get(7)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(7)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#E8F8F5\">" +
	                    "<td align=left>Create Dcs Availability</td><td style=\"color:"+ color.get(result.get(8)) +";\">"+result.get(8)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(8)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#A3E4D7\">" +
	                    "<td align=left>Create Recurring Vists</td><td style=\"color:"+ color.get(result.get(9)) +";\">"+result.get(9)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(9)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#E8F8F5\">" +
	                    "<td align=left>PS Scheduling Calendar-Add Visit</td><td style=\"color:"+ color.get(result.get(10)) +";\">"+result.get(10)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(10)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#A3E4D7\">" +
	                    "<td align=left>Assign DCS from Scheduling Calendar</td><td style=\"color:"+ color.get(result.get(11)) +";\">"+result.get(11)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(11)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#E8F8F5\">" +
	                    "<td align=left>Add a visit from Schedule Management</td><td style=\"color:"+ color.get(result.get(12)) +";\">"+result.get(12)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(12)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#A3E4D7\">" +
	                    "<td align=left>Assign DCS from Schedule Management</td><td style=\"color:"+ color.get(result.get(13)) +";\">"+result.get(13)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(13)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#E8F8F5\">" +
	                    "<td align=left>Report a Visit through Link Visits</td><td style=\"color:"+ color.get(result.get(14)) +";\">"+result.get(14)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(14)+"</td>" +
	                    "</tr>" +
	                    "<tr style=\"background-color:#A3E4D7\">" +
	                    "<td align=left>Manage Unprocessed Visits in Reconciliation</td><td style=\"color:"+ color.get(result.get(15)) +";\">"+result.get(15)+"</td><td nowrap = \"nowrap\">"+dateTimeList.get(15)+"</td>" +
	                    "</tr>" +
	                   
	                    "</table></body></html>";
	            
	            
//	            "<html><body><h1>Test Report</h1>" +
//                "<table style=\"text-align:left;font-family:Sans-serif;"           //border = \"1\"; 
//		+ "border-collapse:separate;border-spacing: 1px;border:solid black 1px;border-radius:6px;-moz-border-radius:6px;\"><tr><th>Test Case</th><th>Status</th><th>Date</th></tr>" +
//                "<tr><td>Test Case 1</td><td style=\"color:green;\">Pass</td><td>2024-04-04</td></tr>" +
//                "<tr><td>Test Case 2</td><td style=\"color:red;\">Fail</td><td>2024-04-04</td></tr>" +
//                "<tr><td>Test Case 3</td><td style=\"color:blue;\">Skip</td><td>2024-04-04</td></tr>" +
//                "</table></body></html>";
	            

	            // Set the email content as HTML
	           // message.setContent(htmlContent, "text/html");
	            
	            
	           

	            // Send message
	            //Transport.send(message);
	            
	           
	           // System.out.println("Email sent successfully.");
	            BodyPart messageBodyPart1 = new MimeBodyPart(); 
	           // MimeBodyPart messageBodyPart1 = new MimeBodyPart();//Replace for above in Outlook
				messageBodyPart1.setContent("Team, <br><br>"+htmlContent+"<br>"+"<font font-family:consolas>For further assistance please contact support@aquilasoftware.com, Thank You.</font>"+"</br></br>"+
						"<font color = \"#ff0000\", size=1>Do not reply to this email. It is an auto-generated e-Mail sent through Selenium Automation script.</font>","text/html");

				//creating MultiPart object
				Multipart multipartObject = new MimeMultipart(); //For Gmail
				//MimeMultipart multipartObject = new MimeMultipart();//Replace to above for Outlook
				multipartObject.addBodyPart(messageBodyPart1);
				message.setContent(multipartObject);  // set body of the email.

				//Transport.send(message);//Send message
				
				//Added to try outlook
				Transport transport = session.getTransport("smtp");
				//transport.connect("smtp-mail.outlook.com", fromEmailUserId, fromEmailPassword);//outlook
				transport.connect(host, username, password);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
				System.out.println("Mail Send Successfully");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
}
