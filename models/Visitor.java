package models;

import services.ImageProxy;

public interface Visitor {
    void visitBook(Book book);
    void visitSection(Section section) ;
    void visiTableOfContent(TableOfContents tableOfContents);
    void visitParagraph(Paragraph paragraph);
    void visitImageProxy(ImageProxy imageProxy);
    void visitImage(Image image);
    void visitTable(Table table);
}
