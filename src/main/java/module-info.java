module com.example.ludo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.ludo to javafx.fxml;
    exports com.example.ludo;
}