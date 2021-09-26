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

import vn.vnpt.data.cms.model.Catalog;

/**
 * The cache model class for representing Catalog in entity cache.
 *
 * @author vnpt
 * @generated
 */
public class CatalogCacheModel implements CacheModel<Catalog>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CatalogCacheModel)) {
			return false;
		}

		CatalogCacheModel catalogCacheModel = (CatalogCacheModel)object;

		if (catalogId == catalogCacheModel.catalogId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, catalogId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
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
		sb.append(", tableName=");
		sb.append(tableName);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", version=");
		sb.append(version);
		sb.append(", visibility=");
		sb.append(visibility);
		sb.append(", catType=");
		sb.append(catType);
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
	public Catalog toEntityModel() {
		CatalogImpl catalogImpl = new CatalogImpl();

		if (uuid == null) {
			catalogImpl.setUuid("");
		}
		else {
			catalogImpl.setUuid(uuid);
		}

		catalogImpl.setCatalogId(catalogId);
		catalogImpl.setGroupId(groupId);
		catalogImpl.setCompanyId(companyId);
		catalogImpl.setUserId(userId);

		if (userName == null) {
			catalogImpl.setUserName("");
		}
		else {
			catalogImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			catalogImpl.setCreateDate(null);
		}
		else {
			catalogImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			catalogImpl.setModifiedDate(null);
		}
		else {
			catalogImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (tableName == null) {
			catalogImpl.setTableName("");
		}
		else {
			catalogImpl.setTableName(tableName);
		}

		if (title == null) {
			catalogImpl.setTitle("");
		}
		else {
			catalogImpl.setTitle(title);
		}

		if (description == null) {
			catalogImpl.setDescription("");
		}
		else {
			catalogImpl.setDescription(description);
		}

		if (version == null) {
			catalogImpl.setVersion("");
		}
		else {
			catalogImpl.setVersion(version);
		}

		catalogImpl.setVisibility(visibility);
		catalogImpl.setCatType(catType);
		catalogImpl.setStatus(status);
		catalogImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			catalogImpl.setStatusByUserName("");
		}
		else {
			catalogImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			catalogImpl.setStatusDate(null);
		}
		else {
			catalogImpl.setStatusDate(new Date(statusDate));
		}

		catalogImpl.resetOriginalValues();

		return catalogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		catalogId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		tableName = objectInput.readUTF();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		version = objectInput.readUTF();

		visibility = objectInput.readBoolean();

		catType = objectInput.readInt();

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

		if (tableName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tableName);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeBoolean(visibility);

		objectOutput.writeInt(catType);

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
	public long catalogId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String tableName;
	public String title;
	public String description;
	public String version;
	public boolean visibility;
	public int catType;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}