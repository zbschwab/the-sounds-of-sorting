package edu.grinnell.csc207.soundsofsorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;

    Color storm_blue = new Color(39, 86, 107);
    Color jade_green = new Color(38, 113, 88);
    Color midnight_blue = new Color(46, 67, 114);
    Color goldenrod = new Color(170, 145, 57);
    Color[] color_arr = {storm_blue, jade_green, storm_blue, midnight_blue};

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
            int barHeight = this.notes.getNotes()[i] * y_scale;
            if (notes.isHighlighted(i)) {
                g.setColor(goldenrod);
            } else {
                g.setColor(color_arr[i%color_arr.length]);
            }
            g.fillRect(i * bar_width, y_max - barHeight, bar_width - 1, barHeight);
        }
    }
}