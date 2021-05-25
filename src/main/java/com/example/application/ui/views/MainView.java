package com.example.application.ui.views;

import com.example.application.backend.entity.Gefuehl;
import com.example.application.backend.entity.User;
import com.example.application.backend.service.UserServices;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private UserServices userServices;
    //neues Fensterraster definieren
    Grid<User> grid = new Grid<>(User.class);
    //Textfeld erstellt
    TextField filterText = new TextField();



    public MainView(UserServices userServices) {
        this.userServices = userServices;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureFilter();

        add(filterText,grid);
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
    private void configureFilter() {
        filterText.setPlaceholder("Filter bei Name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
    }

}




