package org.jvnet.basicjaxb.lang;

import org.jvnet.basicjaxb.locator.ObjectLocator;

@Deprecated
public interface EqualsStrategy {

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, boolean left, boolean right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, byte left, byte right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, char left, char right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, double left, double right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, float left, float right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, int left, int right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, long left, long right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, short left, short right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, Object left, Object right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, boolean[] left, boolean[] right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, byte[] left, byte[] right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, char[] left, char[] right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, double[] left, double[] right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, float[] left, float[] right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, int[] left, int[] right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, long[] left, long[] right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, short[] left, short[] right);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, Object[] left, Object[] right);

}
