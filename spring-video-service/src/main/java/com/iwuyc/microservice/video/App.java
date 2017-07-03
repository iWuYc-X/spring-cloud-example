package com.iwuyc.microservice.video;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Hello world!
 *
 */
public class App
{
    private static final String TARGET_DIR = "K:\\Download\\others";

    public static void main(String[] args) throws Exception
    {
        PrivilegedAction<Void> action = new PrivilegedAction<Void>()
        {

            @Override
            public Void run()
            {
                File sourceFile = new File("H:\\Download");
                try
                {
                    Path newParentPath = Paths.get(newParentPath(sourceFile).toString(), sourceFile.getName());

                    dir(sourceFile, newParentPath);
                    System.out.println("Hello world;");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                return null;
            }
        };
        AccessController.<Void>doPrivileged(action);
        // new Scanner(System.in).nextLine();
        return;
    }

    public static void dir(File file, Path newParentPath) throws Exception
    {
        File newDir = newParentPath.toFile();
        if (!newDir.exists())
        {
            newDir.mkdirs();
        }
        File info = new File(newParentPath + "\\info.txt");
        if (!info.exists())
        {
            info.createNewFile();
        }
        try (FileWriter write = new FileWriter(info); PrintWriter w = new PrintWriter(write);)
        {

            File[] files = file.listFiles();
            int count = 0;
            Path targerPath = null;
            for (File item : files)
            {
                w.println(count + " = " + item.getName());
                write.flush();
                if (item.isDirectory())
                {
                    Path newDirPath = Paths.get(newParentPath + "\\" + count);

                    try
                    {
                        dir(item, newDirPath);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    targerPath = Paths.get(newParentPath.toString(), count + ".tmp");
                    turn(item, targerPath);
                }
                count++;
            }
        }
        System.out.println("finish:" + file.getAbsolutePath());
    }

    public static File turn(File file, Path targetPath) throws Exception
    {
        File newFile = targetPath.toFile();
        File parentDir = newFile.getParentFile();
        if (!parentDir.exists())
        {
            parentDir.mkdirs();
        }
        else if (newFile.exists())
        {
            return newFile;
        }
        try (FileInputStream in = new FileInputStream(file); FileOutputStream out = new FileOutputStream(newFile))
        {
            byte[] readbytes = new byte[2048];
            int readLength = 0;
            int count = 0;
            while ((readLength = in.read(readbytes)) != -1)
            {
                mask(readbytes, readLength);
                out.write(readbytes, 0, readLength);
                if (count >= 8)
                {
                    out.flush();
                    count = 0;
                }
                count++;
            }
            out.flush();
        }
        return newFile;
    }

    public static void mask(byte[] bytes, int readLength)
    {
        for (int i = 0; i < readLength; i++)
        {
            bytes[i] = (byte) (bytes[i] ^ 0xff);
        }
    }

    public static String reductPath(File file, String newName)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(newParentPath(file).toString()).append("//").append(newName).append(".tmp");
        return sb.toString();
    }

    private static Path newParentPath(File file)
    {
        return file.toPath().subpath(0, file.toPath().getNameCount()).getParent() == null ? Paths.get(TARGET_DIR)
                : Paths.get(TARGET_DIR, file.toPath().subpath(0, file.toPath().getNameCount()).getParent().toString());
    }
}
