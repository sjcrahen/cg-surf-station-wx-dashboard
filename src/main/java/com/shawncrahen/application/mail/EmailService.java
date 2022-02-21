package com.shawncrahen.application.mail;

import com.shawncrahen.application.contact.Contact;

public interface EmailService {

  void sendEmail(Contact contact);

}
