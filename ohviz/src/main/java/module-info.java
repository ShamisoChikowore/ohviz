module cs.sun.za.ohviz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens cs.sun.za.ohviz to javafx.fxml;
    exports cs.sun.za.ohviz;
}