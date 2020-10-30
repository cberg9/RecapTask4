package com.company.demo.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private String factoryName;
    @Column
    private int factorySize;

    @OneToOne
    @JoinColumn(name = "ompaManager_id")
    private OmpaManager ompaManager;

    @ManyToMany
    @JoinTable(
            name = "candy_factory",
            joinColumns = {@JoinColumn(name = "factory_id")},
            inverseJoinColumns = {@JoinColumn(name = "candy_id")}
    )

    public List<Candy> candies;

    @JsonGetter("candies")
    public List<String> candies() {
        return candies.stream()
                .map(candy -> {
                    return  candy.getName()+" ID: " + candy.getId();
                }).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public int getFactorySize() {
        return factorySize;
    }

    public void setFactorySize(int factorySize) {
        this.factorySize = factorySize;
    }

    public OmpaManager getOmpaManager() {
        return ompaManager;
    }

    public void setOmpaManager(OmpaManager ompaManager) {
        this.ompaManager = ompaManager;
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }
}
