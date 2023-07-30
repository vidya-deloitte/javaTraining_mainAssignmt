import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class credentailsValidation {

    //Performs Credentials Validation of Admin
    boolean AdminValidation(String adminLoginId,String adminPwd) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\AdminLoginDetails.json");
        AdminDetails admin = objectMapper.readValue(jsonFile, AdminDetails.class);
        //Checks if input credentials provided by Admin Matches with admin credentials in the file
        if(adminLoginId.equals(admin.getLoginId())&&adminPwd.equals(admin.getPassword()))
        {
            return true;
        }
        else
            return false;

    }
    //Performs Credentials Validation of Employee
    boolean EmployeeValidation(String empId,String empPwd) throws IOException {
        boolean result=false;
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonfilepath="C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\EmployeeDetails.json";
        List<EmployeeDetails> employees = objectMapper.readValue(new File(jsonfilepath), new TypeReference<List<EmployeeDetails>>() {});
        //Loops over list of employees present in the file
        for (EmployeeDetails employee : employees) {
            String id=employee.getEmployeeId();
            String pwd=employee.getPassword();
            //checks if input employee credentials matches the credentials values present in file
            if(id.equals(empId)&&pwd.equals(empPwd)){
                result=true;
                break;
            }

        }
        return result;
    }
}
