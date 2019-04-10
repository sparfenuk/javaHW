package Employees;



import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Employee implements Serializable {

    public String userName;
    private String pass;

    public static Employee currentUser = null;

    public Employee(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void Serialize() {
        try {
            FileOutputStream fos = new FileOutputStream(userName + ".emp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        } catch (Exception e) {
        }
    }

    public static boolean checkLog(String userName, String pass) {
        try {


            FileInputStream fis = new FileInputStream(userName + ".emp");
            ObjectInputStream oin = new ObjectInputStream(fis);
            Employee employee = (Employee) oin.readObject();

            oin.close();
            fis.close();

            if(employee.pass.equals(pass)) {

                currentUser = employee;
                return true;

            }
            else {

                currentUser = null;
                return false;

            }

        } catch (Exception e) {
            return false;
        }
    }

    public static Employee getEmployee(String userName) {
        try {

            FileInputStream fis = new FileInputStream(userName + ".emp");
            ObjectInputStream oin = new ObjectInputStream(fis);
            Employee employee = (Employee) oin.readObject();

            oin.close();
            fis.close();
            return employee;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteEmployee(){
        File file = new File(userName + ".emp");
        return file.delete();
    }


    /*
     *a я написав ЛУЛ
     *
     */

    public static List<Employee> getEmployees()
    {

        List<Employee> employees = new ArrayList<>();

        File dir = new File(".");

        File[] listOfFiles = dir.listFiles(new FilenameFilter() { @Override public boolean accept(File dir, String name) { return name.endsWith(".emp"); } });

        for (File f:listOfFiles
             ) {
            if (f.isFile())
                System.out.println(f.getName().replaceFirst("[.][^.]+$", ""));
              employees.add(Employee.getEmployee(f.getName().replaceFirst("[.][^.]+$", "")));
        }

        return employees;
    }

    @Override
    public String toString() {
        return  userName + ' ' + pass;
    }
}
