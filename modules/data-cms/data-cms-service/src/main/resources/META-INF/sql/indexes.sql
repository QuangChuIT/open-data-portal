create index IX_ADD1806E on VNPT_Catalog (groupId);
create index IX_1AC572B0 on VNPT_Catalog (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_836AE532 on VNPT_Catalog (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4030A8CF on VNPT_CatalogFieldName (catalogId);
create index IX_DBCE231F on VNPT_CatalogFieldName (groupId, catalogId, hiddenStatus);
create index IX_B9411355 on VNPT_CatalogFieldName (groupId, catalogId, isSearch);
create index IX_B342E089 on VNPT_CatalogFieldName (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_37EBF54B on VNPT_CatalogFieldName (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4F6CEC5 on VNPT_DicDataType (groupId);
create index IX_62AD5639 on VNPT_DicDataType (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B1D816FB on VNPT_DicDataType (uuid_[$COLUMN_LENGTH:75$], groupId);