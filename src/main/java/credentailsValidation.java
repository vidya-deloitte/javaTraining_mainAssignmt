import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class credentailsValidation {
    boolean AdminValidation(String adminLoginId,String adminPwd) throws IOException {
        System.out.print("entered");
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\AdminLoginDetails.json");
        AdminDetails admin = objectMapper.readValue(jsonFile, AdminDetails.class);
        if(adminLoginId.equals(admin.getLoginId())&&adminPwd.equals(admin.getPassword())){
            return true;}
        else
            return false;

    }

    boolean EmployeeValidation(String empId,String empPwd) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonfilepath="C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\EmployeeDetails.json";
        List<EmployeeDetails> employees = objectMapper.readValue(new File(jsonfilepath), new TypeReference<List<EmployeeDetails>>() {});

        for (EmployeeDetails employee : employees) {
            String id=employee.getEmployeeId();
            String pwd=employee.getPassword();
            if(id.equals(empId)&&pwd.equals(empPwd)){
                break;
            }
            else {
                return false;
            }

        }
        return true;
    }
}
