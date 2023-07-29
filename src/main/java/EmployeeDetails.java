public class EmployeeDetails {
    private String employeeId;
    private String name;
    private double basic;
    private double hra;
    private double lta;
    private double pf;
    private double specialAllowance;
    private double sodexo;

    public double getVpf() {
        return vpf;
    }

    public void setVpf(double vpf) {

        this.vpf = vpf;
    }

    private double vpf;

    public String getSodexoOpt() {
        return sodexoOpt;
    }

    public void setSodexoOpt(String sodexoOpt) {
        this.sodexoOpt = sodexoOpt;
    }

    private String sodexoOpt;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public double getCtc() {
        return ctc;
    }

    public void setCtc(double ctc) {
        this.ctc = ctc;
    }

    private double ctc;

    public double getSodexo() {
        return sodexo;
    }

    public void setSodexo(double sodexo) {
        this.sodexo = sodexo;
    }


    // Constructors
    public EmployeeDetails(String employeeId, String name, double basic, double hra, double lta, double pf, double specialAllowance, double ctc, double sodexo, double vpf, String sodexoOpt, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.basic = basic;
        this.hra = hra;
        this.lta = lta;
        this.pf = pf;
        this.specialAllowance = specialAllowance;
        this.sodexo=sodexo;
        this.ctc=ctc;
        this.vpf = vpf;
        this.sodexoOpt = sodexoOpt;
        this.password = password;
    }

    public EmployeeDetails(){

    }

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getLta() {
        return lta;
    }

    public void setLta(double lta) {
        this.lta = lta;
    }

    public double getPf() {
        return pf;
    }

    public void setPf(double pf) {
        this.pf = pf;
    }

    public double getSpecialAllowance() {
        return specialAllowance;
    }

    public void setSpecialAllowance(double specialAllowance) {
        this.specialAllowance = specialAllowance;
    }
}
