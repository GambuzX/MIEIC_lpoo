package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;

public class ListAggregatorTest {

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
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void max2() {
        List<Integer> l = new ArrayList();
        l.add(-1);
        l.add(-4);
        l.add(-5);

        ListAggregator aggregator = new ListAggregator(l);
        int max = aggregator.max();

        assertEquals(-1, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        /*class DeduplicatorStub implements IListDeduplicator {
            public List<Integer> deduplicate(IListSorter list_sorter) {
                List<Integer> ret = new ArrayList();
                ret.add(1);
                ret.add(2);
                ret.add(4);
                ret.add(5);
                return ret;
            }
        }*/
        ListAggregator aggregator = new ListAggregator(list);

        List<Integer> deduplicated = new ArrayList<>();
        deduplicated.add(1);
        deduplicated.add(2);
        deduplicated.add(4);
        deduplicated.add(5);

        IListDeduplicator deduplicator_stub = Mockito.mock(IListDeduplicator.class);
        Mockito.when(deduplicator_stub.deduplicate(any(IListSorter.class))).thenReturn(deduplicated);
        int distinct = aggregator.distinct(deduplicator_stub);

        assertEquals(4, distinct);
    }

    @Test
    public void distinct2() {
        List<Integer> l = new ArrayList();
        l.add(1);
        l.add(2);
        l.add(4);
        l.add(2);

        /*class DeduplicatorStub implements IListDeduplicator {
            public List<Integer> deduplicate(IListSorter list_sorter) {
                List<Integer> ret = new ArrayList();
                ret.add(1);
                ret.add(2);
                ret.add(4);
                return ret;
            }
        }*/

        ListAggregator aggregator = new ListAggregator(l);

        List<Integer> deduplicated = new ArrayList<>();
        deduplicated.add(1);
        deduplicated.add(2);
        deduplicated.add(4);

        IListDeduplicator deduplicator_stub = Mockito.mock(IListDeduplicator.class);
        Mockito.when(deduplicator_stub.deduplicate(any(IListSorter.class))).thenReturn(deduplicated);
        int distinct = aggregator.distinct(deduplicator_stub);

        assertEquals(3, distinct);
    }
}