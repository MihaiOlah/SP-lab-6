package services;

import services.AlignStrategy;
import models.Context;

public class AlignCenter implements AlignStrategy {
    public String render(String paragraph, Context context)
    {
        StringBuilder alignedContent = new StringBuilder();
        int width = context.getWidth();
        int currentLineLength;

        currentLineLength = 0;
        alignedContent.append('\t');
        for (int i = 0; i < paragraph.length(); i++)
        {
            alignedContent.append(paragraph.charAt(i));
            currentLineLength++;

            if (width == currentLineLength)
            {
                currentLineLength = 0;
                alignedContent.append("\n\t");
            }
        }

        return alignedContent.toString();
    }
}
