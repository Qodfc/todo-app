module com.lsb {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lsb to javafx.fxml;
    exports com.lsb;
}
