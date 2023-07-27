import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

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
}
