package com.mycompany.coviddz;

import com.mycompany.mybeans.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    ObservableList<Countries> myCountries;

    MyLabel NewConfirmed;
    MyLabel TotalConfirmed;
    MyLabel NewDeaths;
    MyLabel TotalDeaths;
    MyLabel NewRecovered;
    MyLabel TotalRecovered;
    MyLabel lblDate;
    Scene scene;
    MyLabel selectCountry;
    MyLabel lblNewConfirmed;
    MyLabel lblTotalConfirmed;
    MyLabel lblNewDeaths;
    MyLabel lblTotalDeaths;
    MyLabel lblNewRecovered;
    MyLabel lblTotalRecovered;
    AnchorPane pane;
    AnchorPane updater;
    ComboBox<Countries> cbCountries;

    @Override
    public void start(Stage stage) {

        pane = new AnchorPane();
        updater = new AnchorPane();
        updater.setVisible(false);

        scene = new Scene(pane, 400, 600);

        pane.setStyle("-fx-background-color: teal");

        createLabels();

        cbCountries = new ComboBox();
        cbCountries.setLayoutX(185);
        cbCountries.setLayoutY(50);

        pane.getChildren().addAll(selectCountry, cbCountries);
        pane.getChildren().addAll(NewConfirmed, NewDeaths, NewRecovered, TotalConfirmed, TotalDeaths, TotalRecovered, lblDate);
        pane.getChildren().addAll(lblNewConfirmed, lblNewDeaths, lblNewRecovered, lblTotalConfirmed, lblTotalDeaths, lblTotalRecovered);

        initFill();

        cbCountries.setOnAction((t) -> {

            setInformation();
        });
        setInformation();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void setInformation() {

        Countries c = cbCountries.getSelectionModel().getSelectedItem();

        NewConfirmed.setText(String.format("%,d", c.getNewConfirmed()));
        TotalConfirmed.setText(String.format("%,d", c.getTotalConfirmed()));
        NewDeaths.setText(String.format("%,d", c.getNewDeaths()));
        TotalDeaths.setText(String.format("%,d", c.getTotalDeaths()));
        NewRecovered.setText(String.format("%,d", c.getNewRecovered()));
        TotalRecovered.setText(String.format("%,d", c.getTotalRecovered()));
        lblDate.setText(c.getDate().toString());

    }

    private void createLabels() {

        selectCountry = new MyLabel("Select country: ", 50, 50);
        lblNewConfirmed = new MyLabel("New confirmed: ", 50, 200);
        NewConfirmed = new MyLabel("", 250, 200);
        lblTotalConfirmed = new MyLabel("Total confirmed: ", 50, 250);
        TotalConfirmed = new MyLabel("", 250, 250);
        lblNewDeaths = new MyLabel("New deaths: ", 50, 300);
        NewDeaths = new MyLabel("", 250, 300);
        lblTotalDeaths = new MyLabel("Total deaths: ", 50, 350);
        TotalDeaths = new MyLabel("", 250, 350);
        lblNewRecovered = new MyLabel("New recovered: ", 50, 400);
        NewRecovered = new MyLabel("", 250, 400);
        lblTotalRecovered = new MyLabel("Total recovered: ", 50, 450);
        TotalRecovered = new MyLabel("", 250, 450);
        lblDate = new MyLabel("Date", (int) (scene.getWidth() / 2)-100, 550);
    }

    private void initFill() {
        Gson gson = new Gson();
        String json = Updater.getJSON();

        MyCovid mc = gson.fromJson(json, MyCovid.class);

        if (mc.getMessage() == null || mc.getMessage().equals("Caching in progress")) {

            System.out.println("Currently updating...");
            pane.setVisible(false);

            MyLabel updating = new MyLabel("Updating...", (int) (pane.getWidth() / 2), (int) (pane.getHeight() / 2));
            updating.setFont(Font.font(24));
            updating.setTextFill(Color.WHITE);

            updater.getChildren().add(updating);

        } else {

            myCountries = FXCollections.observableArrayList();
            Countries global = Countries.getCountryFromGlobal(mc);

            myCountries.addAll(mc.getCountries());
            cbCountries.setItems(myCountries);
            cbCountries.getSelectionModel().select(global);

        }
    }

}
