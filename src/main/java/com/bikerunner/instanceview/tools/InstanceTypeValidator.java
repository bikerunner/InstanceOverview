package com.bikerunner.instanceview.tools;

import java.io.File;

public class InstanceTypeValidator
{
    public InstanceType getInstanceType(String directoryName)
    {
        File directory = new File(directoryName);
        
        if (new File(directory, "developer").exists())
        {
            return InstanceType.DEVELOPER;
        }
        else if (new File(directory, "local").exists())
        {
            return InstanceType.DEPLOYED;
        }
        else
        {
            return InstanceType.NO;
        }
    }
}
