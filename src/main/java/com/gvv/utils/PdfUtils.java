package com.gvv.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class PdfUtils {

    public static void pdfOut(Map<String, Object> o) {
        String templatePath = "/pdf_templates/certificate_template.pdf";

        File directory = new File("");

        String newPdfPath = directory.getAbsolutePath() + "/certificate.pdf";

        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        Document doc = new Document();

        try {
            out = new FileOutputStream(newPdfPath);// 输出流
            bos = new ByteArrayOutputStream();
            reader = new PdfReader(templatePath);// 读取pdf模板

            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            //文字类的内容处理
            Map<String, String> map = (Map<String, String>) o.get("map");
            //form.addSubstitutionFont(bf);
            for (String key : map.keySet()) {
                String value = map.get(key);
                form.setField(key, value);
            }
            stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
            stamper.close();


            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            copy.addDocument(new PdfReader(bos.toByteArray()));
            doc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
