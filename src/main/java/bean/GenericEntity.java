package bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericEntity {

   @XmlElement(name = "id", required = true)
   private String id;

   @XmlElement(name = "status", required = true)
   private int status;

   @XmlElement(name = "createDate", required = true)
   private Date createDate;
}
