# FAQ
____
В чём заключается алгоритм? Аннотируем классы-сущности, чтобы дать понять JAXB, какие поля сопоставляются с элементами из xml-документа.
После `JaxbWorker` десериализует xml-документ методом `unmarshallingBusinessEntityList()`. По условию задачи нужно как-то изменить содержание,
ок. Для этого есть условный `BusinessEntityService`, который что-то там делает с записями (вы же можете придумать любую бизнес-логику). 
И в конце всё дружно сереализуем в новый `JAXBResult` с последующим формированием `html` представлением.
На это всё, всем удачи 😘