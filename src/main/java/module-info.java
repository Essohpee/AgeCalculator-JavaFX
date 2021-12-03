module com.essohpee.agecalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires com.jfoenix;

    opens com.essohpee.agecalculator to javafx.fxml;
    exports com.essohpee.agecalculator;
}