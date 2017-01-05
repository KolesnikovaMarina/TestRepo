package creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marina on 29.12.2016.
 */
public class Employees implements Cloneable{
    private List<String> empList;

    public Employees(){
        empList = new ArrayList<String>();
    }

    public Employees(List<String> list){
        this.empList = list;
    }

    public void loadDate(){
        //read all employees from database and put into the list
        empList.add("Vito");
        empList.add("Max");
        empList.add("Riko");
        empList.add("Mario");
        empList.add("Jon");
        empList.add("Donald");
    }

    public List<String> getEmpList(){
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<String> emp = new ArrayList<String>();
        for(String s:empList){
            emp.add(s);
        }
        return new Employees(emp);
    }

}


