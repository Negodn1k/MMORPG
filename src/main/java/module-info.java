module com.game.game {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.game.game to javafx.fxml;
    exports com.game.game;
}