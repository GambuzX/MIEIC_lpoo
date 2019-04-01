package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class DivisionFilterTest {

    private List<Integer> l1, l2;

    @Before
    public void initialize_lists() {
        l1 = new ArrayList<>();
        l1.add(-1);
        l1.add(-5);
        l1.add(3);
        l1.add(0);
        l1.add(5);
        l1.add(12);

        l2 = new ArrayList<>();
        l2.add(-4);
        l2.add(-4);
        l2.add(1);
        l2.add(1);
        l2.add(5);
        l2.add(-10);
    }

    @Test
    public void division_filter() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(12);

        DivisibleByFilter filter = new DivisibleByFilter(2);

        List<Integer> filtered = new ArrayList<>();
        for (int n : l1)
            if(filter.accept(n))
                filtered.add(n);

        assertEquals(expected, filtered);
    }



    @Test
    public void division_filter2() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(-10);

        DivisibleByFilter filter = new DivisibleByFilter(5);

        List<Integer> filtered = new ArrayList<>();
        for (int n : l2)
            if(filter.accept(n))
                filtered.add(n);

        assertEquals(expected, filtered);
    }
}
