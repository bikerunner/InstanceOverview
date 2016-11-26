package com.bikerunner.instanceview.tools;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.bikerunner.instanceview.Instance;

public class InstanceFinder
{
    public static List<Instance> findInstances(String directoryName)
    {
        List<Instance> result = Collections.emptyList();
        
        // create directory file object
        File directory = new File(directoryName);
        // check if directory exists and is a directory
        if (directory.exists() && directory.isDirectory())
        {
            File[] files = directory.listFiles();
            List<File> instanceDirs = Arrays.asList(files).stream().filter(s->checkInstance(s)).collect(Collectors.toList());
        }
        
        return result;
    }

    private static boolean checkInstance(File s)
    {
        boolean result = false;
        return result;
    }
}
