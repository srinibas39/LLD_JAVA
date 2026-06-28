public class Client {

    public static void main(String[] args) {
        EmployeeImp emp = new EmployeeImp();
        EmployeeProxy empProxy = new EmployeeProxy(emp,"Admin");
        empProxy.getDesignation();
        empProxy.getSalary();
        empProxy.getInfo();
    }
}
