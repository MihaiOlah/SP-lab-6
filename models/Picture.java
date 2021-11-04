package models;

import services.ImageLoader;
import java.awt.*;

public interface Picture {
    String url();
    Dimension dim();
    ImageLoader content();
}
