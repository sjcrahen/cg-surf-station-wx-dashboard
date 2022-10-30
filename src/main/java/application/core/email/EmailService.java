package application.core.email;

import application.core.contact.Contact;

public interface EmailService {

  void sendEmail(Contact contact);

}
