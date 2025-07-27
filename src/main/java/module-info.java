module com.alexandrebarbosa.lojadevideogames {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alexandrebarbosa.lojadevideogames to javafx.fxml;
    opens entidades to javafx.base;
    exports com.alexandrebarbosa.lojadevideogames;
}