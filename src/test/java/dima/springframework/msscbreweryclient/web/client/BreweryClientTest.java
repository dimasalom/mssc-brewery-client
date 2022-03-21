package dima.springframework.msscbreweryclient.web.client;

import dima.springframework.msscbreweryclient.web.model.BeerDto;
import dima.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@SpringBootTest
public class BreweryClientTest {

    @Autowired
    BreweryClient client;

    final String URI_FOR_BEER = "/api/v1/beer/";

    final String URI_FOR_CLIENT = "/api/v1/customer/";

    @Test
    void getBeerById() {
        BeerDto beerToFind = client.getBeerById(randomUUID());

        assertNotNull(beerToFind);
    }

    @Test
    void saveBeer() {

        UUID id = randomUUID();

        BeerDto beerToSave = BeerDto.builder().id(id).build();

        URI uri = client.saveBeer(beerToSave);

        assertEquals(uri.toString(), URI_FOR_BEER + beerToSave.getId());
    }


    @Test
    void updateBeer() {
        BeerDto beerToUpdate = client.getBeerById(randomUUID());

        client.updateBeer(beerToUpdate.getId(), beerToUpdate);
    }

    @Test
    void deleteBeer() {
        BeerDto beerToDelete = client.getBeerById(randomUUID());

        client.deleteBeer(beerToDelete.getId());
    }

    @Test
    void getCustomerById() {
        CustomerDto customerToFind = client.getCustomerById(randomUUID());

        assertNotNull(customerToFind);
    }

    @Test
    void saveCustomer() {

        UUID id = randomUUID();

        CustomerDto customerToSave = CustomerDto.builder().id(id).build();

        URI uri = client.saveCustomer(customerToSave);

        assertEquals(uri.toString(), URI_FOR_CLIENT + customerToSave.getId());
    }

    @Test
    void updateCustomer() {
        CustomerDto customerToUpdate = client.getCustomerById(randomUUID());

        client.updateCustomer(customerToUpdate.getId(), customerToUpdate);
    }

    @Test
    void deleteCustomer() {
        client.deleteCUstomer(randomUUID());
    }
}
