package com.example.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;

import javax.persistence.EntityManagerFactory;

@SpringBootConfiguration
public class ApplicationConfiguration {
    @Autowired
    private EntityManagerFactory entityManagerFactory;


}
