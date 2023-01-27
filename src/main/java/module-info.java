module com.example.javafx1112 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafx1112 to javafx.fxml;
    exports com.example.javafx1112;
}