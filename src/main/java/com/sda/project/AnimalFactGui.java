package com.sda.project;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("animal")
public class AnimalFactGui extends HorizontalLayout {

    public AnimalFactClient animalFactClient;
    public DogImageClient dogImageClient;


    @Autowired
    public AnimalFactGui(AnimalFactClient animalFactClient, DogImageClient dogImageClient) {

        this.animalFactClient = animalFactClient;
        this.dogImageClient = dogImageClient;

        Grid<AnimalFact> grid = new Grid<>(AnimalFact.class);
        grid.setItems(animalFactClient.getAnimalFact());
        grid.addColumn(new ComponentRenderer<>(dog  -> {
            Image image = new Image(dogImageClient.getDogImage(), "brak");
            image.setHeight("150px");
            return image;
        })).setHeader("Image");

        grid.setHeight("1000px");
        grid.removeColumnByKey("id");
        grid.removeColumnByKey("updatedAt");
        grid.removeColumnByKey("createdAt");
        add(grid);

    }

}
