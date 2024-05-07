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


}
