module com.example.mod7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mod7 to javafx.fxml;
    exports com.example.mod7;
}