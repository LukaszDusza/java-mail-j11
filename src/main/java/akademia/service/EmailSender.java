package akademia.service;

public interface EmailSender {

  void sendEmail(String address, String subject, String body);
}
