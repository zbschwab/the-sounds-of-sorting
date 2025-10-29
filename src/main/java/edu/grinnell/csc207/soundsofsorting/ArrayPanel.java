package edu.grinnell.csc207.soundsofsorting;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;

    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * 
     * @param notes  the note indices
     * @param width  the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        int sz = this.notes.getNotes().length;
        int y_max = getHeight();
        int bar_width = y_max / sz;
        int y_scale = getHeight() / 12;

        for (int i = 0; i < sz; i++) {
            g.drawRect(i*bar_width, y_max-this.notes.getNotes()[i]*y_scale, (i+1)*bar_width, y_max);
        }
        // y = 12
        // int arr = import java.util.stream.max();
        //(this.notes.getNotes()).max(Integer::compare);
        //int arr_max = (int)java.util.Collections.max(this.notes.getNotes());

        // int max = max(this.notes.getNotes());
        // int max = 30;
        // int xscale = getWidth() / sz;
        // int yscale = getHeight() / max;
        // for (int i = 0; i < sz; i++) {
        //     // how do i get sort alg results height?
        //     g.drawRect(i * xscale, getHeight(), (i + 1) * xscale, getHeight() - this.notes);
        // }
    }
}