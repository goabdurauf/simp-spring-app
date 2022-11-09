package com.aarouf.bootingweb.domain;

import com.aarouf.bootingweb.domain.constants.ClientState;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String lastName;

    private String login;

    @Enumerated
    private ClientState state;

    public Client(String name, String lastName, String login, ClientState state, String password, List<City> cityList) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.state = state;
        this.password = password;
        this.cityList = cityList;
    }

    public Client() {
    }

    @Column(nullable = false, length = 255)
    private String password;

    @ManyToMany
    List<City> cityList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public ClientState getState() {
        return state;
    }

    public void setState(ClientState state) {
        this.state = state;
    }
}
