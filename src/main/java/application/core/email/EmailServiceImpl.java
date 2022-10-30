package application.core.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import application.core.contact.Contact;

@Service
public class EmailServiceImpl implements EmailService {

  @Autowired
  private JavaMailSender emailSender;

  @Override
  public void sendEmail(Contact contact) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("shawn.j.crahen@gmail.com");
    message.setTo("shawn.j.crahen@gmail.com");
    message.setSubject(contact.getSubject());
    message.setText("From: " + contact.getEmail() + "\nName: " + contact.getName() + "\nMessage: "
            + contact.getMessage());
    emailSender.send(message);
  }

}
