import com.fancv.contract.contract;
import com.fancv.util.Doc2PdfUtil;

import java.io.*;
import java.util.HashMap;

public class doctopdfTest {

    public static void main(String[] args) {
        try {



            long old = System.currentTimeMillis();


            File file = new File("" +
                    "D:/data/doc2pdf/1.docx");  //新建一个空白pdf文档
            InputStream input = new FileInputStream(file);
            HashMap re=new HashMap();
            re.put("{1}","武汉加油");
            re.put("{2}","330182199912210254");
            re.put("{3}","哈士奇");
            re.put("{4}","335182199912210254");
            re.put("{5}","hkkdkd");

            byte[] bytword=  contract.buildContract("HT.doc",re);

            InputStream inputword = new ByteArrayInputStream(bytword);

            byte[] byt  =  Doc2PdfUtil.doc2Pdf(inputword);



            File filepdf = new File("D:/data/doc2pdf/result.pdf");

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
