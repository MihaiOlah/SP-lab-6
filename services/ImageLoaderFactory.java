package services;

import services.ImageLoader;

public class ImageLoaderFactory {
    public ImageLoaderFactory()
    {
    }

    public ImageLoader create(String type)
    {
        if (type == null)
        {
            return null;
        }

        if (type.equalsIgnoreCase("jpg"))
        {
            return new JPGImageLoader();
        }
        else if(type.equalsIgnoreCase("bmp") || type.equalsIgnoreCase("dib"))
        {
            return new JPGImageLoader();
        }
        else
        {
            return null;
        }
    }
}
