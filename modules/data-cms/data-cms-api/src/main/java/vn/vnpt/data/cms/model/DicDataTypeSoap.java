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
 * This class is used by SOAP remote services, specifically {@link vn.vnpt.data.cms.service.http.DicDataTypeServiceSoap}.
 *
 * @author vnpt
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DicDataTypeSoap implements Serializable {

	public static DicDataTypeSoap toSoapModel(DicDataType model) {
		DicDataTypeSoap soapModel = new DicDataTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDicDataTypeId(model.getDicDataTypeId());
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
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setLength(model.getLength());

		return soapModel;
	}

	public static DicDataTypeSoap[] toSoapModels(DicDataType[] models) {
		DicDataTypeSoap[] soapModels = new DicDataTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DicDataTypeSoap[][] toSoapModels(DicDataType[][] models) {
		DicDataTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DicDataTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DicDataTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DicDataTypeSoap[] toSoapModels(List<DicDataType> models) {
		List<DicDataTypeSoap> soapModels = new ArrayList<DicDataTypeSoap>(
			models.size());

		for (DicDataType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DicDataTypeSoap[soapModels.size()]);
	}

	public DicDataTypeSoap() {
	}

	public long getPrimaryKey() {
		return _dicDataTypeId;
	}

	public void setPrimaryKey(long pk) {
		setDicDataTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDicDataTypeId() {
		return _dicDataTypeId;
	}

	public void setDicDataTypeId(long dicDataTypeId) {
		_dicDataTypeId = dicDataTypeId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public int getLength() {
		return _length;
	}

	public void setLength(int length) {
		_length = length;
	}

	private String _uuid;
	private long _dicDataTypeId;
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
	private String _name;
	private String _code;
	private int _length;

}