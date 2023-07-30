import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
//Handles CTC related computation
public class CtcCompute {
    //This function computes the salary components when a new employee record is initially added
    void ctcFunc(String empId, String empName, Double ctc) {

        String propertiesFilePath = "C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\componentpercent.properties";

        try (FileInputStream fileInputStream = new FileInputStream(propertiesFilePath)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String hraPercentStr = properties.getProperty("hra");
            String basicPercentStr = properties.getProperty("basic");
            String ltaPercentStr = properties.getProperty("lta");
            double hraPercent = 0, ltaPercent = 0, basicPercent = 0;
            if (hraPercentStr != null) {
                hraPercent = Double.parseDouble(hraPercentStr);
                System.out.println("HRA Percentage: " + hraPercent);
            }
            else {
                System.out.println("HRA Percentage not found in the properties file.");
            }
            if (basicPercentStr != null) {
                basicPercent = Double.parseDouble(basicPercentStr);
                System.out.println("Basic Percentage: " + basicPercent);
            }
            else {
                System.out.println("Basic Percentage not found in the properties file.");
            }
            if (ltaPercentStr != null) {
                ltaPercent = Double.parseDouble(ltaPercentStr);
                System.out.println("Basic Percentage: " + ltaPercent);
            }
            else {
                System.out.println("lta Percentage not found in the properties file.");
            }
            double basic = (basicPercent / 100) * ctc;
            double hra = (hraPercent / 100) * basic;
            double lta = (ltaPercent / 100) * ctc;
            double pf = 1800;
            double sodexo = 2200;
            double special = ctc - basic-hra-lta-pf-sodexo;
            insertRecord(empId, empName, basic, hra, lta, pf, special, ctc, sodexo, 0, "IN", empName + "@123");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // This function is called when an employees's ctc has to be updated
    void updateCtc(String empId, Double ctc) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonfilepath = "C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\EmployeeDetails.json";
        List<EmployeeDetails> employees = objectMapper.readValue(new File(jsonfilepath), new TypeReference<List<EmployeeDetails>>() {
        });

        for (EmployeeDetails employee : employees) {
            System.out.println(employee.getEmployeeId());
            String id = employee.getEmployeeId();
            if (id.equals(empId)) {
                System.out.println(employee.getEmployeeId());
                String name = employee.getName();
                deleteRecord(empId);
                ctcFunc(empId, name, ctc);

            } else
                System.out.println("Employee record not found");

        }


    }

    //To insert an employee record into file
    void insertRecord(String empId, String empName, double basic, double hra, double lta, double pf, double special, double ctc, double sodexo, double vpf, String sodexoOpt, String password) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonfilepath = "C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\EmployeeDetails.json";
        EmployeeDetails emp = new EmployeeDetails(empId, empName, basic, hra, lta, pf, special, ctc, sodexo, 0, "IN", empName + "@123");
        JsonFileHandle json = new JsonFileHandle();
        json.jsonWrite(emp, jsonfilepath);
    }
    //Function is called when we want to update any details of employee record
    void deleteRecord(String empIdToDelete) {
        String jsonFilePath = "C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\EmployeeDetails.json";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON data from the file and convert it to a List of EmployeeDetails objects
            List<EmployeeDetails> employeesList = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<EmployeeDetails>>() {
            });

            // Variable to keep track of whether the employee is found and deleted
            boolean employeeFound = false;

            // Loop through the list to find the record with the matching employee ID
            Iterator<EmployeeDetails> iterator = employeesList.iterator();
            while (iterator.hasNext()) {
                EmployeeDetails employee = iterator.next();
                String empId = employee.getEmployeeId();

                if (empId.equals(empIdToDelete)) {
                    // Remove the employee from the list
                    iterator.remove();
                    employeeFound = true;
                    break; // No need to continue the loop after deleting the employee
                }
            }

            if (employeeFound) {
                // Write the updated list back to the file as a JSON array
                objectMapper.writeValue(new File(jsonFilePath), employeesList);
                System.out.println("Employee with EmployeeId " + empIdToDelete + " has been deleted.");
            } else {
                System.out.println("Employee with EmployeeId " + empIdToDelete + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //Function retrieves the matching record
    void retrieveRecord(String empId) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        boolean result=false;
        String jsonfilepath = "C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\EmployeeDetails.json";
        List<EmployeeDetails> employees = objectMapper.readValue(new File(jsonfilepath), new TypeReference<List<EmployeeDetails>>() {
        });

        for (EmployeeDetails employee : employees) {
            String id = employee.getEmployeeId();
            if (id.equals(empId)) {
                Jtable employeeTableDisplay=new Jtable();
                employeeTableDisplay.addEmployeeRow(employee);
                result=true;
                break;
            }

        }
        if(result==false)
            System.out.println("Record not found");
    }




}















