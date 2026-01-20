package Model;

public class Employee implements Upgradable {
    private String employeeName;
    private int employeeID;
    private int employeeAge;
    private int employeeSalary;
    private String employeeEmail;
    private int employeeWorkExperience;

    public Employee(String employeeName, int employeeID, int employeeAge, int employeeSalary, String employeeEmail, int employeeWorkExperience) {
        setEmployeeName(employeeName);
        setEmployeeID(employeeID);
        setEmployeeAge(employeeAge);
        setEmployeeSalary(employeeSalary);
        setEmployeeEmail(employeeEmail);
        setEmployeeWorkExperience(employeeWorkExperience);
    }

    public Employee() {
        this.employeeName = "Unknown";
        this.employeeID = 0;
        this.employeeAge = 0;
        this.employeeSalary = 0;
        this.employeeEmail = "Unknown";
        this.employeeWorkExperience = 0;
    }
    @Override
    public void upgrade() {
        System.out.println(employeeName+ "is upgrading");
    }

    @Override
    public boolean canUpgrade() {
        return true;
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
        if (employeeSalary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }
        this.employeeSalary = employeeSalary;
    }
    public void setEmployeeAge(int employeeAge) {
        if (employeeAge < 18) {
            throw new IllegalArgumentException("Employee must be at least 18 years old");
        }
        this.employeeAge = employeeAge;
    }
    public void setEmployeeID(int employeeID) {
        if (employeeID <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }
        this.employeeID = employeeID;
    }

    public void setEmployeeName(String employeeName) {
        if (employeeName == null || employeeName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.employeeName = employeeName;
    }    public double AnnualEmployeeSalary(){
        return employeeSalary*12;
    }
    public boolean isEligibleForPromotion(){
        return employeeWorkExperience>=3;
    }

    @Override
    public String toString() {
        return "Model.Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeID=" + employeeID +
                ", employeeAge=" + employeeAge +
                ", employeeSalary=" + employeeSalary +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeWorkExperience=" + employeeWorkExperience +
                '}';
    }
}
