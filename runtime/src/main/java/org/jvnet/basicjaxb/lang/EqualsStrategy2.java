package org.jvnet.basicjaxb.lang;

import org.jvnet.basicjaxb.locator.ObjectLocator;

public interface EqualsStrategy2 {

	public boolean isDebugEnabled();
	public boolean isTraceEnabled();

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, boolean left, boolean right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, byte left, byte right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, char left, char right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, double left, double right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, float left, float right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, int left, int right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, long left, long right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, short left, short right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, Object left, Object right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, boolean[] left, boolean[] right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, byte[] left, byte[] right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, char[] left, char[] right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, double[] left, double[] right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, float[] left, float[] right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, int[] left, int[] right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, long[] left, long[] right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, short[] left, short[] right, boolean leftSet, boolean rightSet);

	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, Object[] left, Object[] right, boolean leftSet, boolean rightSet);
}
