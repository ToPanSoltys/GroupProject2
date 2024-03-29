package com.sda.project;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

//domyslny route to nazwa klasy malymi literami
@Route("hello")
public class HelloAppGui extends HorizontalLayout {

    public HelloAppGui() {
        TextField textField = new TextField("Podaj imie:");
        Button buttonHello = new Button("Przywitaj", new Icon(VaadinIcon.HANDSHAKE));
        Label label = new Label();

        buttonHello.addClickListener(clickEvent -> {
            label.setText("Hello " + textField.getValue());

            //link / alternatywny tekst, kiedy link sie nie wyswietli
            Image image = new Image("https://media.tenor.com/images/a03e50aa358b7cab991f58b43e1a942a/tenor.gif", "hello");
            add(image);
        });



        add(textField, buttonHello, label);
    }

}