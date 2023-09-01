module ru.etu.studypract {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.google.gson;
    requires java.datatransfer;
    requires java.desktop;

    opens ru.etu.controllers to javafx.fxml;
    opens ru.etu.io to com.google.gson;
    opens ru.etu.graph to com.google.gson;

    exports ru.etu.algoritm;
    exports ru.etu.controllers;
    exports ru.etu.graph;
    exports ru.etu.io;
    exports ru.etu.graphview;
    exports ru.etu.graphview.base;
    exports ru.etu.graphview.drawing;
    exports ru.etu.graphview.styling;
    exports ru.etu.studypract;
}