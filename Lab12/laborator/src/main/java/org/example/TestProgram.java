package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestProgram
{

    @Test
    public static void testSortList()
    {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        Collections.sort(numbers);
        assert numbers.equals(List.of(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9)) : "List sort test failed";
        System.out.println("List sort test passed");
    }

    @Test
    public static void test()
    {
        throw new RuntimeException("Something went wrong");
    }

    @Test
    @Ignore
    public static void testIgnore()
    {
        int result = 4 * 4;
        assert result == 16 : "Ignore test";
    }

    @Test
    public static void testFailingCondition()
    {
        int x = 5;
        int y = 10;
        assert x + y == 20 : "Failing condition test failed";
    }
}