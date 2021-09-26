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
 * This class is used by SOAP remote services, specifically {@link vn.vnpt.data.cms.service.http.CatalogServiceSoap}.
 *
 * @author vnpt
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CatalogSoap implements Serializable {

	public static CatalogSoap toSoapModel(Catalog model) {
		CatalogSoap soapModel = new CatalogSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCatalogId(model.getCatalogId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTableName(model.getTableName());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setVersion(model.getVersion());
		soapModel.setVisibility(model.isVisibility());
		soapModel.setCatType(model.getCatType());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static CatalogSoap[] toSoapModels(Catalog[] models) {
		CatalogSoap[] soapModels = new CatalogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CatalogSoap[][] toSoapModels(Catalog[][] models) {
		CatalogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CatalogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CatalogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CatalogSoap[] toSoapModels(List<Catalog> models) {
		List<CatalogSoap> soapModels = new ArrayList<CatalogSoap>(
			models.size());

		for (Catalog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CatalogSoap[soapModels.size()]);
	}

	public CatalogSoap() {
	}

	public long getPrimaryKey() {
		return _catalogId;
	}

	public void setPrimaryKey(long pk) {
		setCatalogId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
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

	public String getTableName() {
		return _tableName;
	}

	public void setTableName(String tableName) {
		_tableName = tableName;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public boolean getVisibility() {
		return _visibility;
	}

	public boolean isVisibility() {
		return _visibility;
	}

	public void setVisibility(boolean visibility) {
		_visibility = visibility;
	}

	public int getCatType() {
		return _catType;
	}

	public void setCatType(int catType) {
		_catType = catType;
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
	private long _catalogId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _tableName;
	private String _title;
	private String _description;
	private String _version;
	private boolean _visibility;
	private int _catType;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

}