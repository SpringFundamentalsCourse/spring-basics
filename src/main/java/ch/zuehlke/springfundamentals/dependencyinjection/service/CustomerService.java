package ch.zuehlke.springfundamentals.dependencyinjection.service;

import ch.zuehlke.springfundamentals.dependencyinjection.dataaccess.CustomerLoader;
import ch.zuehlke.springfundamentals.dependencyinjection.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

  private static final String DEACTIVATION_MESSAGE = "Your customer account has been successfully removed";
  private EmailService emailService;
  private final PostalService postalService;
  private final CustomerLoader customerLoader;

  @Autowired
  public CustomerService(EmailService emailService, PostalService postalService, CustomerLoader customerLoader) {
    this.emailService = emailService;
    this.postalService = postalService;
    this.customerLoader = customerLoader;
  }

  public void deactivateCustomer(String customerId) {

    Customer customer = customerLoader.findById(customerId);

    if (customer.hasEmailAddress()) {
      String emailAddress = customer.getEmailAddress();
      emailService.send(emailAddress, "Customer Account", DEACTIVATION_MESSAGE);
    }

    postalService.sendLetter(customer.getMailingAddress(), DEACTIVATION_MESSAGE);
  }
}