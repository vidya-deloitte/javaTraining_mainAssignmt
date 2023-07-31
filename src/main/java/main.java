import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
//Displays the menus for admin and employee to interact with the application

class MyCustomException extends Exception {
    public MyCustomException() {
        super();
    }
    public MyCustomException(String message) {
        super(message);
        System.out.println(message);
    }


}

public class main {
    public static void main(String args[]) throws IOException {
        int inputChoice;
        LoggerFile logging = new LoggerFile();
        while (true) {
            String adminLoginId, adminPwd, empLoginId, empPwd;
            System.out.println("\n\n----Menu----\n");
            System.out.println("1.Admin\n2.Employee\n3.Exit\n");
            try {
                System.out.println("Please enter choice:");
                Scanner input = new Scanner(System.in);
                inputChoice = input.nextInt();
                if (inputChoice < 1 || inputChoice >= 4)
                    throw new MyCustomException("Please Enter a choice between 1 to 3");
                if (inputChoice == 1) {
                    System.out.println("Enter Admin Login Id");
                    adminLoginId = input.next();
                    System.out.println("Enter Admin Password");
                    adminPwd = input.next();
                    credentailsValidation validation = new credentailsValidation();
                    if (validation.AdminValidation(adminLoginId, adminPwd)) {
                        AdminSubmenu();
                    } else
                        System.out.println("Invalid Admin Credentials");
                } else if (inputChoice == 2) {
                    System.out.println("Enter Employee Login Id");
                    empLoginId = input.next();
                    System.out.println("Enter Employee Password");
                    empPwd = input.next();
                    credentailsValidation empvalidation = new credentailsValidation();
                    if (empvalidation.EmployeeValidation(empLoginId, empPwd)) {
                        empSubmenu();
                    } else
                        System.out.print("Invalid Employee Credentials");
                } else if (inputChoice == 3) {
                    System.out.println("Thank you...Closing Application!!");
                    break;
                }

            } catch (InputMismatchException e) {
                LoggerFile.severe("Entered input other than numbers");
                System.out.println("Please enter only numbers as show in menu");
            } catch (MyCustomException e) {
                LoggerFile.severe("Entered Choice is present in the menu");
            }
        }

    }

    static void AdminSubmenu() throws IOException {
        CtcCompute ctcObj = new CtcCompute();
        while (true) {
            System.out.println("\n1.Insert Records\n2.Update Records\n3.Exit");
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("Enter the choice");
                int inputChoice = input.nextInt();
                if (inputChoice < 1 || inputChoice >= 4)
                    throw new MyCustomException("Please Enter a choice between 1 to 3");
                if (inputChoice == 1) {
                    System.out.println("Enter Employee Name");
                    String employeeName = input.next();
                    System.out.println("Enter Employee Id");
                    String employeeId = input.next();
                    System.out.println("Enter Employee CTC");
                    double ctc = input.nextDouble();
                    ctcObj.ctcFunc(employeeId, employeeName, ctc);
                } else if (inputChoice == 2) {
                    System.out.println("Enter Employee Id");
                    String empId = input.next();
                    System.out.println("Enter CTC");
                    Double updatedCtc = input.nextDouble();
                    ctcObj.updateCtc(empId, updatedCtc);
                } else if (inputChoice == 3)
                    break;
            } catch (InputMismatchException e) {
                LoggerFile.severe("Entered input other than numbers");
                System.out.println("Please enter only numbers as show in menu");
            } catch (MyCustomException e) {
                LoggerFile.severe("Entered Choice is present in the menu");
            }


        }
    }


    static void empSubmenu() throws IOException {
        CtcCompute ctcObj = new CtcCompute();
        while (true) {
            System.out.println("\n1.CurrentCtc\n2.Modify Details\n3.View monthly in Hand salary\n4.Exit");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the choice");
            try {
                int inputChoice = input.nextInt();
                if (inputChoice < 1 || inputChoice >= 5)
                    throw new MyCustomException("Please Enter a choice between 1 to 4");
                if (inputChoice == 1) {
                    System.out.println("Enter Employee Id");
                    String employeeId = input.next();
                    ctcObj.retrieveRecord(employeeId);
                } else if (inputChoice == 2) {
                    while (true) {
                        try {
                            System.out.println("1.VPF\n2.Sodexo\n3.Exit");
                            System.out.println("Enter the choice");
                            int inpch = input.nextInt();
                            if (inpch < 1 || inpch >= 4)
                                throw new MyCustomException("Please enter choice from 1 to 3 as shown in menu");
                            if (inpch == 1) {
                                VpfCompute vpfCompute = new VpfCompute();
                                vpfCompute.writeVpf();
                            } else if (inpch == 2) {
                                SodexoCompute sodexoCompute = new SodexoCompute();
                                sodexoCompute.sodexoCompute();
                            } else
                                break;
                        }catch(MyCustomException e)
                        {
                            LoggerFile.severe("Entered Choice is not present in the menu");
                        }
                        catch(InputMismatchException e)
                        {
                            LoggerFile.severe("Entered input other than numbers");
                            System.out.println("Please enter only numbers as show in menu");
                        }

                    }
                } else if (inputChoice == 3) {
                    System.out.println("Enter Employee Id");
                    String employeeId = input.next();
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonfilepath = "C:\\Users\\vidye\\Desktop\\javaTraining_mainAssignmt\\src\\main\\resources\\EmployeeDetails.json";
                    List<EmployeeDetails> employees = objectMapper.readValue(new File(jsonfilepath), new TypeReference<List<EmployeeDetails>>() {
                    });

                    for (EmployeeDetails employee : employees) {
                        String id = employee.getEmployeeId();
                        if (id.equals(employeeId)) {
                            double mnthlySalInHand = employee.getBasic() + employee.getHra() + employee.getLta() + employee.getSpecialAllowance();
                            System.out.println("Monthly In Hand Salary" + mnthlySalInHand);
                            break;
                        } else
                            System.out.println("Record not found");


                    }
                } else if (inputChoice == 4)
                    break;
            } catch (InputMismatchException e) {
                LoggerFile.severe("Entered input other than numbers");
                System.out.println("Please enter only numbers as show in menu");

            } catch (MyCustomException e) {
                LoggerFile.severe("Entered Choice is not present in the menu");
            }
        }
    }
}





