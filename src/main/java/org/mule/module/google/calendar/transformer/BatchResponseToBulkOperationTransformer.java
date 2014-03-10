/**
 * Mule Google Calendars Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.google.calendar.transformer;

import org.mule.api.transformer.TransformerException;
import org.mule.common.bulk.BulkOperationResult;
import org.mule.modules.google.api.client.batch.BatchResponse;
import org.mule.transformer.AbstractDiscoverableTransformer;
import org.mule.transformer.types.DataTypeFactory;

public class BatchResponseToBulkOperationTransformer extends AbstractDiscoverableTransformer {
	
	public BatchResponseToBulkOperationTransformer() {
		this.registerSourceType(DataTypeFactory.create(BatchResponse.class));
		this.setReturnDataType(DataTypeFactory.create(BulkOperationResult.class));
	}
	
	
	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		BatchResponse<?> response = (BatchResponse<?>) src;
		return response.asBulkOperationResult();
	}

}
