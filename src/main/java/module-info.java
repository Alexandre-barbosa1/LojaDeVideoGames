module com.alexandrebarbosa.lojadevideogames {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alexandrebarbosa.lojadevideogames to javafx.fxml;
    exports com.alexandrebarbosa.lojadevideogames;
}