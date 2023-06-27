package app.studentmanagement.controller;

import app.studentmanagement.model.Student;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.URL;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {

    @FXML
    private TableColumn<Student, String> avgScoreCol;

    @FXML
    private DatePicker birthDayPicker;

    @FXML
    private TableColumn<Student, String>  birthYearCol;

    @FXML
    private TableColumn<Student, String>  fullNameCol;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TableColumn<Student, String> funcCol;

    @FXML
    private TextField homeTownTextField;

    @FXML
    private TableColumn<Student, String> idCol;

    @FXML
    private Label messageLabel;

    @FXML
    private TableColumn<Student, String>  noCol;

    @FXML
    private TableColumn<Student, String> placeCol;

    @FXML
    private TableView<Student> tbData;


    ObservableList<Student> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        noCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        fullNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        birthYearCol.setCellValueFactory(new PropertyValueFactory<>("birthDay"));
        placeCol.setCellValueFactory(new PropertyValueFactory<>("homeTown"));


        data.add(new Student(data.size() + 1, "Cristiano Ronaldo", "01-01-1989", "Portugal", data.size() + 100));
        data.add(new Student(data.size() + 1, "Lionel Messi", "01-01-1989", "HCM", data.size() + 100));
        data.add(new Student(data.size() + 1, "Kylian Mbape", "01-01-1989", "HCM", data.size() + 100));
        data.add(new Student(data.size() + 1, "Zinadine Zidane", "01-01-1989", "HCM", data.size() + 100));
        data.add(new Student(data.size() + 1, "Ronaldo JR", "01-01-1989", "HCM", data.size() + 100));

        Callback<TableColumn<Student, String>, TableCell<Student, String>> cellFactory
                = (TableColumn<Student, String> param) -> {
            final TableCell<Student, String> cell = new TableCell<Student, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button deleteBtn = new Button("Del");

                        deleteBtn.setStyle(
                                " -fx-cursor: hand ;"
                                + "-fx-background-color:red;"
                                + "-fx-fill:white;"
                        );

                        deleteBtn.setOnMouseClicked((MouseEvent event) -> {
                            try {

                                Student student = tbData.getSelectionModel().getSelectedItem();
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setHeaderText("Are you sure delete?");
                                alert.showAndWait();
                                if(!alert.getResult().getButtonData().isCancelButton()){
                                    data.remove(student);
                                }
                            } catch (Exception exception) {
                                System.out.println(exception.getMessage());
                            }

                        });

                        HBox managebtn = new HBox(deleteBtn);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteBtn, new Insets(2, 2, 0, 3));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }
            };
            return cell;
        };
        funcCol.setCellFactory(cellFactory);
        tbData.setItems(data);
    }

    public void resetTextField(){
        fullNameTextField.setText("");
        birthDayPicker.setValue(null);
        homeTownTextField.setText("");
    }

    @FXML
    public void handleSave() throws NullPointerException{
        try {
            messageLabel.setText("");
            String fullName = fullNameTextField.getText();
            String birthDay = birthDayPicker.getValue().toString();
            String place = homeTownTextField.getText();

            if(fullName.isEmpty() || birthDay.isEmpty() || place.isEmpty()){
                messageLabel.setText("Please fill fully field!");
                messageLabel.setStyle("-fx-text-fill: red");
            }else{
                data.add(new Student(data.size()+ 1, fullName, birthDay, place, data.size() + 100));
                tbData.refresh();
                tbData.setItems(data);
                resetTextField();
                messageLabel.setText("Add student " + fullName +" successfully");
                messageLabel.setStyle("-fx-text-fill: green");
            }
        }
        catch (Exception exception){
            messageLabel.setText("Please fill fully field!");
            messageLabel.setStyle("-fx-text-fill: red");
        }

    }



}
