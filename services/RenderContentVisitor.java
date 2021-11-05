package services;

import models.*;

import java.util.*;
public class RenderContentVisitor implements Visitor {

    @Override
    public void visitBook(Book book) {
        System.out.print("models.Book: " + book.getTitle() + "\n\n");

        System.out.print("Authors:\n");
        List<Author> authors_ = book.getAuthors();
        for (Author author : authors_)
        {
            System.out.print("Author: " + author.toString() + '\n');
        }

        System.out.println();

        for (Element element : book.getContent())
        {
            System.out.print(element.toString() + '\n');
        }
    }

    @Override
    public void visitSection(Section section) {
        System.out.println("Title: " + section.getTitle());

        for (Element element : section.getContent())
        {
            if (element instanceof Book)
            {
                visitBook((Book)element);
            }
            else if (element instanceof TableOfContents)
            {
                visitTableOfContents((TableOfContents)element);
            }
            else if (element instanceof Paragraph)
            {
                visitParagraph((Paragraph)element);
            }
            else if (element instanceof ImageProxy)
            {
                visitImageProxy((ImageProxy)element);
            }
            else if (element instanceof Image)
            {
                visitImage((Image)element);
            }
            else if (element instanceof Table)
            {
                visitTable((Table)element);
            }
            else if (element instanceof Section)
            {
                ((Section)element).accept(this);
            }
            else
            {
                System.out.print("Element type unknown");
            }

            System.out.println();
        }
    }

    @Override
    public void visitTableOfContents(TableOfContents tableOfContents) {
        System.out.print(tableOfContents.getTitle());
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        System.out.print((new AlignmentStrategyFactory ()).create(paragraph.getAlignStrategy())
                .render("Paragraph: " + paragraph.getText(), new Context(50)));
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        if (imageProxy.getRealImage() == null)
        {
            imageProxy.setRealImage(new Image(imageProxy.getUrl()));
        }

        visitImage(imageProxy.getRealImage());
    }

    @Override
    public void visitImage(Image image) {
       System.out.print("Image with name: " + image.getUrl());
    }

    @Override
    public void visitTable(Table table) {
        System.out.print(table.getTitle());
    }
}
