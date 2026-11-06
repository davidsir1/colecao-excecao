module com.davidsir1.cadastropaciente {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.davidsir1.cadastropaciente to javafx.fxml;
    exports com.davidsir1.cadastropaciente;
    opens com.davidsir1.cadastropaciente.controller to javafx.fxml;
    exports com.davidsir1.cadastropaciente.controller;
}