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

package vn.vnpt.data.cms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import vn.vnpt.data.cms.model.CatalogFieldName;

/**
 * The cache model class for representing CatalogFieldName in entity cache.
 *
 * @author vnpt
 * @generated
 */
public class CatalogFieldNameCacheModel
	implements CacheModel<CatalogFieldName>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CatalogFieldNameCacheModel)) {
			return false;
		}

		CatalogFieldNameCacheModel catalogFieldNameCacheModel =
			(CatalogFieldNameCacheModel)object;

		if (entryId == catalogFieldNameCacheModel.entryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, entryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entryId=");
		sb.append(entryId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append(", dataType=");
		sb.append(dataType);
		sb.append(", format=");
		sb.append(format);
		sb.append(", defaultValue=");
		sb.append(defaultValue);
		sb.append(", notNull=");
		sb.append(notNull);
		sb.append(", hiddenStatus=");
		sb.append(hiddenStatus);
		sb.append(", isSearch=");
		sb.append(isSearch);
		sb.append(", catalogId=");
		sb.append(catalogId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CatalogFieldName toEntityModel() {
		CatalogFieldNameImpl catalogFieldNameImpl = new CatalogFieldNameImpl();

		if (uuid == null) {
			catalogFieldNameImpl.setUuid("");
		}
		else {
			catalogFieldNameImpl.setUuid(uuid);
		}

		catalogFieldNameImpl.setEntryId(entryId);

		if (code == null) {
			catalogFieldNameImpl.setCode("");
		}
		else {
			catalogFieldNameImpl.setCode(code);
		}

		if (name == null) {
			catalogFieldNameImpl.setName("");
		}
		else {
			catalogFieldNameImpl.setName(name);
		}

		if (dataType == null) {
			catalogFieldNameImpl.setDataType("");
		}
		else {
			catalogFieldNameImpl.setDataType(dataType);
		}

		if (format == null) {
			catalogFieldNameImpl.setFormat("");
		}
		else {
			catalogFieldNameImpl.setFormat(format);
		}

		if (defaultValue == null) {
			catalogFieldNameImpl.setDefaultValue("");
		}
		else {
			catalogFieldNameImpl.setDefaultValue(defaultValue);
		}

		catalogFieldNameImpl.setNotNull(notNull);
		catalogFieldNameImpl.setHiddenStatus(hiddenStatus);
		catalogFieldNameImpl.setIsSearch(isSearch);
		catalogFieldNameImpl.setCatalogId(catalogId);
		catalogFieldNameImpl.setGroupId(groupId);
		catalogFieldNameImpl.setCompanyId(companyId);
		catalogFieldNameImpl.setUserId(userId);

		if (userName == null) {
			catalogFieldNameImpl.setUserName("");
		}
		else {
			catalogFieldNameImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			catalogFieldNameImpl.setCreateDate(null);
		}
		else {
			catalogFieldNameImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			catalogFieldNameImpl.setModifiedDate(null);
		}
		else {
			catalogFieldNameImpl.setModifiedDate(new Date(modifiedDate));
		}

		catalogFieldNameImpl.setStatus(status);
		catalogFieldNameImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			catalogFieldNameImpl.setStatusByUserName("");
		}
		else {
			catalogFieldNameImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			catalogFieldNameImpl.setStatusDate(null);
		}
		else {
			catalogFieldNameImpl.setStatusDate(new Date(statusDate));
		}

		catalogFieldNameImpl.resetOriginalValues();

		return catalogFieldNameImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		entryId = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();
		dataType = objectInput.readUTF();
		format = objectInput.readUTF();
		defaultValue = objectInput.readUTF();

		notNull = objectInput.readBoolean();

		hiddenStatus = objectInput.readBoolean();

		isSearch = objectInput.readBoolean();

		catalogId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(entryId);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (dataType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataType);
		}

		if (format == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(format);
		}

		if (defaultValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(defaultValue);
		}

		objectOutput.writeBoolean(notNull);

		objectOutput.writeBoolean(hiddenStatus);

		objectOutput.writeBoolean(isSearch);

		objectOutput.writeLong(catalogId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long entryId;
	public String code;
	public String name;
	public String dataType;
	public String format;
	public String defaultValue;
	public boolean notNull;
	public boolean hiddenStatus;
	public boolean isSearch;
	public long catalogId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}