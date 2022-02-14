package org.nitc.NewStock;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AboutController {

    @FXML
    private JFXButton HomeB;

    @FXML
    private FontAwesomeIconView iconNe;

    @FXML
    void HomeClick(ActionEvent event) throws IOException {
    	App.setRoot("Home");
    }

}
