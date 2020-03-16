package akademia.service;

import org.springframework.mail.javamail.JavaMailSender;

public interface EmailSender {

  void sendEmail(String address, String subject, String body);
}
