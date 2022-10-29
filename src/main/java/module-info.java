module com.example.exp4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exp4 to javafx.fxml;
    exports com.example.exp4;
}