package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    private final int idx;
    private final T value;

    public CopyEvent(int idx, T value) {
        this.idx = idx;
        this.value = value;
    }

    public void apply(T[] arr) {
        arr[idx] = value;
    }

    public List<Integer> getAffectedIndices() {
        List<Integer> lst = new ArrayList<>();
        lst.add(idx);
        return lst;
    }

    public boolean isEmphasized() {
        return true;
    }
}
