package models;

import services.AlignLeft;
import services.AlignStrategy;

import java.util.Objects;

public class Paragraph extends Element implements Visitee {
    private String text_;
    private AlignStrategy alignStrategy_;

    public Paragraph(String text)
    {
        text_ = Objects.requireNonNullElse(text, "");
        alignStrategy_ = new AlignLeft();
    }

    public Paragraph(Paragraph paragraph)
    {
        text_ = paragraph.text_;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy)
    {
        alignStrategy_ = alignStrategy;
    }

    public String getText()
    {
        return text_;
    }

    public void setText(String text)
    {
        text_ = text;
    }

    @Override
    public String toString()
    {
        return alignStrategy_.render("Paragraph: " + text_, new Context(50));
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
        visitor.visitParagraph(this);
    }
}
