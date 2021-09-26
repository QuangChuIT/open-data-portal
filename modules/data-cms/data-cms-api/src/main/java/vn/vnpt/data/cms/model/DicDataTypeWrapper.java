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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DicDataType}.
 * </p>
 *
 * @author vnpt
 * @see DicDataType
 * @generated
 */
public class DicDataTypeWrapper
	extends BaseModelWrapper<DicDataType>
	implements DicDataType, ModelWrapper<DicDataType> {

	public DicDataTypeWrapper(DicDataType dicDataType) {
		super(dicDataType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dicDataTypeId", getDicDataTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("length", getLength());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dicDataTypeId = (Long)attributes.get("dicDataTypeId");

		if (dicDataTypeId != null) {
			setDicDataTypeId(dicDataTypeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Integer length = (Integer)attributes.get("length");

		if (length != null) {
			setLength(length);
		}
	}

	/**
	 * Returns the code of this dic data type.
	 *
	 * @return the code of this dic data type
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this dic data type.
	 *
	 * @return the company ID of this dic data type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this dic data type.
	 *
	 * @return the create date of this dic data type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dic data type ID of this dic data type.
	 *
	 * @return the dic data type ID of this dic data type
	 */
	@Override
	public long getDicDataTypeId() {
		return model.getDicDataTypeId();
	}

	/**
	 * Returns the group ID of this dic data type.
	 *
	 * @return the group ID of this dic data type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the length of this dic data type.
	 *
	 * @return the length of this dic data type
	 */
	@Override
	public int getLength() {
		return model.getLength();
	}

	/**
	 * Returns the modified date of this dic data type.
	 *
	 * @return the modified date of this dic data type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this dic data type.
	 *
	 * @return the name of this dic data type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this dic data type.
	 *
	 * @return the primary key of this dic data type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this dic data type.
	 *
	 * @return the status of this dic data type
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this dic data type.
	 *
	 * @return the status by user ID of this dic data type
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this dic data type.
	 *
	 * @return the status by user name of this dic data type
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this dic data type.
	 *
	 * @return the status by user uuid of this dic data type
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this dic data type.
	 *
	 * @return the status date of this dic data type
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this dic data type.
	 *
	 * @return the user ID of this dic data type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this dic data type.
	 *
	 * @return the user name of this dic data type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this dic data type.
	 *
	 * @return the user uuid of this dic data type
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this dic data type.
	 *
	 * @return the uuid of this dic data type
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this dic data type is approved.
	 *
	 * @return <code>true</code> if this dic data type is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this dic data type is denied.
	 *
	 * @return <code>true</code> if this dic data type is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this dic data type is a draft.
	 *
	 * @return <code>true</code> if this dic data type is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this dic data type is expired.
	 *
	 * @return <code>true</code> if this dic data type is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this dic data type is inactive.
	 *
	 * @return <code>true</code> if this dic data type is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this dic data type is incomplete.
	 *
	 * @return <code>true</code> if this dic data type is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this dic data type is pending.
	 *
	 * @return <code>true</code> if this dic data type is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this dic data type is scheduled.
	 *
	 * @return <code>true</code> if this dic data type is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the code of this dic data type.
	 *
	 * @param code the code of this dic data type
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this dic data type.
	 *
	 * @param companyId the company ID of this dic data type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this dic data type.
	 *
	 * @param createDate the create date of this dic data type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dic data type ID of this dic data type.
	 *
	 * @param dicDataTypeId the dic data type ID of this dic data type
	 */
	@Override
	public void setDicDataTypeId(long dicDataTypeId) {
		model.setDicDataTypeId(dicDataTypeId);
	}

	/**
	 * Sets the group ID of this dic data type.
	 *
	 * @param groupId the group ID of this dic data type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the length of this dic data type.
	 *
	 * @param length the length of this dic data type
	 */
	@Override
	public void setLength(int length) {
		model.setLength(length);
	}

	/**
	 * Sets the modified date of this dic data type.
	 *
	 * @param modifiedDate the modified date of this dic data type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this dic data type.
	 *
	 * @param name the name of this dic data type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this dic data type.
	 *
	 * @param primaryKey the primary key of this dic data type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this dic data type.
	 *
	 * @param status the status of this dic data type
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this dic data type.
	 *
	 * @param statusByUserId the status by user ID of this dic data type
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this dic data type.
	 *
	 * @param statusByUserName the status by user name of this dic data type
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this dic data type.
	 *
	 * @param statusByUserUuid the status by user uuid of this dic data type
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this dic data type.
	 *
	 * @param statusDate the status date of this dic data type
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this dic data type.
	 *
	 * @param userId the user ID of this dic data type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this dic data type.
	 *
	 * @param userName the user name of this dic data type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this dic data type.
	 *
	 * @param userUuid the user uuid of this dic data type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this dic data type.
	 *
	 * @param uuid the uuid of this dic data type
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DicDataTypeWrapper wrap(DicDataType dicDataType) {
		return new DicDataTypeWrapper(dicDataType);
	}

}