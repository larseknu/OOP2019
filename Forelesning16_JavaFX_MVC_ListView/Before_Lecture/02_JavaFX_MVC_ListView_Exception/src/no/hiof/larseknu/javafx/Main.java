package no.hiof.larseknu.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private static Main minApplikasjon;

    public Main() {
        minApplikasjon = this;
    }

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;

        gaaTilHovedVisning();
    }

    public void gaaTilHovedVisning() {
        try {
            FXMLLoader fxmlInnlaster = new FXMLLoader();
            fxmlInnlaster.setLocation(getClass().getResource("view/DyreDetalj.fxml"));
            Parent hovedLayout = fxmlInnlaster.load();

            Scene hovedScene = new Scene(hovedLayout, 400, 200);

            primaryStage.setScene(hovedScene);
            primaryStage.setTitle("Dyrene i Dyreparken");
            primaryStage.show();
        }
        catch (IOException ioexc) {
            System.out.println(ioexc.getMessage());
        }
    }

    public void gaaTilListeVisning() {
        try {
            FXMLLoader fxmlInnlaster = new FXMLLoader();
            fxmlInnlaster.setLocation(getClass().getResource("view/DyreListe.fxml"));
            Parent hovedLayout = fxmlInnlaster.load();

            Scene hovedScene = new Scene(hovedLayout);

            primaryStage.setScene(hovedScene);
            primaryStage.setTitle("DyreListe");
            primaryStage.show();
        }
        catch (IOException ioexc) {
            System.out.println(ioexc.getMessage());
        }
    }

    public static Main getInstance() {
        return minApplikasjon;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
