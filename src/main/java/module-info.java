module sun.ac.za.ohviz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens sun.ac.za.ohviz to javafx.fxml;
    exports sun.ac.za.ohviz;
}