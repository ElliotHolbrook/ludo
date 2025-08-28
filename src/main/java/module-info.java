module com.example.ludo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;


    opens com.example.ludo to javafx.fxml;
    exports com.example.ludo;
}