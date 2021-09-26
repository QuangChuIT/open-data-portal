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

import vn.vnpt.data.cms.model.Catalog;
import vn.vnpt.data.cms.service.CatalogLocalServiceUtil;

/**
 * The extended model base implementation for the Catalog service. Represents a row in the &quot;VNPT_Catalog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CatalogImpl}.
 * </p>
 *
 * @author vnpt
 * @see CatalogImpl
 * @see Catalog
 * @generated
 */
public abstract class CatalogBaseImpl
	extends CatalogModelImpl implements Catalog {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a catalog model instance should use the <code>Catalog</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CatalogLocalServiceUtil.addCatalog(this);
		}
		else {
			CatalogLocalServiceUtil.updateCatalog(this);
		}
	}

}