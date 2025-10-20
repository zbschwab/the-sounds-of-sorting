package edu.grinnell.csc207.soundsofsorting;

import java.util.Arrays;
import java.util.Random;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    private Integer[] indices;
    private boolean[] highlighted;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        this.indices = new Integer[n];
        this.highlighted = new boolean[n];
    }
    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        for (int i = 0; i < n; i++) { 
            this.indices[i] = i;
        }

        // shuffle arr in place with durstenfeld's fisher yates algorithm
        for (int i = 6; i > 0; i--) {
            Random rand = new Random();
            int j = rand.nextInt(i+1);
            Integer temp = this.indices[i];
            this.indices[i] = this.indices[j];
            this.indices[j] = temp;
        }
        
        Arrays.fill(this.highlighted, false);
    }

    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        return this.indices;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        this.highlighted[index] = true;
    }
    
    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        return this.highlighted[index];
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        Arrays.fill(this.highlighted, false);
    }
}
