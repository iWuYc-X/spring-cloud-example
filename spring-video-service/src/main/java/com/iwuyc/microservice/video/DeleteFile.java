package com.iwuyc.microservice.video;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DeleteFile
{
    private static final String FILE = "I:\\Download\\Vedios\\170420-韩国成人生理教育节目真人示范讲解然后在实战啪啪啪-19\\裸聊直播,可以指揮潮吹表演 YYAA2.COM.mp4";

    public static void main(String[] args) throws Exception
    {
        File file = new File(FILE);
        file.delete();
        System.out.println(file.exists());
        // FileOutputStream out = new FileOutputStream(file);
        // out.write(new byte[] { 0 }, 0, 1);
        // out.close();
    }
}
