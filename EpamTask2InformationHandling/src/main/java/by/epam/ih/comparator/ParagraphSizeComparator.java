package by.epam.ih.comparator;

import by.epam.ih.composite.impl.Composite;

import java.util.Comparator;

public class ParagraphSizeComparator implements Comparator<Composite> {
    @Override
    public int compare(Composite o1, Composite o2) {
        return o1.getChild().size() - o2.getChild().size();
    }
}
