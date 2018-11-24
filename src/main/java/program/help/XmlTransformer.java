package program.help;

import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XmlTransformer {

   public void transformXmlToHtml(JAXBSource source, String xslFileName) {
      try {
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer(new StreamSource(xslFileName));
         transformer.transform(source, new StreamResult(new File("result.html")));
      } catch (Exception e) {
         System.err.println("Ошибка обработки xml-документа");
         e.printStackTrace();
      }
   }
}
