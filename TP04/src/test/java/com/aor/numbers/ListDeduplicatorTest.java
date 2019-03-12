package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    private List<Integer> list;

    @Before
    public void setup_test_list() {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(4);
        l.add(2);
        l.add(5);
        list = l;
    }

    @Test
    public void deduplicate() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);

        List<Integer> sorted_list = new ArrayList<>();
        sorted_list.add(1);
        sorted_list.add(2);
        sorted_list.add(4);
        sorted_list.add(5);

        IListSorter sorter_stub = Mockito.mock(IListSorter.class);
        Mockito.when(sorter_stub.sort()).thenReturn(sorted_list);
        List<Integer> distinct = deduplicator.deduplicate(sorter_stub);

        assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_bug() {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(4);
        l.add(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        /*class ListSorterStub implements IListSorter {
            public List<Integer> sort() {
                List<Integer> l = new ArrayList<>();
                l.add(1);
                l.add(2);
                l.add(2);
                l.add(4);
                return l;
            }
        }*/

        List<Integer> sorted_list = new ArrayList<>();
        sorted_list.add(1);
        sorted_list.add(2);
        sorted_list.add(2);
        sorted_list.add(4);

        ListDeduplicator deduplicator = new ListDeduplicator(l);
        IListSorter sorter_stub = Mockito.mock(IListSorter.class);
        Mockito.when(sorter_stub.sort()).thenReturn(sorted_list);
        List<Integer> distinct = deduplicator.deduplicate(sorter_stub);

        assertEquals(expected, distinct);
    }
}