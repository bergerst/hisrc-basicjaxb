package org.jvnet.basicjaxb.lang;

import org.jvnet.basicjaxb.locator.ObjectLocator;

@Deprecated
public interface HashCodeStrategy {
	
	public int hashCode(ObjectLocator locator, int hashCode, boolean value);
	public int hashCode(ObjectLocator locator, int hashCode, byte value);
	public int hashCode(ObjectLocator locator, int hashCode, char value);
	public int hashCode(ObjectLocator locator, int hashCode, double value);
	public int hashCode(ObjectLocator locator, int hashCode, float value);
	public int hashCode(ObjectLocator locator, int hashCode, int value);
	public int hashCode(ObjectLocator locator, int hashCode, long value);
	public int hashCode(ObjectLocator locator, int hashCode, short value);
	public int hashCode(ObjectLocator locator, int hashCode, Object value);
	public int hashCode(ObjectLocator locator, int hashCode, boolean[] value);
	public int hashCode(ObjectLocator locator, int hashCode, byte[] value);
	public int hashCode(ObjectLocator locator, int hashCode, char[] value);
	public int hashCode(ObjectLocator locator, int hashCode, double[] value);
	public int hashCode(ObjectLocator locator, int hashCode, float[] value);
	public int hashCode(ObjectLocator locator, int hashCode, int[] value);
	public int hashCode(ObjectLocator locator, int hashCode, long[] value);
	public int hashCode(ObjectLocator locator, int hashCode, short[] value);
	public int hashCode(ObjectLocator locator, int hashCode, Object[] value);
	
}
