package ch.mare.springfundamentals.profiles._01.dataaccess;

import ch.mare.springfundamentals.dependencyinjection.common.domain.Customer;
import ch.mare.springfundamentals.dependencyinjection.common.domain.MailingAddress;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class CustomerLoader {

  private static final Map<String, Customer> DATABASE = new HashMap<>() {{
    put("1", new Customer("1", "Hans Wurst", new MailingAddress("Hauptstrasse 2", "Zürich"), "hans@wurst.ch"));
    put("2", new Customer("2", "Peter Peterson", new MailingAddress("Bahnhofsweg 100", "Bern"), "peter@peterson.ch"));
  }};

  public Customer findById(String customerId) {
    return DATABASE.get(customerId);
  }

}