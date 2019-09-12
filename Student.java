
class Department implements Cloneable {

    int departmentId;
    String departmentName;

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Object clone()throws CloneNotSupportedException {  
        return (Department)super.clone();  
    }

}

class Student implements Cloneable {

    int rollNo;
    String name;
    Department branch;

    public Student(int rollNo, String name, int departmentId, String departmentName) {
        this.rollNo = rollNo;
        this.name = name;
        branch = new Department(departmentId, departmentName);
    }

    public Object clone()throws CloneNotSupportedException {  
        Student studentObj = (Student)super.clone();
        studentObj.branch = (Department)this.branch.clone();
        return studentObj;
    }

    public static void main(String args[]){
        Student s1 = new Student(1,"Riya",10, "EEE");
        try {
            Student s2 = (Student) s1.clone();
            s1.name="Ram";
            s1.branch.departmentName = "CSE";
            System.out.println(s2.name);
            System.out.println(s1.name);
            System.out.println(s2.branch.departmentName);
            System.out.println(s1.branch.departmentName);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}