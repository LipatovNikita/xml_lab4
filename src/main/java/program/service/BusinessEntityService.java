package program.service;

import bean.BusinessEntity;
import bean.BusinessEntityRegistryStatus;

public class BusinessEntityService {

   public BusinessEntity synchronizeWithFNS(BusinessEntity businessEntity) {
      if (businessEntity.getRegistryStatus().equals(BusinessEntityRegistryStatus.NEW)) {
         businessEntity.setStatus(230);
      }
      return businessEntity;
   }
}
