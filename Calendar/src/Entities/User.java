package Entities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Marina on 12.12.2016.
 */
public class User {
    private String name;
    private String login;
    private String password;
    private String email;
    private Department department;
    private JobTitle jobTitle;
    private static HashMap<String,User> users = new HashMap<String,User>();

    //static constructor
    static {
        //developers
        users.put("vito",new User("Kolesnikov Victor","vito","1234",
                           "kolvictor64@mail.ru", Department.DEVELOPERS,JobTitle.DIRECTOR));
        users.put("ser",new User("Agapov Sergey","ser","1234",
                "kolvictor64@mail.ru", Department.DEVELOPERS,JobTitle.JUNIOR));
        users.put("alex",new User("Olhovik Alexander","alex","1234",
                "kolvictor64@mail.ru", Department.DEVELOPERS,JobTitle.SENIOR));
        //testers
        users.put("max",new User("Agapov Maksim","max","1234",
                "kolvictor64@mail.ru", Department.TESTERS,JobTitle.JUNIOR));
        users.put("max2",new User("Korolkov Maksim","max2","1234",
                "kolvictor64@mail.ru", Department.TESTERS,JobTitle.LEADER));
        //bi
        users.put("roman",new User("Shatov Roman","roman", "1234",
                "kolvictor64@mail.ru", Department.BI,JobTitle.SENIOR));
        users.put("vladok",new User("Kovolev Vladislav","vladok","1234",
                "kolvictor64@mail.ru", Department.BI,JobTitle.LEADER));
        //accounting
        users.put("marina",new User("Kolesnikova Marina","marina","1234",
                "kolvictor64@mail.ru", Department.ACCOUNTING,JobTitle.LEADER));
       //it
        users.put("victor",new User("Kutin Victor","victor", "1234",
                "kolvictor64@mail.ru", Department.IT,JobTitle.JUNIOR));
        users.put("riko",new User("Makarov Roman","riko","1234",
                "kolvictor64@mail.ru", Department.IT,JobTitle.LEADER));


    }

    public User(String name, String login, String password, String email, Department department, JobTitle jobTitle) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.department = department;
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public static User getUserByLogin(String login, String password){
       User user = users.get(login);
       if (user!=null&&user.getPassword().equals(password))
           return user;
       else
          return null;
    }

    public static User getUserByName(String name){
        for(User user : users.values()) {
            if(user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }


}
