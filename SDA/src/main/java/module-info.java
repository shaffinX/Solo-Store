module com.shaffinx.sda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    requires org.apache.commons.codec;
    opens com.shaffinx.sda to javafx.fxml;
    exports com.shaffinx.sda;
}