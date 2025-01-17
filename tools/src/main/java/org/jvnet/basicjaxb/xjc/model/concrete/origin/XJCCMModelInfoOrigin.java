package org.jvnet.basicjaxb.xjc.model.concrete.origin;

import org.jvnet.basicjaxb.xjc.generator.MModelOutlineGenerator;
import org.jvnet.basicjaxb.xjc.generator.concrete.CMModelOutlineGenerator;
import org.jvnet.basicjaxb.xjc.generator.concrete.ModelOutlineGeneratorFactory;
import org.jvnet.basicjaxb.xml.bind.model.concrete.origin.CMModelInfoOrigin;

import com.sun.tools.xjc.model.Model;
import com.sun.tools.xjc.model.nav.NClass;
import com.sun.tools.xjc.model.nav.NType;
import com.sun.tools.xjc.outline.Outline;
import com.sun.xml.xsom.XSSchemaSet;

public class XJCCMModelInfoOrigin extends
		CMModelInfoOrigin<NType, NClass, Model> implements
		ModelOutlineGeneratorFactory {

	public XJCCMModelInfoOrigin(Model source) {
		super(source);
	}

	public MModelOutlineGenerator createGenerator(Outline outline) {
		return new CMModelOutlineGenerator(outline, getSource());
	}

	public XSSchemaSet getSchemaComponent() {
		return getSource().schemaComponent;
	}

}
