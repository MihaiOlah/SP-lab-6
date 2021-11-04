package models;

import services.ImageLoader;
import services.ImageLoaderFactory;

import java.awt.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Image extends Element implements Picture, Visitee {
    private final String url_;
    private final ImageLoader content_;

    public Image(String url)
    {
        url_ = Objects.requireNonNullElse(url, "");

        if (url_.toLowerCase().endsWith(".jpg"))
        {
            content_ = (new ImageLoaderFactory()).create("jpg");
        }
        else if(url_.toLowerCase().endsWith("bmp") || url_.toLowerCase().endsWith("dib"))
        {
            content_ = (new ImageLoaderFactory()).create("bmp");
        }
        else
        {
            content_ = null;
        }
    }

    public Image(Image image)
    {
        url_ = image.url_;
        content_ = image.content_;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void PrintImage()
    {

    }

    public ImageLoader getContent()
    {
        return content_;
    }

    @Override
    public String url()
    {
        return url_;
    }

    @Override
    public Dimension dim()
    {
        return new Dimension();
    }

    public ImageLoader content()
    {
        return content_;
    }

    public void display()
    {
        content_.print(url_);
    }

    @Override
    public String toString()
    {
        return "Image with name: " + url_;
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
        visitor.visitImage(this);
    }


}
