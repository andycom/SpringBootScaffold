package com.fancv.util;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Doc2PdfUtil {

    /**
     * 把doc文档输入流转化为pdf文件的字节数组
     **/
    public static byte[] doc2Pdf(InputStream inputStream) throws Exception {
        //去除掉许可证认证
       /* if (!getLicense()) {
            return null;
        }*/
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        try {
            Document document = new Document(inputStream);
           /* FontSettings fontSettings = FontSettings.getDefaultInstance();
            fontSettings.setFontsFolder("/usr/share/fonts", false);*/
            document.save(bufferedOutputStream, SaveFormat.PDF);
        } finally {
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    //获取通行证，去除水印
    public static boolean getLicense() {
        boolean result = false;
        InputStream inputStream = null;
        try {
            inputStream = Doc2PdfUtil.class.getClassLoader().getResourceAsStream("license/license.xml");
            License asposeLic = new License();
            asposeLic.setLicense(inputStream);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
