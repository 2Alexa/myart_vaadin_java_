package com.example.application.ui.views;

import com.example.application.backend.entity.Gefuehl;
import com.example.application.backend.entity.User;
import com.example.application.backend.service.UserServices;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route("")
public class MainView extends VerticalLayout {

    private UserServices userServices;
    //neues Fensterraster definieren
    private Grid<User> grid = new Grid<>(User.class);
    //Textfeld erstellt
    private TextField filterText = new TextField();



    public MainView(UserServices userServices) {
        this.userServices = userServices;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(grid);
        updateList();
    }

    private void updateList() {
        grid.setItems(userServices.findAll());
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.removeColumnByKey("gefuehl");//entfernt Standartspaltendefi
        grid.setColumns("firstName", "lastName", "email", "status");//defi eigenschaft des users
        grid.addColumn(user -> {//zeigt den user Paramenter auf, und den gefuehl namen oder - wenn leer
            Gefuehl gefuehl = user.getGefuehl();
            return gefuehl == null ? "-" : gefuehl.getName();
        }).setHeader("Gefuehl");//defi spaltenüberschrift
        grid.getColumns().forEach(col -> col.setAutoWidth(true));// aktiviert automatische spaltenbreite

    }
}




