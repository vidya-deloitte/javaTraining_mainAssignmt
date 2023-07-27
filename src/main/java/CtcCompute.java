import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CtcCompute{
    void ctcFunc(String empId,String empName,Double ctc) {
        // Path to the properties file
        String propertiesFilePath = "C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\componentpercent.properties";

        try (FileInputStream fileInputStream = new FileInputStream(propertiesFilePath)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String hraPercentStr = properties.getProperty("hra");
            String basicPercentStr=properties.getProperty("basic");
            String ltaPercentStr=properties.getProperty("lta");
            double hraPercent=0,ltaPercent=0,basicPercent=0;
            if (hraPercentStr != null) {
                hraPercent = Double.parseDouble(hraPercentStr);
                System.out.println("HRA Percentage: " + hraPercent);
            } else {
                System.out.println("HRA Percentage not found in the properties file.");
            }
            if (basicPercentStr != null) {
                basicPercent = Double.parseDouble(basicPercentStr);
                System.out.println("Basic Percentage: " + basicPercent);
            } else {
                System.out.println("Basic Percentage not found in the properties file.");
            }
            if (ltaPercentStr != null) {
                ltaPercent = Double.parseDouble(ltaPercentStr);
                System.out.println("Basic Percentage: " + ltaPercent);
            } else {
                System.out.println("lta Percentage not found in the properties file.");
            }
            double basic=(basicPercent/100)*ctc;
            double hra=(hraPercent/100)*basic;
            double lta=(ltaPercent/100)*basic;
            double pf=1800;
            double sodexo=2200;
            double special=ctc - (hra-lta-pf-sodexo);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonfilepath="C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\EmployeeDetails.json";
            JsonNode jsonNode = objectMapper.readTree(new File(jsonfilepath));
            JsonNode jsonArray = jsonNode.get("employees");
            for(JsonNode record:jsonArray)
            {
                if(record.get("EmployeeID").asText()==empId)
                {
                   System.out.println("Employee Id already exists");
                }
                else {
                    EmployeeDetails emp=new EmployeeDetails(empId,empName,basic,hra,lta,pf,special,ctc,sodexo,0,"IN",empName+"@123");
                    try {
                        objectMapper.writeValue(new File(jsonfilepath), emp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }





        }
    }


