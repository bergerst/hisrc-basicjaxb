package org.jvnet.basicjaxb.plugin.equals;

import java.util.Arrays;
import java.util.Collection;

import javax.xml.namespace.QName;

import org.jvnet.basicjaxb.lang.Equals2;
import org.jvnet.basicjaxb.lang.EqualsStrategy2;
import org.jvnet.basicjaxb.lang.JAXBEqualsStrategy;
import org.jvnet.basicjaxb.locator.DefaultRootObjectLocator;
import org.jvnet.basicjaxb.locator.ObjectLocator;
import org.jvnet.basicjaxb.locator.util.LocatorUtils;
import org.jvnet.basicjaxb.plugin.AbstractParameterizablePlugin;
import org.jvnet.basicjaxb.plugin.Customizations;
import org.jvnet.basicjaxb.plugin.CustomizedIgnoring;
import org.jvnet.basicjaxb.plugin.Ignoring;
import org.jvnet.basicjaxb.plugin.util.FieldOutlineUtils;
import org.jvnet.basicjaxb.plugin.util.StrategyClassUtils;
import org.jvnet.basicjaxb.util.ClassUtils;
import org.jvnet.basicjaxb.util.FieldAccessorFactory;
import org.jvnet.basicjaxb.util.PropertyFieldAccessorFactory;
import org.jvnet.basicjaxb.xjc.outline.FieldAccessorEx;
import org.xml.sax.ErrorHandler;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JConditional;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JOp;
import com.sun.codemodel.JVar;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.outline.ClassOutline;
import com.sun.tools.xjc.outline.FieldOutline;
import com.sun.tools.xjc.outline.Outline;

public class EqualsPlugin extends AbstractParameterizablePlugin {

	@Override
	public String getOptionName() {
		return "Xequals";
	}

	@Override
	public String getUsage() {
		return "  -Xequals           :  generates reflection-free 'equals' methods";
	}

	private FieldAccessorFactory fieldAccessorFactory = PropertyFieldAccessorFactory.INSTANCE;

	public FieldAccessorFactory getFieldAccessorFactory() {
		return fieldAccessorFactory;
	}

	public void setFieldAccessorFactory(
			FieldAccessorFactory fieldAccessorFactory) {
		this.fieldAccessorFactory = fieldAccessorFactory;
	}

	private String equalsStrategyClass = JAXBEqualsStrategy.class.getName();

	public void setEqualsStrategyClass(String equalsStrategyClass) {
		this.equalsStrategyClass = equalsStrategyClass;
	}

	public String getEqualsStrategyClass() {
		return equalsStrategyClass;
	}

	public JExpression createEqualsStrategy(JCodeModel codeModel) {
		return StrategyClassUtils.createStrategyInstanceExpression(codeModel,
				EqualsStrategy2.class, getEqualsStrategyClass());
	}

	private Ignoring ignoring = new CustomizedIgnoring(
			org.jvnet.basicjaxb.plugin.equals.Customizations.IGNORED_ELEMENT_NAME,
			Customizations.IGNORED_ELEMENT_NAME,
			Customizations.GENERATED_ELEMENT_NAME);

	public Ignoring getIgnoring() {
		return ignoring;
	}

	public void setIgnoring(Ignoring ignoring) {
		this.ignoring = ignoring;
	}

	@Override
	public Collection<QName> getCustomizationElementNames() {
		return Arrays
				.asList(org.jvnet.basicjaxb.plugin.equals.Customizations.IGNORED_ELEMENT_NAME,
						Customizations.IGNORED_ELEMENT_NAME,
						Customizations.GENERATED_ELEMENT_NAME);
	}

	@Override
	public boolean run(Outline outline, Options opt, ErrorHandler errorHandler) {
		for (final ClassOutline classOutline : outline.getClasses()) {
			if (!getIgnoring().isIgnored(classOutline)) {
				processClassOutline(classOutline);
			}
		}
		return true;
	}

	protected void processClassOutline(ClassOutline classOutline) {
		final JDefinedClass theClass = classOutline.implClass;
		ClassUtils._implements(theClass, theClass.owner().ref(Equals2.class));

		@SuppressWarnings("unused")
		final JMethod equals = generateEquals$equals(classOutline, theClass);
		@SuppressWarnings("unused")
		final JMethod objectEquals = generateObject$equals(classOutline,
				theClass);
	}

	protected JMethod generateObject$equals(final ClassOutline classOutline, final JDefinedClass theClass)
	{
		final JCodeModel codeModel = theClass.owner();
		final JMethod objectEquals = theClass.method(JMod.PUBLIC, codeModel.BOOLEAN, "equals");
		objectEquals.annotate(Override.class);
		{
			final JVar that = objectEquals.param(Object.class, "object");
			final JBlock body = objectEquals.body();

			final JVar thisLocator = body.decl
			(
				JMod.NONE,	codeModel.ref(ObjectLocator.class), "thisLocator",
				JExpr._null()
			);
			
			final JVar thatLocator = body.decl
			(
				JMod.NONE,	codeModel.ref(ObjectLocator.class), "thatLocator",
				JExpr._null()
			);

			final JVar equalsStrategy = body.decl
			(
				JMod.FINAL, codeModel.ref(EqualsStrategy2.class), "strategy",
				createEqualsStrategy(codeModel)
			);
			
			final JInvocation thisRootLocator = JExpr._new(codeModel.ref(DefaultRootObjectLocator.class))
				.arg(JExpr._this());

			final JInvocation thatRootLocator = JExpr._new(codeModel.ref(DefaultRootObjectLocator.class))
				.arg(that);

			JConditional ifTraceEnabled = body._if(equalsStrategy.invoke("isTraceEnabled"));
			ifTraceEnabled._then()
				.assign(thisLocator, thisRootLocator)
				.assign(thatLocator, thatRootLocator);
			
			body._return(JExpr.invoke("equals")
				.arg(thisLocator)
				.arg(thatLocator)
				.arg(that)
				.arg(equalsStrategy));
		}
		return objectEquals;
	}

	protected JMethod generateEquals$equals(ClassOutline classOutline,
			final JDefinedClass theClass) {

		final JCodeModel codeModel = theClass.owner();
		final JMethod equals = theClass.method(JMod.PUBLIC, codeModel.BOOLEAN,
				"equals");
		equals.annotate(Override.class);
		{
			final JBlock body = equals.body();
			final JVar leftLocator = equals.param(ObjectLocator.class,
					"thisLocator");
			final JVar rightLocator = equals.param(ObjectLocator.class,
					"thatLocator");
			final JVar object = equals.param(Object.class, "object");
			final JVar equalsStrategy = equals.param(EqualsStrategy2.class,
					"strategy");

			JExpression objectIsNull = object.eq(JExpr._null());
			JExpression notTheSameType = JExpr._this().invoke("getClass")
					.ne(object.invoke("getClass"));
			body._if(JOp.cor(objectIsNull, notTheSameType))._then()
					._return(JExpr.FALSE);

			body._if(JExpr._this().eq(object))._then()._return(JExpr.TRUE);

			final Boolean superClassImplementsEquals = StrategyClassUtils
					.superClassImplements(classOutline, getIgnoring(),
							Equals2.class);

			if (superClassImplementsEquals == null) {
				// No superclass
			} else if (superClassImplementsEquals.booleanValue()) {
				body._if(
						JOp.not(JExpr._super().invoke("equals")
								.arg(leftLocator).arg(rightLocator).arg(object)
								.arg(equalsStrategy)))._then()
						._return(JExpr.FALSE);

			} else {
				body._if(JOp.not(JExpr._super().invoke("equals").arg(object)))
						._then()._return(JExpr.FALSE);
			}

			final JExpression _this = JExpr._this();

			final FieldOutline[] declaredFields = FieldOutlineUtils.filter(
					classOutline.getDeclaredFields(), getIgnoring());

			if (declaredFields.length > 0) {

				final JVar _that = body.decl(JMod.FINAL, theClass, "that",
						JExpr.cast(theClass, object));

				for (final FieldOutline fieldOutline : declaredFields) {

					final FieldAccessorEx leftFieldAccessor = getFieldAccessorFactory()
							.createFieldAccessor(fieldOutline, _this);
					final FieldAccessorEx rightFieldAccessor = getFieldAccessorFactory()
							.createFieldAccessor(fieldOutline, _that);

					if (leftFieldAccessor.isConstant()
							|| rightFieldAccessor.isConstant()) {
						continue;
					}

					final JBlock block = body.block();

					final String name = fieldOutline.getPropertyInfo().getName(
							true);

					final JExpression leftFieldHasSetValue = (leftFieldAccessor
							.isAlwaysSet() || leftFieldAccessor.hasSetValue() == null) ? JExpr.TRUE
							: leftFieldAccessor.hasSetValue();

					final JExpression rightFieldHasSetValue = (rightFieldAccessor
							.isAlwaysSet() || rightFieldAccessor.hasSetValue() == null) ? JExpr.TRUE
							: rightFieldAccessor.hasSetValue();

					final JVar lhsValue = block.decl(
							leftFieldAccessor.getType(), "lhs" + name);
					leftFieldAccessor.toRawValue(block, lhsValue);
					
					final JVar rhsValue = block.decl(
							rightFieldAccessor.getType(), "rhs" + name);
					rightFieldAccessor.toRawValue(block, rhsValue);

//					final JExpression leftValueHasSetValue = lhsValue.type().isPrimitive()
//							? JExpr.TRUE
//							: lhsValue.ne(JExpr._null());
//
//					final JExpression rightValueHasSetValue = lhsValue.type().isPrimitive()
//							? JExpr.TRUE
//							: rhsValue.ne(JExpr._null());
					
					final JExpression leftFieldLocator = codeModel
							.ref(LocatorUtils.class).staticInvoke("property")
							.arg(leftLocator)
							.arg(fieldOutline.getPropertyInfo().getName(false))
							.arg(lhsValue);
					final JExpression rightFieldLocator = codeModel
							.ref(LocatorUtils.class).staticInvoke("property")
							.arg(rightLocator)
							.arg(fieldOutline.getPropertyInfo().getName(false))
							.arg(rhsValue);
					block._if(
							JOp.not(JExpr.invoke(equalsStrategy, "equals")
									.arg(leftFieldLocator)
									.arg(rightFieldLocator).arg(lhsValue)
									.arg(rhsValue).arg(leftFieldHasSetValue)
									.arg(rightFieldHasSetValue)))._then()
//									.arg(rhsValue).arg(leftValueHasSetValue)
//									.arg(rightValueHasSetValue)))._then()
							._return(JExpr.FALSE);
				}
			}
			body._return(JExpr.TRUE);
		}
		return equals;
	}
}
