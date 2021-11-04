package services;

import models.Picture;
import models.Element;
import models.Image;

import java.awt.*;
import java.util.Objects;

public class ImageProxy extends Element implements Picture {
    private final String url_;
    private Dimension dim_;
    private Image realImage_;

    public ImageProxy(String url)
    {
        url_ = Objects.requireNonNullElse(url, "");
        dim_ = new Dimension(0, 0);
        realImage_ = null;
    }

    public Image loadImage()
    {
        if (realImage_ == null)
        {
            realImage_ = new Image(url_);
        }

        return realImage_;
    }

    @Override
    public String url()
    {
        return url_;
    }

    @Override
    public Dimension dim()
    {
        return dim_;
    }

    @Override
    public ImageLoader content()
    {
        return realImage_.getContent();
    }

    @Override
    public String toString()
    {
        if (realImage_ == null)
        {
            realImage_ = new Image(url_);
        }

        return realImage_.toString();
    }

    public void print()
    {
        System.out.print(this);
    }

    public boolean add(Element element)
    {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Element element)
    {
        throw new UnsupportedOperationException();
    }

    public Element get(int index)
    {
        throw new UnsupportedOperationException();
    }

    public Element getDocument()
    {
        throw new UnsupportedOperationException();
    }
}
