package org.isha.automation.basetest;

import java.io.File;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailUtils {
	 private static final Logger logger = LoggerFactory.getLogger(EmailUtils.class);

	    // Email configuration
	    private static final String FROM_EMAIL = "gayatri1998bodake@gmail.com"; // your email
	    private static final String PASSWORD = "mrev erwo deyn yfgw"; // app password
	    private static final String HOST = "smtp.gmail.com";
	    private static final String PORT = "587";
	    private static final String SUBJECT = "Extent Report - Playwright Test Results";
	    private static final String MESSAGE_BODY = "Please find the attached Extent Report for the latest Playwright Test execution.";
	    private static final String REPORT_PATH = System.getProperty("user.dir") + "//Extentsreports//index.html";

	    /**
	     * Send report to multiple recipients
	     */
	    public  void sendReportToRecipients(String[] toEmails) {
	        if (toEmails == null || toEmails.length == 0) {
	            logger.warn("Recipient email list is empty!");
	            return;
	        }

	        for (String toEmail : toEmails) {
	            try {
	                sendEmailWithAttachment(toEmail);
	            } catch (Exception e) {
	                logger.error("Failed to send email to: {}", toEmail, e);
	            }
	        }
	    }

	    /**
	     * Sends email with Extent Report as attachment
	     */
	    private  void sendEmailWithAttachment(String toEmail) throws MessagingException {
	        Properties properties = new Properties();
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.host", HOST);
	        properties.put("mail.smtp.port", PORT);

	        Session session = Session.getInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
	            }
	        });

	        MimeMessage message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(FROM_EMAIL));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
	        message.setSubject(SUBJECT);

	        // Body part
	        MimeBodyPart bodyPart = new MimeBodyPart();
	        bodyPart.setText(MESSAGE_BODY);

	        // Attachment part
	        MimeBodyPart attachmentPart = new MimeBodyPart();
	        File reportFile = new File(REPORT_PATH);
	        if (reportFile.exists()) {
	            FileDataSource source = new FileDataSource(reportFile);
	            attachmentPart.setDataHandler(new DataHandler(source));
	            attachmentPart.setFileName(reportFile.getName());
	            logger.info("Attachment added: {}", reportFile.getAbsolutePath());
	        } else {
	            logger.warn("Extent Report not found at: {}", reportFile.getAbsolutePath());
	        }

	        // Combine body + attachment
	        MimeMultipart multipart = new MimeMultipart();
	        multipart.addBodyPart(bodyPart);
	        multipart.addBodyPart(attachmentPart);
	        message.setContent(multipart);

	        Transport.send(message);
	        logger.info("Email successfully sent to: {}", toEmail);
	    }

}
