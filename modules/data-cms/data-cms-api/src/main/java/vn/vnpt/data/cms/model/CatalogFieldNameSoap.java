/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.vnpt.data.cms.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.vnpt.data.cms.service.http.CatalogFieldNameServiceSoap}.
 *
 * @author vnpt
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CatalogFieldNameSoap implements Serializable {

	public static CatalogFieldNameSoap toSoapModel(CatalogFieldName model) {
		CatalogFieldNameSoap soapModel = new CatalogFieldNameSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEntryId(model.getEntryId());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());
		soapModel.setDataType(model.getDataType());
		soapModel.setFormat(model.getFormat());
		soapModel.setDefaultValue(model.getDefaultValue());
		soapModel.setNotNull(model.isNotNull());
		soapModel.setHiddenStatus(model.isHiddenStatus());
		soapModel.setIsSearch(model.isIsSearch());
		soapModel.setCatalogId(model.getCatalogId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static CatalogFieldNameSoap[] toSoapModels(
		CatalogFieldName[] models) {

		CatalogFieldNameSoap[] soapModels =
			new CatalogFieldNameSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CatalogFieldNameSoap[][] toSoapModels(
		CatalogFieldName[][] models) {

		CatalogFieldNameSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CatalogFieldNameSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CatalogFieldNameSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CatalogFieldNameSoap[] toSoapModels(
		List<CatalogFieldName> models) {

		List<CatalogFieldNameSoap> soapModels =
			new ArrayList<CatalogFieldNameSoap>(models.size());

		for (CatalogFieldName model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CatalogFieldNameSoap[soapModels.size()]);
	}

	public CatalogFieldNameSoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDataType() {
		return _dataType;
	}

	public void setDataType(String dataType) {
		_dataType = dataType;
	}

	public String getFormat() {
		return _format;
	}

	public void setFormat(String format) {
		_format = format;
	}

	public String getDefaultValue() {
		return _defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		_defaultValue = defaultValue;
	}

	public boolean getNotNull() {
		return _notNull;
	}

	public boolean isNotNull() {
		return _notNull;
	}

	public void setNotNull(boolean notNull) {
		_notNull = notNull;
	}

	public boolean getHiddenStatus() {
		return _hiddenStatus;
	}

	public boolean isHiddenStatus() {
		return _hiddenStatus;
	}

	public void setHiddenStatus(boolean hiddenStatus) {
		_hiddenStatus = hiddenStatus;
	}

	public boolean getIsSearch() {
		return _isSearch;
	}

	public boolean isIsSearch() {
		return _isSearch;
	}

	public void setIsSearch(boolean isSearch) {
		_isSearch = isSearch;
	}

	public long getCatalogId() {
		return _catalogId;
	}

	public void setCatalogId(long catalogId) {
		_catalogId = catalogId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private String _uuid;
	private long _entryId;
	private String _code;
	private String _name;
	private String _dataType;
	private String _format;
	private String _defaultValue;
	private boolean _notNull;
	private boolean _hiddenStatus;
	private boolean _isSearch;
	private long _catalogId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

}