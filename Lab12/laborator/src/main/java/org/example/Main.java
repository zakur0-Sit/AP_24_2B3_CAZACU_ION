package org.example;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Main
{
    public static void main(String[] args)
    {
        String[] classPaths = {"src/main/java/org/example/TestProgram.java",};

        try
        {
            for (String classPath : classPaths)
            {
                File file = new File(classPath);
                URL url = file.toURI().toURL();
                URLClassLoader urlLoader = new URLClassLoader(new URL[]{url}, Main.class.getClassLoader());

                String className = classPath.substring(classPath.lastIndexOf("/") + 1, classPath.indexOf(".java"));
                Class<?> aClass = urlLoader.loadClass("org.example." + className);

                Analyzer.displayClassInfo(aClass);
                Tester.invokeTestMethodsForClasses(aClass);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
