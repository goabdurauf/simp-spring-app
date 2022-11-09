package com.aarouf.bootingweb.web;

import com.aarouf.bootingweb.domain.City;
import com.aarouf.bootingweb.domain.Client;
import com.aarouf.bootingweb.repository.ClientRepository;
import com.aarouf.bootingweb.web.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/user")
public class ClientController {

    private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> getClientList() {
        return clientRepository.findAll();
    }

    @GetMapping("/{clientId}/detail")
    public List<City> getClientCityList(
            @PathVariable("clientId") long clientId) {
        Client client = verifyClient(clientId);
        return client.getCityList();
    }

    @PutMapping("/{clientId}")
    public ClientDto updateClientWithPut(
            @PathVariable("clientId") long clientId,
            @RequestBody ClientDto clientDto
    ) {
        Client client = verifyClient(clientId);
        client.setLastName(clientDto.getLastName());
        client.setName(clientDto.getName());
        return new ClientDto(clientRepository.save(client));
    }

    private Client verifyClient(long clientId) throws NoSuchElementException {
        return clientRepository.findById(clientId).orElseThrow(() ->
                new NoSuchElementException("Client does not exist: " + clientId));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }


}
