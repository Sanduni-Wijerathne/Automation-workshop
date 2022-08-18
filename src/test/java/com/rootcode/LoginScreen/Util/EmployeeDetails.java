package LoginScreen.Util;

public class EmployeeDetails {

    private String firstName;
    private String lastName;
    private String middleName;
    private String username;


    public EmployeeDetails(){
        this.firstName = DataManager.getFirstName();
        this.lastName = DataManager.getLastName();
    }

    public String getFirstName(){ return firstName; }

    public String getLastName() {
        return lastName;
    }

}
