package org.nitc.NewStock;

import java.awt.Button;
import java.io.IOException;

import org.nitc.Controller.UpdateDataBase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;


public class SecondaryController {

    @FXML
    private ToggleButton NotUpdate;

    @FXML
    private ToggleButton Update;

    @FXML
    void NotUpdateClick(ActionEvent event) throws Exception {
    	UpdateDataBase.CapNhapDuLieu();
    	App.setRoot("Home");
    }

    @FXML
    void UpdateClick(ActionEvent event) throws Exception {
    	
    	App.setRoot("Home");
    }

}