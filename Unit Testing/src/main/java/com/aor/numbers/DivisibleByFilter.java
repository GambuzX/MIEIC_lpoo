package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {
    private final int num;

    public DivisibleByFilter(int num) {
        this.num = num;
    }

    @Override
    public boolean accept(Integer number) {
        return number % num == 0;
    }
}
