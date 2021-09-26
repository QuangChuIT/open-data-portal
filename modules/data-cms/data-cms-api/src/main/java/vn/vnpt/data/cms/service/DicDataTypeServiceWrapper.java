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

package vn.vnpt.data.cms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DicDataTypeService}.
 *
 * @author vnpt
 * @see DicDataTypeService
 * @generated
 */
public class DicDataTypeServiceWrapper
	implements DicDataTypeService, ServiceWrapper<DicDataTypeService> {

	public DicDataTypeServiceWrapper(DicDataTypeService dicDataTypeService) {
		_dicDataTypeService = dicDataTypeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dicDataTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public DicDataTypeService getWrappedService() {
		return _dicDataTypeService;
	}

	@Override
	public void setWrappedService(DicDataTypeService dicDataTypeService) {
		_dicDataTypeService = dicDataTypeService;
	}

	private DicDataTypeService _dicDataTypeService;

}