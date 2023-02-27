package finalcase.util;

import finalcase.constant.CustomerResultMessages;
import finalcase.exception.NotFoundException;
import finalcase.model.Customer;
import finalcase.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerHelper {
    private final CustomerRepository customerRepository;

    public CustomerHelper(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getByIdentityNumber(String identityNumber){
        return customerRepository.getCustomerByIdentityNumber(identityNumber)
                .orElseThrow(() -> new NotFoundException(CustomerResultMessages.NOT_FOUND));
    }

    public Customer getCustomerByIdentityNumberAndDateOfBirth(String identityNumber, LocalDate dateOfBirth){
        return customerRepository.getCustomerByIdentityNumberAndDateOfBirth(identityNumber, dateOfBirth)
                .orElseThrow(() -> new NotFoundException(CustomerResultMessages.NOT_FOUND));
    }

}
