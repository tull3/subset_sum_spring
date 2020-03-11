package com.example.demo.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
* No point really in making this a singleton bean managed by Spring, as its usage would be very localized.
* Plus I like immutability, so I tend to avoid setters, even in POJO's, when possible.
*/

final class RangeAddends {
    private LinkedList<Integer> addends;
    private int sum;

    public RangeAddends(final LinkedList<Integer> addends, final int sum) {
        this.addends = addends;
        this.sum = sum;
    }

    public Set<Set<Integer>> calculateAddendsForSum() {
        Set<Set<Integer>> set = new HashSet<>();

        // this is done here rather than setting "set" as an instance variable because lazily calculating
        // data like this is usually good practice to keep memory usage down
        this.generateAddends(this.sum, this.addends, new LinkedList<>(), set);
        
        return set;
    }

    public LinkedList<Integer> getAddends() {
        return this.addends;
    }

    private void generateAddends(
        final int sum,
        final LinkedList<Integer> numbers,
        final LinkedList<Integer> accumulator,
        final Set<Set<Integer>> addends) {

        int s = 0;
        for (int x: accumulator) {
            s += x;
        }
        if (s == sum) {
            addends.add(new HashSet<>(accumulator));
            return;
        }
        for (int i=0; i < numbers.size(); i++) {
            LinkedList<Integer> rest = new LinkedList<Integer>();
            int n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                rest.add(numbers.get(j));
            }
            LinkedList<Integer> partials = new LinkedList<Integer>(accumulator);
            partials.add(n);
            generateAddends(sum, rest, partials, addends);
       }
    }
}