/*package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    Button btn;

    @FXML
    TextField from;

    @FXML
    TextField to;

    @FXML
    public void initialize()
    {
        btn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (from.getText().equals("admin")
                        && to.getText().equals("admin")){
                    System.out.println("hacked");
                }
            }
        });

    }
}
*/