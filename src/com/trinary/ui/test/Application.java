package com.trinary.ui.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import com.trinary.ui.layout.ElementLayout;
import com.trinary.ui.layout.Margins;

public class Application {

	public static void main(String[] args) throws PropertyException {
		// Create objects
		ElementLayout root = new ElementLayout(
				"com.trinary.ui.elements.ContainerElement", 
				"top: 0px, left: 0px", 
				"500px", "500px", 
				0, 
				"_black");
		ElementLayout textBox = new ElementLayout(
				"com.trinary.ui.elements.FormattedTextElement", 
				"bottom: 100%, left: 0px", 
				"50%", "100%", 
				1, 
				"textbox");
		ElementLayout choiceModal = new ElementLayout(
				"com.trinary.ui.elements.ChoiceBox", 
				"top: 0px, left: 0px", 
				"50%", "100%", 
				9999,
				"choice-modal");
		
		root.setId("container");
		
		textBox.setId("text-box");
		textBox.setMargins(new Margins("10px", "20px"));
		
		choiceModal.setId("choice-modal");
		choiceModal.setMargins(new Margins("10px", "20px"));
		
		root.addChild(textBox);
		root.addChild(choiceModal);
		
		// Marshall to xml
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(ElementLayout.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Marshaller jaxbMarshaller = null;
		try {
			jaxbMarshaller = jaxbContext.createMarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 		try {
			jaxbMarshaller.marshal(root, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
