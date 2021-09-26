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
 * This class is a wrapper for {@link CatalogFieldName}.
 * </p>
 *
 * @author vnpt
 * @see CatalogFieldName
 * @generated
 */
public class CatalogFieldNameWrapper
	extends BaseModelWrapper<CatalogFieldName>
	implements CatalogFieldName, ModelWrapper<CatalogFieldName> {

	public CatalogFieldNameWrapper(CatalogFieldName catalogFieldName) {
		super(catalogFieldName);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entryId", getEntryId());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("dataType", getDataType());
		attributes.put("format", getFormat());
		attributes.put("defaultValue", getDefaultValue());
		attributes.put("notNull", isNotNull());
		attributes.put("hiddenStatus", isHiddenStatus());
		attributes.put("isSearch", isIsSearch());
		attributes.put("catalogId", getCatalogId());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String dataType = (String)attributes.get("dataType");

		if (dataType != null) {
			setDataType(dataType);
		}

		String format = (String)attributes.get("format");

		if (format != null) {
			setFormat(format);
		}

		String defaultValue = (String)attributes.get("defaultValue");

		if (defaultValue != null) {
			setDefaultValue(defaultValue);
		}

		Boolean notNull = (Boolean)attributes.get("notNull");

		if (notNull != null) {
			setNotNull(notNull);
		}

		Boolean hiddenStatus = (Boolean)attributes.get("hiddenStatus");

		if (hiddenStatus != null) {
			setHiddenStatus(hiddenStatus);
		}

		Boolean isSearch = (Boolean)attributes.get("isSearch");

		if (isSearch != null) {
			setIsSearch(isSearch);
		}

		Long catalogId = (Long)attributes.get("catalogId");

		if (catalogId != null) {
			setCatalogId(catalogId);
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
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the catalog ID of this catalog field name.
	 *
	 * @return the catalog ID of this catalog field name
	 */
	@Override
	public long getCatalogId() {
		return model.getCatalogId();
	}

	/**
	 * Returns the code of this catalog field name.
	 *
	 * @return the code of this catalog field name
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this catalog field name.
	 *
	 * @return the company ID of this catalog field name
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this catalog field name.
	 *
	 * @return the create date of this catalog field name
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data type of this catalog field name.
	 *
	 * @return the data type of this catalog field name
	 */
	@Override
	public String getDataType() {
		return model.getDataType();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the default value of this catalog field name.
	 *
	 * @return the default value of this catalog field name
	 */
	@Override
	public String getDefaultValue() {
		return model.getDefaultValue();
	}

	/**
	 * Returns the entry ID of this catalog field name.
	 *
	 * @return the entry ID of this catalog field name
	 */
	@Override
	public long getEntryId() {
		return model.getEntryId();
	}

	/**
	 * Returns the format of this catalog field name.
	 *
	 * @return the format of this catalog field name
	 */
	@Override
	public String getFormat() {
		return model.getFormat();
	}

	/**
	 * Returns the group ID of this catalog field name.
	 *
	 * @return the group ID of this catalog field name
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hidden status of this catalog field name.
	 *
	 * @return the hidden status of this catalog field name
	 */
	@Override
	public boolean getHiddenStatus() {
		return model.getHiddenStatus();
	}

	/**
	 * Returns the is search of this catalog field name.
	 *
	 * @return the is search of this catalog field name
	 */
	@Override
	public boolean getIsSearch() {
		return model.getIsSearch();
	}

	/**
	 * Returns the modified date of this catalog field name.
	 *
	 * @return the modified date of this catalog field name
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this catalog field name.
	 *
	 * @return the name of this catalog field name
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this catalog field name in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this catalog field name
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
	}

	/**
	 * Returns the localized name of this catalog field name in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this catalog field name. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this catalog field name in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this catalog field name
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	/**
	 * Returns the localized name of this catalog field name in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this catalog field name
	 */
	@Override
	public String getName(String languageId, boolean useDefault) {
		return model.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return model.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return model.getNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized names of this catalog field name.
	 *
	 * @return the locales and localized names of this catalog field name
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Returns the not null of this catalog field name.
	 *
	 * @return the not null of this catalog field name
	 */
	@Override
	public boolean getNotNull() {
		return model.getNotNull();
	}

	/**
	 * Returns the primary key of this catalog field name.
	 *
	 * @return the primary key of this catalog field name
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this catalog field name.
	 *
	 * @return the status of this catalog field name
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this catalog field name.
	 *
	 * @return the status by user ID of this catalog field name
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this catalog field name.
	 *
	 * @return the status by user name of this catalog field name
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this catalog field name.
	 *
	 * @return the status by user uuid of this catalog field name
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this catalog field name.
	 *
	 * @return the status date of this catalog field name
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this catalog field name.
	 *
	 * @return the user ID of this catalog field name
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this catalog field name.
	 *
	 * @return the user name of this catalog field name
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this catalog field name.
	 *
	 * @return the user uuid of this catalog field name
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this catalog field name.
	 *
	 * @return the uuid of this catalog field name
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this catalog field name is approved.
	 *
	 * @return <code>true</code> if this catalog field name is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this catalog field name is denied.
	 *
	 * @return <code>true</code> if this catalog field name is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this catalog field name is a draft.
	 *
	 * @return <code>true</code> if this catalog field name is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this catalog field name is expired.
	 *
	 * @return <code>true</code> if this catalog field name is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this catalog field name is hidden status.
	 *
	 * @return <code>true</code> if this catalog field name is hidden status; <code>false</code> otherwise
	 */
	@Override
	public boolean isHiddenStatus() {
		return model.isHiddenStatus();
	}

	/**
	 * Returns <code>true</code> if this catalog field name is inactive.
	 *
	 * @return <code>true</code> if this catalog field name is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this catalog field name is incomplete.
	 *
	 * @return <code>true</code> if this catalog field name is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this catalog field name is is search.
	 *
	 * @return <code>true</code> if this catalog field name is is search; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSearch() {
		return model.isIsSearch();
	}

	/**
	 * Returns <code>true</code> if this catalog field name is not null.
	 *
	 * @return <code>true</code> if this catalog field name is not null; <code>false</code> otherwise
	 */
	@Override
	public boolean isNotNull() {
		return model.isNotNull();
	}

	/**
	 * Returns <code>true</code> if this catalog field name is pending.
	 *
	 * @return <code>true</code> if this catalog field name is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this catalog field name is scheduled.
	 *
	 * @return <code>true</code> if this catalog field name is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the catalog ID of this catalog field name.
	 *
	 * @param catalogId the catalog ID of this catalog field name
	 */
	@Override
	public void setCatalogId(long catalogId) {
		model.setCatalogId(catalogId);
	}

	/**
	 * Sets the code of this catalog field name.
	 *
	 * @param code the code of this catalog field name
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this catalog field name.
	 *
	 * @param companyId the company ID of this catalog field name
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this catalog field name.
	 *
	 * @param createDate the create date of this catalog field name
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data type of this catalog field name.
	 *
	 * @param dataType the data type of this catalog field name
	 */
	@Override
	public void setDataType(String dataType) {
		model.setDataType(dataType);
	}

	/**
	 * Sets the default value of this catalog field name.
	 *
	 * @param defaultValue the default value of this catalog field name
	 */
	@Override
	public void setDefaultValue(String defaultValue) {
		model.setDefaultValue(defaultValue);
	}

	/**
	 * Sets the entry ID of this catalog field name.
	 *
	 * @param entryId the entry ID of this catalog field name
	 */
	@Override
	public void setEntryId(long entryId) {
		model.setEntryId(entryId);
	}

	/**
	 * Sets the format of this catalog field name.
	 *
	 * @param format the format of this catalog field name
	 */
	@Override
	public void setFormat(String format) {
		model.setFormat(format);
	}

	/**
	 * Sets the group ID of this catalog field name.
	 *
	 * @param groupId the group ID of this catalog field name
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this catalog field name is hidden status.
	 *
	 * @param hiddenStatus the hidden status of this catalog field name
	 */
	@Override
	public void setHiddenStatus(boolean hiddenStatus) {
		model.setHiddenStatus(hiddenStatus);
	}

	/**
	 * Sets whether this catalog field name is is search.
	 *
	 * @param isSearch the is search of this catalog field name
	 */
	@Override
	public void setIsSearch(boolean isSearch) {
		model.setIsSearch(isSearch);
	}

	/**
	 * Sets the modified date of this catalog field name.
	 *
	 * @param modifiedDate the modified date of this catalog field name
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this catalog field name.
	 *
	 * @param name the name of this catalog field name
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this catalog field name in the language.
	 *
	 * @param name the localized name of this catalog field name
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
	}

	/**
	 * Sets the localized name of this catalog field name in the language, and sets the default locale.
	 *
	 * @param name the localized name of this catalog field name
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setName(
		String name, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		model.setNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized names of this catalog field name from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this catalog field name
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this catalog field name from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this catalog field name
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets whether this catalog field name is not null.
	 *
	 * @param notNull the not null of this catalog field name
	 */
	@Override
	public void setNotNull(boolean notNull) {
		model.setNotNull(notNull);
	}

	/**
	 * Sets the primary key of this catalog field name.
	 *
	 * @param primaryKey the primary key of this catalog field name
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this catalog field name.
	 *
	 * @param status the status of this catalog field name
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this catalog field name.
	 *
	 * @param statusByUserId the status by user ID of this catalog field name
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this catalog field name.
	 *
	 * @param statusByUserName the status by user name of this catalog field name
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this catalog field name.
	 *
	 * @param statusByUserUuid the status by user uuid of this catalog field name
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this catalog field name.
	 *
	 * @param statusDate the status date of this catalog field name
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this catalog field name.
	 *
	 * @param userId the user ID of this catalog field name
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this catalog field name.
	 *
	 * @param userName the user name of this catalog field name
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this catalog field name.
	 *
	 * @param userUuid the user uuid of this catalog field name
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this catalog field name.
	 *
	 * @param uuid the uuid of this catalog field name
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
	protected CatalogFieldNameWrapper wrap(CatalogFieldName catalogFieldName) {
		return new CatalogFieldNameWrapper(catalogFieldName);
	}

}