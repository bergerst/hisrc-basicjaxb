package org.jvnet.basicjaxb.lang;

import org.jvnet.basicjaxb.locator.ObjectLocator;

@Deprecated
public interface CopyStrategy {

	public boolean copy(ObjectLocator locator, boolean value);

	public byte copy(ObjectLocator locator, byte value);

	public char copy(ObjectLocator locator, char value);

	public double copy(ObjectLocator locator, double value);

	public float copy(ObjectLocator locator, float value);

	public int copy(ObjectLocator locator, int value);

	public long copy(ObjectLocator locator, long value);

	public short copy(ObjectLocator locator, short value);

	public Object copy(ObjectLocator locator, Object value);

	public boolean[] copy(ObjectLocator locator, boolean[] value);

	public byte[] copy(ObjectLocator locator, byte[] value);

	public char[] copy(ObjectLocator locator, char[] value);

	public double[] copy(ObjectLocator locator, double[] value);

	public float[] copy(ObjectLocator locator, float[] value);

	public int[] copy(ObjectLocator locator, int[] value);

	public long[] copy(ObjectLocator locator, long[] value);

	public short[] copy(ObjectLocator locator, short[] value);

	public Object[] copy(ObjectLocator locator, Object[] value);

}
