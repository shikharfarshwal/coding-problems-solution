/**
 * Created by Shikhar on 03-01-2018.
 */
public class Employee implements Comparable<Employee>{

    int id;
    String name;
    String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int compareTo(Employee employee) {
      /* if(this.getName().equalsIgnoreCase(employee.getName())){
           return 0;
       }
       else
           this.getName()*/
        /* if(this.id==employee.id){
            return 0;
        }
        else
        return this.id>employee.id?1:-1;*/
        return (employee.id-this.id);
    }
}
