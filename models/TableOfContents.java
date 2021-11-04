package models;

import java.util.Objects;

public class TableOfContents extends Element implements Visitee {
    private final String title_;

    public TableOfContents(String title)
    {
        title_ = Objects.requireNonNullElse(title, "");
    }

    public TableOfContents(TableOfContents tableOfContents)
    {
        title_ = tableOfContents.title_;
    }

    @Override
    public String toString()
    {
        return title_;
    }

    @Override
    public void print()
    {
        System.out.print(this);
    }

    @Override
    public boolean add(Element element)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public boolean remove(Element element)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public Element get(int index)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public void accept(Visitor visitor) {
        visitor.visiTableOfContent(this);
    }
}
