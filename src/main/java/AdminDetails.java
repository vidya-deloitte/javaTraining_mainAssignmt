public class AdminDetails {
    private String loginId;
    private String password;

    public AdminDetails(){

    }

    public AdminDetails(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
    public String getLoginId() {
        return loginId;
    }
    public String getPassword() {return password;}
}
