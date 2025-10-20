package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T> {
    private final int i, j;

    public CompareEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public void apply(T[] arr) {}

    @Override
    public List<Integer> getAffectedIndices() {
        List<Integer> lst = new ArrayList<>();
        lst.add(i);
        lst.add(j);
        return lst;
    }

    @Override
    public boolean isEmphasized() {
        return false;
    }
}
