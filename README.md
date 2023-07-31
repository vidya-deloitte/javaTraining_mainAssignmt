This application calculates the salary components when an employee monthly ctc is entered.
The components calculated are HRA,BASIC,LTA,VPF,PF,SPECIAL ALLOWANCES, can opt in or out of SODEXO.
The application has 2 logins,
1.Admin - when the right admin credentials will be given, the admin can add new employee and can update the employees ctc structure.
2.Employee - when the right employee login will be given, the employee can view his/her CTC Structure,modify vpf and sodexo details.

All the above actions can be performed from CLI prompt that will be given to the user.

The employee details and admin details are stored in a JSON file.

The application contains a component.properties file where the hra,lta and basic percentage are present.

Exceptional handling and error logging is done. The logging is stored in a Log file