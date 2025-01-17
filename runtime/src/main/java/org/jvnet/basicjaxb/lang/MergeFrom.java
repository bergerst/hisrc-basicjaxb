package org.jvnet.basicjaxb.lang;

import org.jvnet.basicjaxb.locator.ObjectLocator;

@Deprecated
public interface MergeFrom {

	public Object createNewInstance();

	public void mergeFrom(Object left, Object right);

	public void mergeFrom(ObjectLocator leftLocator,
			ObjectLocator rightLocator, Object left, Object right,
			MergeStrategy mergeStrategy);

}
