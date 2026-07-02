// Service Interface
interface CustomerRepository {
    void saveCustomer(String customerName);
}

// Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {

    public void saveCustomer(String customerName) {
        System.out.println("Customer " + customerName + " saved successfully.");
    }
}

// Service Class
class CustomerService {

    private CustomerRepository customerRepository;

    // Dependency Injection through Constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(String customerName) {
        customerRepository.saveCustomer(customerName);
    }
}

public class DependencyInjectionExample {

    public static void main(String[] args) {

        CustomerRepository repository =
                new CustomerRepositoryImpl();

        CustomerService service =
                new CustomerService(repository);

        service.addCustomer("Abirami");
    }
}