import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String args[]) throws IOException {
        while(true){
            int inputChoice;
            String adminLoginId,adminPwd;
            System.out.println("\n\nMenu\n");
            System.out.println("1.Admin\n2.Employee\n3.Exit\n");
            System.out.println("Please enter choice:");
            Scanner input=new Scanner(System.in);
            inputChoice=input.nextInt();
            switch(inputChoice){
                case 1:System.out.println("Enter Admin Login Id");
                       adminLoginId=input.next();
                       System.out.println("Enter Admin Login Id");
                       adminPwd=input.next();
                       credentailsValidation validation=new credentailsValidation();
                       if(validation.AdminValidation(adminLoginId,adminPwd)) {
                           AdminSubmenu();
                       }
                       else
                           System.out.print("invalid");




                case 2:break;
                case 3:break;
            }




        }

    }

    static void AdminSubmenu() {
        while (true) {
            System.out.println("\n1.Insert Records\n2.Update Records\n3.Exit");
            Scanner input=new Scanner(System.in);
            System.out.println("Enter the choice");
            int inputChoice=input.nextInt();
            switch (inputChoice){
                case 1:System.out.println("Enter Employee Name");
                       String employeeName=input.next();
                       System.out.println("Enter Employee Id");
                       String employeeId=input.next();
                       System.out.println("Enter Employee CTC");
                       double ctc=input.nextDouble();
                       CtcCompute ctcObj=new CtcCompute();
                       ctcObj.ctcFunc(employeeId,employeeName,ctc);

                       break;
                case 2:break;
                case 3:break;
            }

        }
    }
}
