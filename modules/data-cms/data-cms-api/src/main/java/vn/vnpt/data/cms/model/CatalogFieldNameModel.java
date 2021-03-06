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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CatalogFieldName service. Represents a row in the &quot;VNPT_CatalogFieldName&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>vn.vnpt.data.cms.model.impl.CatalogFieldNameModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>vn.vnpt.data.cms.model.impl.CatalogFieldNameImpl</code>.
 * </p>
 *
 * @author vnpt
 * @see CatalogFieldName
 * @generated
 */
@ProviderType
public interface CatalogFieldNameModel
	extends BaseModel<CatalogFieldName>, GroupedModel, LocalizedModel,
			ShardedModel, StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a catalog field name model instance should use the {@link CatalogFieldName} interface instead.
	 */

	/**
	 * Returns the primary key of this catalog field name.
	 *
	 * @return the primary key of this catalog field name
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this catalog field name.
	 *
	 * @param primaryKey the primary key of this catalog field name
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this catalog field name.
	 *
	 * @return the uuid of this catalog field name
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this catalog field name.
	 *
	 * @param uuid the uuid of this catalog field name
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the entry ID of this catalog field name.
	 *
	 * @return the entry ID of this catalog field name
	 */
	public long getEntryId();

	/**
	 * Sets the entry ID of this catalog field name.
	 *
	 * @param entryId the entry ID of this catalog field name
	 */
	public void setEntryId(long entryId);

	/**
	 * Returns the code of this catalog field name.
	 *
	 * @return the code of this catalog field name
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this catalog field name.
	 *
	 * @param code the code of this catalog field name
	 */
	public void setCode(String code);

	/**
	 * Returns the name of this catalog field name.
	 *
	 * @return the name of this catalog field name
	 */
	public String getName();

	/**
	 * Returns the localized name of this catalog field name in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this catalog field name
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this catalog field name in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this catalog field name. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this catalog field name in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this catalog field name
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this catalog field name in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this catalog field name
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this catalog field name.
	 *
	 * @return the locales and localized names of this catalog field name
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this catalog field name.
	 *
	 * @param name the name of this catalog field name
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this catalog field name in the language.
	 *
	 * @param name the localized name of this catalog field name
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this catalog field name in the language, and sets the default locale.
	 *
	 * @param name the localized name of this catalog field name
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this catalog field name from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this catalog field name
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this catalog field name from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this catalog field name
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the data type of this catalog field name.
	 *
	 * @return the data type of this catalog field name
	 */
	@AutoEscape
	public String getDataType();

	/**
	 * Sets the data type of this catalog field name.
	 *
	 * @param dataType the data type of this catalog field name
	 */
	public void setDataType(String dataType);

	/**
	 * Returns the format of this catalog field name.
	 *
	 * @return the format of this catalog field name
	 */
	@AutoEscape
	public String getFormat();

	/**
	 * Sets the format of this catalog field name.
	 *
	 * @param format the format of this catalog field name
	 */
	public void setFormat(String format);

	/**
	 * Returns the default value of this catalog field name.
	 *
	 * @return the default value of this catalog field name
	 */
	@AutoEscape
	public String getDefaultValue();

	/**
	 * Sets the default value of this catalog field name.
	 *
	 * @param defaultValue the default value of this catalog field name
	 */
	public void setDefaultValue(String defaultValue);

	/**
	 * Returns the not null of this catalog field name.
	 *
	 * @return the not null of this catalog field name
	 */
	public boolean getNotNull();

	/**
	 * Returns <code>true</code> if this catalog field name is not null.
	 *
	 * @return <code>true</code> if this catalog field name is not null; <code>false</code> otherwise
	 */
	public boolean isNotNull();

	/**
	 * Sets whether this catalog field name is not null.
	 *
	 * @param notNull the not null of this catalog field name
	 */
	public void setNotNull(boolean notNull);

	/**
	 * Returns the hidden status of this catalog field name.
	 *
	 * @return the hidden status of this catalog field name
	 */
	public boolean getHiddenStatus();

	/**
	 * Returns <code>true</code> if this catalog field name is hidden status.
	 *
	 * @return <code>true</code> if this catalog field name is hidden status; <code>false</code> otherwise
	 */
	public boolean isHiddenStatus();

	/**
	 * Sets whether this catalog field name is hidden status.
	 *
	 * @param hiddenStatus the hidden status of this catalog field name
	 */
	public void setHiddenStatus(boolean hiddenStatus);

	/**
	 * Returns the is search of this catalog field name.
	 *
	 * @return the is search of this catalog field name
	 */
	public boolean getIsSearch();

	/**
	 * Returns <code>true</code> if this catalog field name is is search.
	 *
	 * @return <code>true</code> if this catalog field name is is search; <code>false</code> otherwise
	 */
	public boolean isIsSearch();

	/**
	 * Sets whether this catalog field name is is search.
	 *
	 * @param isSearch the is search of this catalog field name
	 */
	public void setIsSearch(boolean isSearch);

	/**
	 * Returns the catalog ID of this catalog field name.
	 *
	 * @return the catalog ID of this catalog field name
	 */
	public long getCatalogId();

	/**
	 * Sets the catalog ID of this catalog field name.
	 *
	 * @param catalogId the catalog ID of this catalog field name
	 */
	public void setCatalogId(long catalogId);

	/**
	 * Returns the group ID of this catalog field name.
	 *
	 * @return the group ID of this catalog field name
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this catalog field name.
	 *
	 * @param groupId the group ID of this catalog field name
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this catalog field name.
	 *
	 * @return the company ID of this catalog field name
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this catalog field name.
	 *
	 * @param companyId the company ID of this catalog field name
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this catalog field name.
	 *
	 * @return the user ID of this catalog field name
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this catalog field name.
	 *
	 * @param userId the user ID of this catalog field name
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this catalog field name.
	 *
	 * @return the user uuid of this catalog field name
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this catalog field name.
	 *
	 * @param userUuid the user uuid of this catalog field name
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this catalog field name.
	 *
	 * @return the user name of this catalog field name
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this catalog field name.
	 *
	 * @param userName the user name of this catalog field name
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this catalog field name.
	 *
	 * @return the create date of this catalog field name
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this catalog field name.
	 *
	 * @param createDate the create date of this catalog field name
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this catalog field name.
	 *
	 * @return the modified date of this catalog field name
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this catalog field name.
	 *
	 * @param modifiedDate the modified date of this catalog field name
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this catalog field name.
	 *
	 * @return the status of this catalog field name
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this catalog field name.
	 *
	 * @param status the status of this catalog field name
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this catalog field name.
	 *
	 * @return the status by user ID of this catalog field name
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this catalog field name.
	 *
	 * @param statusByUserId the status by user ID of this catalog field name
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this catalog field name.
	 *
	 * @return the status by user uuid of this catalog field name
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this catalog field name.
	 *
	 * @param statusByUserUuid the status by user uuid of this catalog field name
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this catalog field name.
	 *
	 * @return the status by user name of this catalog field name
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this catalog field name.
	 *
	 * @param statusByUserName the status by user name of this catalog field name
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this catalog field name.
	 *
	 * @return the status date of this catalog field name
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this catalog field name.
	 *
	 * @param statusDate the status date of this catalog field name
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this catalog field name is approved.
	 *
	 * @return <code>true</code> if this catalog field name is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this catalog field name is denied.
	 *
	 * @return <code>true</code> if this catalog field name is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this catalog field name is a draft.
	 *
	 * @return <code>true</code> if this catalog field name is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this catalog field name is expired.
	 *
	 * @return <code>true</code> if this catalog field name is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this catalog field name is inactive.
	 *
	 * @return <code>true</code> if this catalog field name is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this catalog field name is incomplete.
	 *
	 * @return <code>true</code> if this catalog field name is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this catalog field name is pending.
	 *
	 * @return <code>true</code> if this catalog field name is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this catalog field name is scheduled.
	 *
	 * @return <code>true</code> if this catalog field name is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

}