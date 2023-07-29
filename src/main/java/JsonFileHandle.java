import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class JsonFileHandle {
    void jsonWrite(EmployeeDetails emp,String jsonfilepath){
        try {
            JSONObject empJSON=createEmpJson(emp);
            File file = new File(jsonfilepath);
            JSONArray existingData;
            if (file.exists()) {
                // Read existing data from the file
                String fileContent = new String(Files.readAllBytes(Paths.get(jsonfilepath)));
                existingData = new JSONArray(fileContent);
            } else {
                // If the file doesn't exist, create a new JSON array
                existingData = new JSONArray();
            }

            // Add new data to the existing JSON array
            existingData.put(empJSON);

            // Write the updated JSON array back to the file
            Files.write(Paths.get(jsonfilepath), existingData.toString(2).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Data added to the file successfully!");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }



    }

    void jsonRead(String emp)
    {

    }
    JSONObject createEmpJson(EmployeeDetails emp)
    {
        JSONObject newData = new JSONObject();
        newData.put("employeeId",emp.getEmployeeId());
        newData.put("name",emp.getName());
        newData.put("basic",emp.getBasic());
        newData.put("hra",emp.getHra());
        newData.put("lta",emp.getLta());
        newData.put("ctc",emp.getCtc());
        newData.put("sodexo",emp.getSodexo());
        newData.put("sodexoOpt",emp.getSodexoOpt());
        newData.put("vpf",emp.getVpf());
        newData.put("pf",emp.getPf());
        newData.put("password",emp.getPassword());
        newData.put("specialAllowance",emp.getSpecialAllowance());
        return newData;


    }
}
