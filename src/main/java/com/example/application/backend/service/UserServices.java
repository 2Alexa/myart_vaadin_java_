package com.example.application.backend.service;


import com.example.application.backend.entity.Gefuehl;
import com.example.application.backend.entity.User;
import com.example.application.backend.repository.GefuehlRepository;
import com.example.application.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class UserServices {
    private static final Logger LOGGER = Logger.getLogger(UserServices.class.getName());
    private UserRepository userRepository;
    private GefuehlRepository gefuehlRepository;

    public UserServices(UserRepository userRepository, GefuehlRepository gefuehlRepository) {
        this.userRepository = userRepository;
        this.gefuehlRepository = gefuehlRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public List<User> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return userRepository.findAll();
        } else {
            return userRepository.search(stringFilter);
        }
    }

    public long count() {
        return userRepository.count();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void save(User user) {
        if (user == null) {
            LOGGER.log(Level.SEVERE,
                    "User ist null. Bist du hier richtig?");
            return;
        }
       userRepository.save(user);
    }
//weist an nach methode erstelle UserService, diese Methode anwenden
    //erstelle 3 Testfeguehle, Testuser
    @PostConstruct
    public void populateTestData() {
        if (gefuehlRepository.count() == 0) {
            gefuehlRepository.saveAll(
                    Stream.of("Freude", "Trauer", "Melancholisch")
                            .map(Gefuehl::new)
                            .collect(Collectors.toList()));
        }

        if (userRepository.count() == 0) {
            Random r = new Random(0);
            List<Gefuehl> gefuehle = gefuehlRepository.findAll();
            userRepository.saveAll(
                    Stream.of("Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
                            "Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
                            "Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
                            "Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
                            "Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
                            "Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
                            "Jaydan Jackson", "Bernard Nilsen")
                            .map(name -> {
                                String[] split = name.split(" ");
                                User user = new User();
                                user.setFirstName(split[0]);
                                user.setLastName(split[1]);
                                user.setGefuehl(gefuehle.get(r.nextInt(gefuehle.size())));
                                user.setStatus(User.Status.values()[r.nextInt(User.Status.values().length)]);
                                String email = (user.getFirstName() + "." + user.getLastName() + "@" + user.getGefuehl().getName().replaceAll("[\\s-]", "") + ".com").toLowerCase();
                                user.setEmail(email);
                                return user;
                            }).collect(Collectors.toList()));
        }

    }

}
