import com.fancv.contract.contract;
import com.fancv.util.Doc2PdfUtil;
import com.fancv.util.LocalDateUtil;

import java.io.*;
import java.util.HashMap;

public class doctopdfTest {

    public static void main(String[] args) {
        try {


            long old = System.currentTimeMillis();


          /*  File file = new File("" +
                    "D:/data/doc2pdf/ZSZXZLHZXY.doc");  //新建一个空白pdf文档
            InputStream input = new FileInputStream(file);*/
            HashMap re = new HashMap();
            re.put("brand", "武汉加油");
            re.put("mainProduct", "330182199912210254");
            re.put("boothArea", "哈士奇");
            re.put("secondMobile", "335182199912210254");
            re.put("firstContact", "hkkdkd");

            byte[] bytword = contract.buildContract("ZSZXZLHZXY.doc", re);

            InputStream inputword = new ByteArrayInputStream(bytword);

            byte[] byt = Doc2PdfUtil.doc2Pdf(inputword);


            File filepdf = new File("D:/data/doc2pdf/ZSZXZLHZXY" + LocalDateUtil.DateTimeString() + ".pdf");

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
