package LoginScreen.Util;

import com.github.javafaker.Faker;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;

public class UtilTester {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String firstname = DataManager.getFirstName();
        String lastname = DataManager.getLastName();


        EmployeeDetails employeeDetails = DataManager.getEmployeeDetails();

        EmployeeDetails newEmployee = DataManager.getEmployeeDetails();
        System.out.println(newEmployee.getFirstName());
        System.out.println(newEmployee.getLastName());

    }
}
