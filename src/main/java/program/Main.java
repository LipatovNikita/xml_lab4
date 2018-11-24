package program;

import bean.BusinessEntityList;
import program.help.FileResolver;
import program.help.JaxbWorker;
import program.help.XmlTransformer;
import program.service.BusinessEntityService;

public class Main {
   public static void main(String[] args) {
      BusinessEntityService businessEntityService = new BusinessEntityService();
      FileResolver fileResolver = new FileResolver();
      JaxbWorker jaxbWorker = new JaxbWorker();
      XmlTransformer xmlTransformer = new XmlTransformer();

      BusinessEntityList businessEntityList = jaxbWorker.unmarshallingBusinessEntityList(fileResolver.getXmlFileAbsolutePath("businessEntityList.xml"));
      if (!businessEntityList.getBusinessEntities().isEmpty()) {
         businessEntityList.getBusinessEntities().forEach(businessEntityService::synchronizeWithFNS);
        xmlTransformer.transformXmlToHtml(jaxbWorker.marshallingBusinessEntityList(businessEntityList), fileResolver.getXmlFileAbsolutePath("template.xsl"));
      }
   }
}
