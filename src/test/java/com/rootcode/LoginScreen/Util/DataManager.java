package LoginScreen.Util;

import com.github.javafaker.Faker;

public class DataManager {
    public static String getFirstName(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        return firstName;
    }

    public static String getLastName(){
        Faker faker1 = new Faker();
        String lastName = faker1.name().lastName();
        return lastName;
    }

    public static EmployeeDetails getEmployeeDetails() {
        return new EmployeeDetails();
    }


}
