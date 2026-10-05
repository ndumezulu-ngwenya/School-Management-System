package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData
{
  private final StringProperty ID;
  private final StringProperty firstName;
  private final StringProperty lastName;
  private final StringProperty email;
  private final StringProperty DOB;
  private final StringProperty Age;
  private final StringProperty Averagegrade;
  
  public StudentData(String id, String firstname, String lastname, String email, String dob, String age,String averagegrade)
  {
    this.ID = new SimpleStringProperty(id);
    this.firstName = new SimpleStringProperty(firstname);
    this.lastName = new SimpleStringProperty(lastname);
    this.email = new SimpleStringProperty(email);
    this.DOB = new SimpleStringProperty(dob);
    this.Age= new SimpleStringProperty(age);
    this.Averagegrade= new SimpleStringProperty(averagegrade);
  }
  
  public String getID()
  {
    return (String)this.ID.get();
  }
  
  public String getFirstName()
  {
    return (String)this.firstName.get();
  }
  
  public String getLastName()
  {
    return (String)this.lastName.get();
  }
  
  public String getEmail()
  {
    return (String)this.email.get();
  }
  
  public String getDOB()
  {
    return (String)this.DOB.get();
  }
  public String getAge()
  {
    return (String)this.Age.get();
  }

  public String getAverageGrade()
  {
    return (String)this.Averagegrade.get();
  }  
  
  
  public void setID(String value)
  {
    this.ID.set(value);
  }
  
  public void setFirstName(String value)
  {
    this.firstName.set(value);
  }
  
  public void setLastName(String value)
  {
    this.lastName.set(value);
  }
  
  public void setEmail(String value)
  {
    this.email.set(value);
  }
  
  public void setDOB(String value)
  {
    this.DOB.set(value);
  }
  
  public void setAge(String value)
  {
    this.Age.set(value);
  }
  
  public void setAverageGrade(String value)
  {
    this.Averagegrade.set(value);
  }
  
  public StringProperty idProperty()
  {
    return this.ID;
  }
  
  public StringProperty firstNameProperty()
  {
    return this.firstName;
  }
  
  public StringProperty lastNameProperty()
  {
    return this.lastName;
  }
  
  public StringProperty emailProperty()
  {
    return this.email;
  }
  
  public StringProperty dobProperty()
  {
    return this.DOB;
  }
public StringProperty ageProperty()
  {
    return this.Age;
  }
public StringProperty averagegradeProperty()
  {
    return this.Averagegrade;
  }


}
