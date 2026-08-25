package com.example.tracker.builder;

import com.example.tracker.entity.Stations;
import com.example.tracker.entity.Users;

public class UsersBuilder {
    private String name;
    private String password;
    private String division;
    private Stations stations;

    public UsersBuilder setName(String name){
        this.name = name;
        return this;
    }

    public UsersBuilder setPassword(String password){
        this.password = password;
        return this;
    }
    public UsersBuilder setDivision(String division){
        this.division = division;
        return this;
    }
    public UsersBuilder setStationsId(Stations stations){
        this.stations = stations;
        return this;
    }

    public Users build(){
        Users users = new Users();
        users.setName(name);
        users.setPassword(password);
        users.setDivision(division);
        users.setStationId(stations);
        return users;
    }

}
