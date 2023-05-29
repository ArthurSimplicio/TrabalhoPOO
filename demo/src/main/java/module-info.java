module traba {
    requires javafx.controls;
    requires javafx.fxml;

    opens traba to javafx.fxml;
    exports traba;
}
