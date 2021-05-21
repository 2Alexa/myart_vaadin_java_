package com.example.application.backend.repository;

import com.example.application.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>   {
    //wenden JPQL Sprache für Abfrage , ob Vorname und Nachname, Zeichenfolge übereinstimmen
    @Query("select c from User c " +
            "where lower(c.firstName) like lower(user('%', :searchTerm, '%')) " +
            "or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<User> search(@Param("searchTerm") String searchTerm);

}
