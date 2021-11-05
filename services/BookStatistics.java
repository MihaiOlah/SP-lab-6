package services;

import models.*;

public class BookStatistics implements Visitor {
    private int numberOfImages_;
    private int numberOfTables_;
    private int numberOfParagraphs_;

    public BookStatistics()
    {
        numberOfImages_ = numberOfTables_ = numberOfParagraphs_ = 0;
    }

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + numberOfImages_);
        System.out.println("*** Number of tables: " + numberOfTables_);
        System.out.println("*** Number of paragraphs: " + numberOfParagraphs_);
    }

    @Override
    public void visitBook(Book book) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visitSection(Section section) {
        numberOfImages_ = numberOfTables_ = numberOfParagraphs_ = 0;

        for (Element element : section.getContent())
        {
            if (element instanceof Image || element instanceof ImageProxy)
            {
                numberOfImages_++;
            }
            else if (element instanceof Paragraph)
            {
                numberOfParagraphs_++;
            }
            else if (element instanceof Table || element instanceof TableOfContents)
            {
                numberOfTables_++;
            }
            else if (element instanceof Section)
            {
                ((Section)element).accept(this);
            }
        }
    }

    @Override
    public void visitTableOfContents(TableOfContents tableOfContents) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visitImage(Image image) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visitTable(Table table) {
        throw new UnsupportedOperationException();
    }
}
