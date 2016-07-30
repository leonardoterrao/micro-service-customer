package br.com.leonardoterrao.rest;

import br.com.leonardoterrao.model.Customer;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Named
@Path("/")
public class CustomerRest {

    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(Customer.builder().id(1L).name("Customer 1").email("coustomer1@customer.com").build());
        customers.add(Customer.builder().id(2L).name("Customer 2").email("coustomer2@customer.com").build());
        customers.add(Customer.builder().id(3L).name("Customer 3").email("coustomer3@customer.com").build());
        customers.add(Customer.builder().id(4L).name("Customer 4").email("coustomer4@customer.com").build());
        customers.add(Customer.builder().id(5L).name("Customer 5").email("coustomer5@customer.com").build());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return customers;
    }

    @GET
    @Path("customer")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@QueryParam("id") Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

}
