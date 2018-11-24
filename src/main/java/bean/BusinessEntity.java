package bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class BusinessEntity extends GenericEntity {

   @XmlElement(name = "businessEntityName", required = true)
   private String name;

   @XmlElement(name = "businessEntityRegistryStatus")
   private BusinessEntityRegistryStatus registryStatus;

   @XmlElementWrapper(name = "codeOkvedList")
   @XmlElement(name = "codeOkved")
   private List<CodeOkved> codeOkvedList;
}
