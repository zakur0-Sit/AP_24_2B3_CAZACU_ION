package org.example;

import java.lang.reflect.Method;

public class Tester
{
    public static void invokeTestMethods(Class<?> aClass)
    {
        int passed = 0, failed = 0, ignored = 0;

        for (Method method : aClass.getDeclaredMethods())
        {
            if (method.isAnnotationPresent(Test.class) && !method.isAnnotationPresent(Ignore.class))
            {
                if (method.getParameterCount() == 0 && java.lang.reflect.Modifier.isStatic(method.getModifiers()))
                {
                    try
                    {
                        method.invoke(null);
                        passed++;
                    }
                    catch (Throwable ex)
                    {
                        System.out.printf("Test %s failed: %s %n", method, ex.getCause());
                        failed++;
                    }
                }
            }
            else if (method.isAnnotationPresent(Ignore.class))
            {
                ignored++;
                System.out.printf("Test %s ignored %n", method);
            }
        }

        System.out.printf("Passed: %d, Failed: %d, Ignored: %d%n", passed, failed, ignored);
    }

    public static void invokeTestMethodsForClasses(Class<?>... classes)
    {
        for (Class<?> aClass : classes)
        {
            System.out.println("Running tests for class: " + aClass.getName());
            invokeTestMethods(aClass);
        }
    }
}
