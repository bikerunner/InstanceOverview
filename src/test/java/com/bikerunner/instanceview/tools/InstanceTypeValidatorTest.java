/**
 * 
 */
package com.bikerunner.instanceview.tools;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InstanceTypeValidatorTest
{
    InstanceTypeValidator testClass = null;

    File tempDir = null;

    @Before
    public void prepareTests()
    {
        testClass = new InstanceTypeValidator();

        tempDir = new File(System.getProperty("java.io.tmpdir"));
    }

    @After
    public void cleanupTests()
    {
        testClass = null;
    }

    /**
     * Test method for
     * {@link com.bikerunner.instanceview.tools.InstanceTypeValidator#getInstanceType(java.lang.String)}.
     */
    @Test
    public void testGetInstanceTypeNoDirectory() throws Exception
    {
        Assert.assertEquals(InstanceType.NO, testClass.getInstanceType(String.valueOf(System.currentTimeMillis())));
    }

    /**
     * Test method for
     * {@link com.bikerunner.instanceview.tools.InstanceTypeValidator#getInstanceType(java.lang.String)}.
     */
    @Test
    public void testGetInstanceTypeDeveloperDirectory() throws Exception
    {
        long currentTestTime = System.currentTimeMillis();
        File baseDir = new File(tempDir, String.valueOf(currentTestTime));

        File developerDir = new File(baseDir, "developer");
        Assert.assertTrue(developerDir.mkdirs());

        Assert.assertTrue(developerDir.exists());
        
        Assert.assertEquals(InstanceType.DEVELOPER, testClass.getInstanceType(baseDir.getAbsolutePath()));
        
        developerDir.deleteOnExit();
        baseDir.deleteOnExit();
    }

}
