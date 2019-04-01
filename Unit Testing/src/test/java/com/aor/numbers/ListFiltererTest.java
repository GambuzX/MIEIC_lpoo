package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.*;

public class ListFiltererTest {

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
    public void positive_filter() {
        ListFilterer filter = new ListFilterer(l1);

        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);
        expected.add(12);

        IListFilter stub_filter = Mockito.mock(IListFilter.class);
        Mockito.when(stub_filter.accept(any(Integer.class))).thenReturn(false);
        Mockito.when(stub_filter.accept(3)).thenReturn(true);
        Mockito.when(stub_filter.accept(5)).thenReturn(true);
        Mockito.when(stub_filter.accept(12)).thenReturn(true);

        List<Integer> filtered = filter.filter(stub_filter);

        assertEquals(expected, filtered);
    }

    @Test
    public void positive_filter2() {
        ListFilterer filter = new ListFilterer(l2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(5);

        IListFilter stub_filter = Mockito.mock(IListFilter.class);
        Mockito.when(stub_filter.accept(any(Integer.class))).thenReturn(false);
        Mockito.when(stub_filter.accept(1)).thenReturn(true);
        Mockito.when(stub_filter.accept(5)).thenReturn(true);

        List<Integer> filtered = filter.filter(stub_filter);

        assertEquals(expected, filtered);
    }

    @Test
    public void division_filter() {
        ListFilterer filter = new ListFilterer(l1);

        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(12);

        // fake division by 1
        IListFilter stub_filter = Mockito.mock(IListFilter.class);
        Mockito.when(stub_filter.accept(any(Integer.class))).thenReturn(false);
        Mockito.when(stub_filter.accept(0)).thenReturn(true);
        Mockito.when(stub_filter.accept(12)).thenReturn(true);

        List<Integer> filtered = filter.filter(stub_filter);

        assertEquals(expected, filtered);
    }

    @Test
    public void division_filter2() {
        ListFilterer filter = new ListFilterer(l2);

        List<Integer> expected = new ArrayList<>();
        expected.add(-4);
        expected.add(-4);
        expected.add(1);
        expected.add(1);
        expected.add(5);
        expected.add(-10);

        // fake division by 2
        IListFilter stub_filter = Mockito.mock(IListFilter.class);
        Mockito.when(stub_filter.accept(any(Integer.class))).thenReturn(true);

        List<Integer> filtered = filter.filter(stub_filter);

        assertEquals(expected, filtered);
    }
}
