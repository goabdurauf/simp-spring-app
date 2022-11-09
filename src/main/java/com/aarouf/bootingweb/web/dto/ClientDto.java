package com.aarouf.bootingweb.web.dto;

import com.aarouf.bootingweb.domain.Client;

import javax.validation.constraints.NotNull;

public class ClientDto {

    private String name;
    private String lastName;
    private String login;
    private String password;

    public ClientDto(String name, String lastName, String login, String password) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public ClientDto(Client client) {
        this(client.getName(), client.getLastName(), client.getLogin(), client.getPassword());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
