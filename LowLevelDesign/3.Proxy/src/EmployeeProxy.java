public class EmployeeProxy implements Employee{
    private Employee employee;
    private String clientRole;

    public EmployeeProxy(Employee employee , String clientRole){
        this.employee = employee;
        this.clientRole = clientRole;
    }

    @Override
    public void getInfo() {
       if(clientRole.equals("Admin")){
           employee.getInfo();
       }
    }

    @Override
    public void getSalary() {
        if(clientRole.equals("Manager")){
            employee.getSalary();
        }
    }

    @Override
    public void getDesignation() {
        if(clientRole.equals("Employee") || clientRole.equals("Admin")){
            employee.getDesignation();
        }
    }
}
