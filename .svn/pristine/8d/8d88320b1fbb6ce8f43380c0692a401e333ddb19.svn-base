package com.orgz.utils;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 






import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
 






import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ParserXmlUtils {
	private static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	private static XPathFactory f = XPathFactory.newInstance();

    private static DocumentBuilder dbd;
    public static Document getDocument(String content) {
    	Document doc = null;
    	try {
			dbd = dbf.newDocumentBuilder();
			//注意这里在从String转byte时，做好是指定编码
			InputStream is = new ByteArrayInputStream(content.getBytes("utf-8"));
//			InputStream is = new FileInputStream("src/sms.xml");
			doc = dbd.parse(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return doc;
    	
    }
    
    public static String getString(String name, String document) throws XPathExpressionException {
    	String result = null;
    	String basePath = "returnsms/";
        XPath path = f.newXPath();
        Document doc = getDocument(document);
        Node node = (Node) path.evaluate(basePath+name, doc, XPathConstants.NODE);
        result = node.getTextContent();
    	return result;
    }
    
//    public static void main(String[] args) throws Exception { 
//    	System.out.println(getString("returnstatus",""));
//     }
}
