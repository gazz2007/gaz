public class Employee {
    private String employeeName;
    private int employeeID;
    private int employeeAge;
    private int employeeSalary;
    private String employeeEmail;
    private int employeeWorkExperience;

    public Employee(String employeeName, int employeeID, int employeeAge, int employeeSalary, String employeeEmail, int employeeWorkExperience) {
        this.employeeName = employeeName;
        this.employeeID=employeeID;
        this.employeeAge = employeeAge;
        this.employeeSalary = employeeSalary;
        this.employeeEmail = employeeEmail;
        this.employeeWorkExperience=employeeWorkExperience;
    }

    public Employee() {
        this.employeeName = "Unknown";
        this.employeeID = 0;
        this.employeeAge = 0;
        this.employeeSalary = 0;
        this.employeeEmail = "Unknown";
        this.employeeWorkExperience = 0;
    }

    public int getEmployeeWorkExperience() {
        return employeeWorkExperience;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeWorkExperience(int employeeWorkExperience) {
        this.employeeWorkExperience = employeeWorkExperience;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public double AnnualEmployeeSalary(){
        return employeeSalary*12;
    }
    public boolean isEligibleForPromotion(){
        return employeeWorkExperience>=3;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeID=" + employeeID +
                ", employeeAge=" + employeeAge +
                ", employeeSalary=" + employeeSalary +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeWorkExperience=" + employeeWorkExperience +
                '}';
    }
}
