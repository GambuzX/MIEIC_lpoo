package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private final List<Integer> list;

    public ListFilterer(List<Integer> l) {
        list = l;
    }

    public List<Integer> filter(IListFilter filter) {
        List<Integer> filtered = new ArrayList<>();

        for (int n : list)
            if (filter.accept(n))
                filtered.add(n);

        return filtered;
    }
}
