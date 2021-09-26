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

import vn.vnpt.data.cms.model.DicDataType;

/**
 * The cache model class for representing DicDataType in entity cache.
 *
 * @author vnpt
 * @generated
 */
public class DicDataTypeCacheModel
	implements CacheModel<DicDataType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DicDataTypeCacheModel)) {
			return false;
		}

		DicDataTypeCacheModel dicDataTypeCacheModel =
			(DicDataTypeCacheModel)object;

		if (dicDataTypeId == dicDataTypeCacheModel.dicDataTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dicDataTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dicDataTypeId=");
		sb.append(dicDataTypeId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append(", length=");
		sb.append(length);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DicDataType toEntityModel() {
		DicDataTypeImpl dicDataTypeImpl = new DicDataTypeImpl();

		if (uuid == null) {
			dicDataTypeImpl.setUuid("");
		}
		else {
			dicDataTypeImpl.setUuid(uuid);
		}

		dicDataTypeImpl.setDicDataTypeId(dicDataTypeId);
		dicDataTypeImpl.setGroupId(groupId);
		dicDataTypeImpl.setCompanyId(companyId);
		dicDataTypeImpl.setUserId(userId);

		if (userName == null) {
			dicDataTypeImpl.setUserName("");
		}
		else {
			dicDataTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dicDataTypeImpl.setCreateDate(null);
		}
		else {
			dicDataTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dicDataTypeImpl.setModifiedDate(null);
		}
		else {
			dicDataTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		dicDataTypeImpl.setStatus(status);
		dicDataTypeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dicDataTypeImpl.setStatusByUserName("");
		}
		else {
			dicDataTypeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dicDataTypeImpl.setStatusDate(null);
		}
		else {
			dicDataTypeImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			dicDataTypeImpl.setName("");
		}
		else {
			dicDataTypeImpl.setName(name);
		}

		if (code == null) {
			dicDataTypeImpl.setCode("");
		}
		else {
			dicDataTypeImpl.setCode(code);
		}

		dicDataTypeImpl.setLength(length);

		dicDataTypeImpl.resetOriginalValues();

		return dicDataTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dicDataTypeId = objectInput.readLong();

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
		name = objectInput.readUTF();
		code = objectInput.readUTF();

		length = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dicDataTypeId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeInt(length);
	}

	public String uuid;
	public long dicDataTypeId;
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
	public String name;
	public String code;
	public int length;

}