package net.huzza;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by zhanhu on 11/11/16.
 */
public class ReadZipFromJar {

    public static void main(String[] args) throws IOException {
        URLClassLoader clsLoader = new URLClassLoader(
                new URL[]{ReadZipFromJar.class.getResource("/test.jar")},
                ReadZipFromJar.class.getClassLoader()
        );


        ZipInputStream zis = new ZipInputStream(clsLoader.getResourceAsStream("test.zip"));
        ZipEntry entry = null;
        while ( (entry = zis.getNextEntry()) != null ) {
            System.out.println(entry.getName());
            System.out.println(IOUtils.toString(zis));
        }
    }
}
