package dima.springframework.msscbreweryclient.web.client;


import dima.springframework.msscbreweryclient.web.model.BeerDto;
import dima.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "dima.brewery", ignoreInvalidFields = true)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    private String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID id) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + id, BeerDto.class);
    }

    public URI saveBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID id, BeerDto beerDto) {
        restTemplate.put(apiHost + BEER_PATH_V1 + id, beerDto);
    }

    public void deleteBeer(UUID id) {
        restTemplate.delete(apiHost + BEER_PATH_V1 + id);
    }

    public CustomerDto getCustomerById(UUID id) {
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + id, CustomerDto.class);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public URI saveCustomer(CustomerDto customerToSave) {
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerToSave);
    }

    public void updateCustomer(UUID id, CustomerDto customerToUpdate) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + id, customerToUpdate);
    }

    public void deleteCUstomer(UUID id) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + id);
    }
}
