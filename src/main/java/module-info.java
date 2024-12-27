module com.example.onlineexamwithgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.compiler;


    opens com.example.onlineexamwithgui to javafx.fxml;
    exports com.example.onlineexamwithgui;
    exports com.example.onlineexamwithgui.Controllers;
    opens com.example.onlineexamwithgui.Controllers to javafx.fxml;
}