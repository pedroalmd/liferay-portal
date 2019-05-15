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

package com.liferay.commerce.discount.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.discount.model.CommerceDiscountUserSegmentRel;
import com.liferay.commerce.discount.service.CommerceDiscountUserSegmentRelLocalServiceUtil;

/**
 * The extended model base implementation for the CommerceDiscountUserSegmentRel service. Represents a row in the &quot;CommerceDiscountUserSegmentRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceDiscountUserSegmentRelImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CommerceDiscountUserSegmentRelImpl
 * @see CommerceDiscountUserSegmentRel
 * @generated
 */
@ProviderType
public abstract class CommerceDiscountUserSegmentRelBaseImpl
	extends CommerceDiscountUserSegmentRelModelImpl
	implements CommerceDiscountUserSegmentRel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce discount user segment rel model instance should use the <code>CommerceDiscountUserSegmentRel</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CommerceDiscountUserSegmentRelLocalServiceUtil.
				addCommerceDiscountUserSegmentRel(this);
		}
		else {
			CommerceDiscountUserSegmentRelLocalServiceUtil.
				updateCommerceDiscountUserSegmentRel(this);
		}
	}

}