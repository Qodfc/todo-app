module com.lsb {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.lsb.controller to javafx.fxml;
    exports com.lsb;
}
