module com.akademija.sejovjezbajavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.akademija.sejovjezbajavafx to javafx.fxml;
    exports com.akademija.sejovjezbajavafx;
    exports connection;
    opens connection to javafx.fxml;
}