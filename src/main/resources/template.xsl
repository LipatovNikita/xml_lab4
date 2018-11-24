<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
   <xsl:output method="html" encoding="UTF-8" version="5.2" indent="yes" />
   <xsl:template match="/">
      <html>
         <xsl:call-template name="head" />
         <body>
            <table class="result-table">
               <thead>
                  <tr>
                     <th>Номер</th>
                     <th>Идентификатор</th>
                     <th>Статус записи</th>
                     <th>Наименование</th>
                     <th>Статус в реестре</th>
                     <th>Дата создания</th>
                     <th>Коды ОКВЭД</th>
                     <th>Синхронизация с ФНС</th>
                  </tr>
               </thead>
               <tbody>
                  <xsl:for-each select="businessEntityList/businessEntity">
                     <xsl:sort select="status" order="descending"/>
                     <tr>
                        <th><xsl:number value="position()" format="1"/></th>
                        <th><xsl:value-of select="id"/></th>
                        <th><xsl:value-of select="status"/></th>
                        <th><xsl:value-of select="businessEntityName"/></th>
                        <th><xsl:value-of select="businessEntityRegistryStatus"/></th>
                        <th><xsl:value-of select="createDate"/></th>
                        <th>
                           <xsl:for-each select="codeOkvedList/codeOkved">
                              <xsl:value-of select="code"/>;
                           </xsl:for-each>
                        </th>
                        <th>
                           <xsl:choose>
                              <xsl:when test="status = 230">
                                 Да
                              </xsl:when>
                              <xsl:otherwise>
                                 Нет
                              </xsl:otherwise>
                           </xsl:choose>
                        </th>
                     </tr>
                  </xsl:for-each>
               </tbody>
               <tfoot>
                  <tr>
                     <td>Итого:</td>
                     <td colspan="7"><xsl:value-of select="count(businessEntityList/businessEntity)"/></td>
                  </tr>
               </tfoot>
            </table>
         </body>
      </html>
   </xsl:template>

   <xsl:template name="head">
      <head>
         <link rel="stylesheet" href="styles.css"/>
      </head>
   </xsl:template>
</xsl:stylesheet>
