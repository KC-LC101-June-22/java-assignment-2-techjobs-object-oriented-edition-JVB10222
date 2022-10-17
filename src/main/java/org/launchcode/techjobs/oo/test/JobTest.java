package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.Employer;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job3.getName(),"Product tester");
        assertEquals(job3.getEmployer().getValue(),"ACME");
        assertEquals(job3.getLocation().getValue(),"Desert");
        assertEquals(job3.getPositionType().getValue(),"Quality control");
        assertEquals(job3.getCoreCompetency().getValue(),"Persistence");

        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job3.getName() instanceof String);

    }

    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Product tester", new Employer(null), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals('\n', job6.toString().charAt(0));
        assertEquals('\n', job6.toString().charAt(job6.toString().length()-1));
        String testChar = String.valueOf(job6.toString().charAt(0));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected =
                "\nID: " + job7.getId() + "\n" +
                "Name: " + "Product tester" + "\n" +
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" + "\n";

        assertEquals(expected,job7.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job8 = new Job(null, new Employer(null), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job9 = new Job(null, new Employer(null), new Location(null), new PositionType(null), new CoreCompetency(null));

        String expected =
                "\nID: " + job8.getId() + "\n" +
                        "Name: " + "Data not available" + "\n" +
                        "Employer: " + "Data not available" + "\n" +
                        "Location: " + "Desert" + "\n" +
                        "Position Type: " + "Quality control" + "\n" +
                        "Core Competency: " + "Persistence" + "\n";

        assertEquals(expected,job8.toString());
        //assertEquals(expected, job9.toString());
        //used ^ to see that the actual values are being changed to default response

    }
    


}
