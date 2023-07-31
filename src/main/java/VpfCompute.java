import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class VpfCompute {
    //calculates vpf of the employee and updates it back in the employee file
    void writeVpf() throws IOException {
        JsonFileHandle json = new JsonFileHandle();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the vpf percentage please enter number only");
        int vpfpercent = input.nextInt();
        System.out.println("Enter Employee Id");
        String empId = input.next();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonfilepath = "C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\EmployeeDetails.json";
        List<EmployeeDetails> employees = objectMapper.readValue(new File(jsonfilepath), new TypeReference<List<EmployeeDetails>>() {
        });
        CtcCompute ctcObj = new CtcCompute();
        SplAllowanceCompute sp = new SplAllowanceCompute();
        for (EmployeeDetails employee : employees) {
            String id = employee.getEmployeeId();
            if (id.equals(empId)) {
                EmployeeDetails copy = employee;
                ctcObj.deleteRecord(id);
                double updatedvpf = (vpfpercent / 100.0) * copy.getBasic();
                copy.setVpf(updatedvpf);
                double updatedspl = sp.computeSpl(copy);
                copy.setSpecialAllowance(updatedspl);
                EmployeeDetails emp = new EmployeeDetails(copy.getEmployeeId(), copy.getName(), copy.getBasic(), copy.getHra(), copy.getLta(), copy.getPf(), copy.getSpecialAllowance(), copy.getCtc(),
                        copy.getSodexo(), copy.getVpf(), copy.getSodexoOpt(), copy.getPassword());
                json.jsonWrite(emp, jsonfilepath);
                break;
            }

        }

    }
}

