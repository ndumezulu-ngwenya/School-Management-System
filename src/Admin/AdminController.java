package Admin;

import dbUtil.dbConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController
  implements Initializable
{
  @FXML
  private TextField id;
  @FXML
  private TextField firstname;
  @FXML
  private TextField lastname;
  @FXML
  private TextField email;
  @FXML
  private DatePicker dob;
  @FXML
  private TextField age;
  @FXML
  private TextField averagegrade;
  @FXML
  private TableView<StudentData> studenttable;
  @FXML
  private TableColumn<StudentData, String> idcolumn;
  @FXML
  private TableColumn<StudentData, String> firstnamecolumn;
  @FXML
  private TableColumn<StudentData, String> lastnamecolumn;
  @FXML
  private TableColumn<StudentData, String> emailcolumn;
  @FXML
  private TableColumn<StudentData, String> dobcolumn;
  @FXML
  private TableColumn<StudentData, String> agecolumn;
  @FXML
  private TableColumn<StudentData, String> averagegradecolumn;
  
  @FXML
  private Button loadbutton;
  private ObservableList<StudentData> data;
  private dbConnection dc;
  
  public void initialize(URL url, ResourceBundle rb)
  {
    this.dc = new dbConnection();
  }
  
  @FXML
  private void loadStudentData(ActionEvent event)
  {
    try
    {
      Connection conn = dbConnection.getConnection();
      this.data = FXCollections.observableArrayList();
      
      ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
      while (rs.next()) {
        this.data.add(new StudentData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)));
      }
    }
    catch (SQLException e)
    {
      System.err.println("Error " + e);
    }
    this.idcolumn.setCellValueFactory(new PropertyValueFactory("ID"));
    this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory("firstName"));
    this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory("lastName"));
    this.emailcolumn.setCellValueFactory(new PropertyValueFactory("email"));
    this.dobcolumn.setCellValueFactory(new PropertyValueFactory("DOB"));
    this.agecolumn.setCellValueFactory(new PropertyValueFactory("Age"));
    this.averagegradecolumn.setCellValueFactory(new PropertyValueFactory("averageGrade"));
    
    this.studenttable.setItems(null);
    this.studenttable.setItems(this.data);
  }
  
  @FXML
  private void addStudent(ActionEvent event)
  {
    String sql = "INSERT INTO `students`(`id`, `fname`, `lname`, `email`, `DOB`, 'Age', 'AverageGrade') VALUES ( ?, ?, ?, ?, ?, ?, ?)";
    try
    {
      Connection conn = dbConnection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, this.id.getText());
      stmt.setString(2, this.firstname.getText());
      stmt.setString(3, this.lastname.getText());
      stmt.setString(4, this.email.getText());
      stmt.setString(5, this.dob.getEditor().getText());
      stmt.setString(6, this.age.getText());
      stmt.setString(7, this.averagegrade.getText());
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
  
  @FXML
  private void clearFields(ActionEvent event)
  {
    this.id.setText("");
    this.firstname.setText("");
    this.lastname.setText("");
    this.email.setText("");
    this.dob.setValue(null);
    this.age.setText("");
    this.averagegrade.setText("");
  }

@FXML
  private void deletestudent(ActionEvent event)
  {
    try
    {
      Connection conn = dbConnection.getConnection();
      this.data = FXCollections.observableArrayList();
      this.id.getText();
      
      
      ResultSet rs = conn.createStatement().executeQuery("DELETE * FROM students");
      
      
      while (rs.next()) {
        this.data.remove(new StudentData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)));
      }
    }
    catch (SQLException e)
    {
      System.err.println("Error " + e);
    }
    this.idcolumn.setCellValueFactory(new PropertyValueFactory("ID"));
    this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory("firstName"));
    this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory("lastName"));
    this.emailcolumn.setCellValueFactory(new PropertyValueFactory("email"));
    this.dobcolumn.setCellValueFactory(new PropertyValueFactory("DOB"));
    this.agecolumn.setCellValueFactory(new PropertyValueFactory("age"));
    this.averagegradecolumn.setCellValueFactory(new PropertyValueFactory("averageGrade"));
    
    this.studenttable.setItems(null);
    this.studenttable.setItems(this.data);
  }





}
