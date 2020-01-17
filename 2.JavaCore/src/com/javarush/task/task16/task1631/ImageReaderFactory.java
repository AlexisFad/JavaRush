package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
     static ImageReader image = null;

        public static ImageReader getImageReader (ImageTypes s){
            try{
        if (s.toString().equals(ImageTypes.JPG.toString())) {
            image = new JpgReader();
        } else if (s.toString().equals(ImageTypes.BMP.toString())) {
            image = new BmpReader();
        } else if (s.toString().equals(ImageTypes.PNG.toString())) {
            image = new PngReader();
        } else
            throw new IllegalArgumentException("Неизвестный тип картинки");

        return image;

    } catch(Exception e){
                throw new IllegalArgumentException("Неизвестный тип картинки");
            }
    }
}

