package com.fancv.contract;


import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

public class contract {
    /**
     * 创建合同
     *
     * @return
     * @throws Exception
     */
    public static byte[] buildContract(String filename, Map info) throws Exception {


        // 读取word模板文件
        Resource resource = new ClassPathResource("contract/" + filename);
        try (
                InputStream in = resource.getInputStream();
                ByteArrayOutputStream ostream = new ByteArrayOutputStream();
        ) {

            //获取合同数据
            Map<String, String> map = info;

            // word2003
            HWPFDocument doc = new HWPFDocument(in);

            // 替换读取到的word模板内容的指定字段
            Range range = doc.getRange();

            // 替换模版中的数据
            for (Map.Entry<String, String> entry : map.entrySet()) {
                range.replaceText(entry.getKey(), entry.getValue() == null ? "" : entry.getValue());
            }

            // 输出word内容文件流
            doc.write(ostream);

            return ostream.toByteArray();

        } catch (Exception e) {
            throw e;
        }
    }
}
