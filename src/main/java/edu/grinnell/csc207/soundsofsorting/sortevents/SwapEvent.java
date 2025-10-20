package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    private final int i, j;

    public SwapEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public void apply(T[] arr) {
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        List<Integer> lst = new ArrayList<>();
        lst.add(i);
        lst.add(j);
        return lst;
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
}
