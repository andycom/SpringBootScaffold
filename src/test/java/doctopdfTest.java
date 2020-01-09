import com.fancv.util.Doc2PdfUtil;

import java.io.*;

public class doctopdfTest {

    public static void main(String[] args) {
        try {



            long old = System.currentTimeMillis();


            File file = new File("" +
                    "D:/data/doc2pdf/1.docx");  //新建一个空白pdf文档
            InputStream input = new FileInputStream(file);
            byte[] byt  =  Doc2PdfUtil.doc2Pdf(input);



            File filepdf = new File("D:/data/doc2pdf/1.pdf");

            OutputStream output = new FileOutputStream(filepdf);

            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);

            bufferedOutput.write(byt);
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");  //转化用时
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
