package org.launchcode.techjobs.oo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Add Employer List
//        String [] employerList = {"ACME","LaunchCode","Walmart"};
//        String [] coreCompetencyList = {"Java, mySql, c#","Javascript, MsSql, AWS#","Java, Javascript, c#"};
//        String [] locationList = {"Denver","Philadelphia","New York City"};
//        loadEmployerDetailsData(employerList, Employer.class);
//        loadEmployerDetailsData(coreCompetencyList, CoreCompetency.class);
//        loadEmployerDetailsData(locationList, Location.class);
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        Job job3 = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));

        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);

        for (Job job : jobs){
            System.out.println(job);
        }
    }


    public static <T> void loadEmployerDetailsData(String [] arr, Class<T> objClass){
        ArrayList<T> employers = new ArrayList<>();
        try {
            for (String emp : arr) {
                T empInstance = objClass.newInstance(); // Create a new instance using reflection
                // Assuming the object class has a method setValue(String) like Employer
                Method setValueMethod = objClass.getMethod("setValue", String.class);
                setValueMethod.invoke(empInstance, emp); // Set the value
                employers.add(empInstance);
            }

            for (T employer : employers) {
                System.out.println(employer);
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException  e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
