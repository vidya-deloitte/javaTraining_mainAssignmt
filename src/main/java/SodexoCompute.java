import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SodexoCompute {
    void sodexoCompute() throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter EmployeeId");
        String empId=input.next();
        System.out.println("Do you want to opt IN or OUT of Sodexo?");
        System.out.println("Please enter IN or OUT?");
        String choice=input.next();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonfilepath = "C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\EmployeeDetails.json";
        List<EmployeeDetails> employees = objectMapper.readValue(new File(jsonfilepath), new TypeReference<List<EmployeeDetails>>() {
        });
        SplAllowanceCompute sp=new SplAllowanceCompute();
        CtcCompute ctcObj=new CtcCompute();
        JsonFileHandle json=new JsonFileHandle();
        for (EmployeeDetails employee : employees) {
            String id = employee.getEmployeeId();
            double sodexoOut=0;
            if (id.equals(empId)) {
                EmployeeDetails copy=employee;
                ctcObj.deleteRecord(id);
                if(choice.equals("IN")) {
                    copy.setSodexo(2200);
                    copy.setSodexoOpt("IN");
                }
                else if(choice.equals("OUT"))
                {
                    sodexoOut=copy.getSodexo();
                    copy.setSodexo(0);
                    copy.setSodexoOpt("OUT");
                }
                double updatedspl=sp.computeSpl(copy);
                copy.setSpecialAllowance(updatedspl+sodexoOut);

                EmployeeDetails emp=new EmployeeDetails(copy.getEmployeeId(), copy.getName(), copy.getBasic(), copy.getHra(),copy.getLta(),copy.getPf(),copy.getSpecialAllowance(),copy.getCtc(),
                        copy.getSodexo(),copy.getVpf(),copy.getSodexoOpt(),copy.getPassword());
                json.jsonWrite(emp,jsonfilepath);
                break;
            } else
                System.out.println("Record not found");


        }




    }
}
