package org.launchcode.techjobs.oo;

import mockit.Mocked;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public  void testJobConstructorSetsAllFields(){
        String name = "Product tester";
        String employer = "ACME";
        String location = "Desert";
        String positionType = "Quality Control";
        String coreCompetency = "Persistence";
        Job job1  = new Job(name, new Employer(employer), new Location(location), new PositionType(positionType), new CoreCompetency(coreCompetency));

        assertEquals(name,job1.getName());
        assertEquals(employer,job1.getEmployer());
        assertEquals(location,job1.getLocation());
        assertEquals(positionType,job1.getPositionType());
        assertEquals(coreCompetency,job1.getCoreCompetency());
        assertTrue(job1 instanceof Job);

    }

    @Test
    public void testJobsForEquality() {
        String name = "Product tester";
        String employer = "ACME";
        String location = "Desert";
        String positionType = "Quality Control";
        String coreCompetency = "Persistence";
        Job job1  = new Job(name, new Employer(employer), new Location(location), new PositionType(positionType), new CoreCompetency(coreCompetency));
        Job job2  = new Job(name, new Employer(employer), new Location(location), new PositionType(positionType), new CoreCompetency(coreCompetency));

        assertEquals(job1.equals(job2),job2.equals(job1));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        String str = System.lineSeparator()+ "ID: 1" + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: ACME" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality Control" + "\n" +
                "Core Competency: Persistence" + System.lineSeparator();

        assertTrue(str.startsWith(System.lineSeparator()));
        assertTrue(str.endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String name = "Product tester";
        String employer = "ACME";
        String location = "Desert";
        String positionType = "Quality Control";
        String coreCompetency = "Persistence";
        Job job1  = new Job(name, new Employer(employer), new Location(location), new PositionType(positionType), new CoreCompetency(coreCompetency));

        String strReturn = System.lineSeparator() + "ID: " + job1.getId() + "\n" +
                "Name: " + name + "\n" +
                "Employer: " + employer+ "\n" +
                "Location: " + location + "\n" +
                "Position Type: " + positionType + "\n" +
                "Core Competency: " + coreCompetency + System.lineSeparator();

        assertEquals(strReturn,job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        String name = "Product tester";
        String employer = "ACME";
        String location = "";
        String positionType = "";
        String coreCompetency = "Persistence";
        Job job1  = new Job(name, new Employer(employer), new Location(location), new PositionType(positionType), new CoreCompetency(coreCompetency));

        String strReturn = System.lineSeparator() + "ID: " + job1.getId() + "\n" +
                "Name: " + name + "\n" +
                "Employer: " + employer+ "\n" +
                "Location: Data Not Available"  + "\n" +
                "Position Type: Data Not Available" + "\n" +
                "Core Competency: " + coreCompetency + System.lineSeparator();

        assertEquals(strReturn,job1.toString());
    }
}
