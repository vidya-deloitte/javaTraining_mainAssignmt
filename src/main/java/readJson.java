//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.File;
//import java.io.IOException;
//
//public class readJson {
//    void readJson(String path,String className) {
//        try {
//            // Create an ObjectMapper instance
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            // Read the JSON file into a Java object
//            File jsonFile = new File(path);
//            // Replace "path/to/your/file/admin.json" with the actual path to your JSON file
//            AdminDetails admin = objectMapper.readValue(jsonFile, AdminDetails.class);
//
//            // Print the read data
//            System.out.println("Admin ID: " + admin.getAdminId());
//            System.out.println("First Name: " + admin.getFirstName());
//            System.out.println("Last Name: " + admin.getLastName());
//            System.out.println("Email: " + admin.getEmail());
//            System.out.println("Password: " + admin.getPassword());
//            System.out.println("Role: " + admin.getRole());
//            System.out.println("IsActive: " + admin.isActive());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
