module com.example.pt2024_30229_caraba_marian_assignment_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pt2024_30229_caraba_marian_assignment_1 to javafx.fxml;
    exports com.example.pt2024_30229_caraba_marian_assignment_1;
    exports PolynomialPackage;
    opens PolynomialPackage to javafx.fxml;
}