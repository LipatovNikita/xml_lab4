package program.help;

import bean.BusinessEntityList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;

public class JaxbWorker {

   public BusinessEntityList unmarshallingBusinessEntityList(String xmlFileAbsolutePath) {
      BusinessEntityList businessEntityList = new BusinessEntityList();
      try (FileInputStream fileInputStream = new FileInputStream(xmlFileAbsolutePath)) {
         JAXBContext jaxbContext = JAXBContext.newInstance(BusinessEntityList.class);
         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         businessEntityList = (BusinessEntityList) unmarshaller.unmarshal(fileInputStream);
      } catch (Exception exception) {
         System.err.println("Ошибка при десериализация xml-документа");
         exception.printStackTrace();
      }
      return businessEntityList;
   }

   public JAXBSource marshallingBusinessEntityList(BusinessEntityList businessEntityList) {
      JAXBSource source = null;
      try {
         JAXBContext jaxbContext = JAXBContext.newInstance(BusinessEntityList.class);
         Marshaller marshaller = jaxbContext.createMarshaller();
         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
         source = new JAXBSource(jaxbContext, businessEntityList);
      } catch (Exception exception) {
         System.err.println("Ошибка при сериализация xml-документа");
         exception.printStackTrace();
      }
      return source;
   }

   private Schema getSchema(String xsdFileName) throws SAXException {
      SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      return schemaFactory.newSchema(new File(new FileResolver().getXmlFileAbsolutePath(xsdFileName)));
   }
}
