package org.zer0.pocs.java.xpath;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test {

	
	public static void main(String[] args) throws Exception{
		InputStream inputStream=Test.class.getResourceAsStream("/data.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document xmlDocument = builder.parse(inputStream);
		XPath xPath = XPathFactory.newInstance().newXPath();
		String expression = "/Tutorials/Tutorial";
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
		System.out.println(nodeList.item(0).getNextSibling().getChildNodes().item(0).getNodeValue());
	}
	
}
