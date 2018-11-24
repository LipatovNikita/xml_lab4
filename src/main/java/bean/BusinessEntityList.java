package bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "businessEntityList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BusinessEntityList {

   @XmlElement(name = "businessEntity")
   private List<BusinessEntity> businessEntities;
}
