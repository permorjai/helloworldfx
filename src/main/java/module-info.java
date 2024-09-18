module com.uiejemplos.holamundojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uiejemplos.holamundojavafx to javafx.fxml;
    exports com.uiejemplos.holamundojavafx;
}