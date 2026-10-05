package students;

import Admin.StudentData;
import dbUtil.dbConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class StudentsFXMLController
  implements Initializable
{
  @FXML
  private AnchorPane StudentPane;
  

  
  @FXML
  private TableView<StudentData> studenttable;
  @FXML
  private TableColumn<StudentData, String> idcolumn;
  @FXML
  private TableColumn<StudentData, String> firstnamecolumn;
  @FXML
  private TableColumn<StudentData, String> lastnamecolumn;
  
 
  
  @FXML
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
    
    this.studenttable.setItems(null);
    this.studenttable.setItems(this.data);
  }
}