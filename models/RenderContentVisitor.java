package models;

import services.ImageProxy;
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
        System.out.print(section);
    }

    @Override
    public void visiTableOfContent(TableOfContents tableOfContents) {
        System.out.print(tableOfContents);
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        System.out.print(paragraph);
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        System.out.print(imageProxy);
    }

    @Override
    public void visitImage(Image image) {
       System.out.println(image);
    }

    @Override
    public void visitTable(Table table) {
        System.out.print(table);
    }
}
