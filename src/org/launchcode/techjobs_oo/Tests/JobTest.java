package org.launchcode.techjobs_oo.Tests;


import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class JobTest {
    @Test
    public void testSettingJobID() {
        Job job = new Job();
        Job jobTwo = new Job();
        int idOne = job.getId();
        int idTwo = jobTwo.getId();
        assertTrue(idOne != idTwo);

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobName = job.getName();
        String jobEmployer = job.getEmployer().getValue();
        String jobLocation = job.getLocation().getValue();
        String jobPositionType = job.getPositionType().getValue();
        String jobCoreCompetency = job.getCoreCompetency().getValue();


        assertEquals("Product Tester", jobName);
        assertEquals("ACME", jobEmployer);
        assertEquals("Desert", jobLocation);
        assertEquals("Quality control", jobPositionType);
        assertEquals("Persistence", jobCoreCompetency);

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobOne.equals(jobTwo));

    }

//    @Test
//    public void testJobReturnsBlankLine() {
//        Job job = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        assertTrue(" " == job.toString());
//    }

    @Test
    public void testContainLabelAndData() {
        Job job = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = " " + '\n' +
                "ID: 1" + '\n' +
                "Name: Product Tester" + '\n' +
                "Employer: ACME" + '\n' +
                "Location: Desert" + '\n' +
                "Position Type: Quality control" + '\n' +
                "Core Competency: Persistence" + '\n' +
                " ";
        assertEquals(expected, job.toString());
    }

    @Test
    public void testEmptyFieldUnavailable() {
        Job job = new Job(null ,  new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = " " +
                "ID: 1" + " " +
                "Name: Data not available" + " " +
                "Employer: ACME" + " " +
                "Location: Desert" + " " +
                "Position Type: Quality control" + " " +
                "Core Competency: Persistence" + " " +
                " ";
        assertEquals(expected, job.toString());
    }
}


