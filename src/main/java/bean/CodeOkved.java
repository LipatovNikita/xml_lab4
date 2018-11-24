package bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlType(name = "CodeOkved")
public class CodeOkved extends GenericEntity {

   @XmlElement(name = "code")
   private String code;
}
