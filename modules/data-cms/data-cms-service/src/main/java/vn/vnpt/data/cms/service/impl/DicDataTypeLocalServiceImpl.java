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

package vn.vnpt.data.cms.service.impl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import vn.vnpt.data.cms.service.base.DicDataTypeLocalServiceBaseImpl;

/**
 * The implementation of the dic data type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>vn.vnpt.data.cms.service.DicDataTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author vnpt
 * @see DicDataTypeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=vn.vnpt.data.cms.model.DicDataType",
	service = AopService.class
)
public class DicDataTypeLocalServiceImpl
	extends DicDataTypeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>vn.vnpt.data.cms.service.DicDataTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>vn.vnpt.data.cms.service.DicDataTypeLocalServiceUtil</code>.
	 */
}