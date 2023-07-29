public class SplAllowanceCompute {
    double computeSpl(EmployeeDetails emp)
    {
        double spl=0;
        String SodexoOpt=emp.getSodexoOpt();
        if(SodexoOpt.equals("IN"))
            spl=emp.getCtc()-emp.getBasic()-emp.getHra()-emp.getLta()-emp.getVpf()-emp.getSodexo()-emp.getPf();
        else if(SodexoOpt.equals("OUT"))
            spl=emp.getCtc()-emp.getBasic()-emp.getHra()-emp.getLta()-emp.getVpf()-emp.getPf();
        System.out.println(spl);
        return spl;
    }
}


