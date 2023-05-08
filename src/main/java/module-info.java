module com.mycompany.coviddz {
    requires javafx.controls;
    requires com.google.gson;
    
    opens com.mycompany.coviddz to com.google.gson;
    opens com.mycompany.mybeans to com.google.gson;
    
    exports com.mycompany.coviddz;
}
