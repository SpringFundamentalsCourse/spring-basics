package ch.zuehlke.springfundamentals.dependencyinjection.service;

import ch.zuehlke.springfundamentals.dependencyinjection.domain.MailingAddress;
import org.springframework.stereotype.Component;

@Component
public class PostalService {

  public void sendLetter(MailingAddress mailingAddress, String message) {
    System.out.println("A letter with the message '" + message + "' will be sent to " + mailingAddress);
  }
}
