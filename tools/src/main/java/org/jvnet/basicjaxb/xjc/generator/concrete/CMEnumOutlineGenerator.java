package org.jvnet.basicjaxb.xjc.generator.concrete;

import org.apache.commons.lang3.Validate;
import org.jvnet.basicjaxb.xjc.generator.MEnumConstantOutlineGenerator;
import org.jvnet.basicjaxb.xjc.generator.MEnumOutlineGenerator;
import org.jvnet.basicjaxb.xjc.outline.MEnumConstantOutline;
import org.jvnet.basicjaxb.xjc.outline.MEnumOutline;
import org.jvnet.basicjaxb.xjc.outline.MPackageOutline;
import org.jvnet.basicjaxb.xjc.outline.concrete.CMEnumOutline;
import org.jvnet.basicjaxb.xml.bind.model.MEnumConstantInfo;
import org.jvnet.basicjaxb.xml.bind.model.MEnumLeafInfo;
import org.jvnet.basicjaxb.xml.bind.model.MModelInfo;

import com.sun.tools.xjc.model.CEnumLeafInfo;
import com.sun.tools.xjc.model.nav.NClass;
import com.sun.tools.xjc.model.nav.NType;
import com.sun.tools.xjc.outline.EnumOutline;
import com.sun.tools.xjc.outline.Outline;

public class CMEnumOutlineGenerator implements MEnumOutlineGenerator {

	private final Outline outline;
	private final CEnumLeafInfo enumLeafInfo;

	public CMEnumOutlineGenerator(Outline outline, CEnumLeafInfo enumLeafInfo) {
		Validate.notNull(outline);
		Validate.notNull(enumLeafInfo);
		this.outline = outline;
		this.enumLeafInfo = enumLeafInfo;
	}

	public MEnumOutline generate(MPackageOutline parent,
			MModelInfo<NType, NClass> modelInfo,
			MEnumLeafInfo<NType, NClass> enumLeafInfo) {
		final EnumOutline eo = outline.getEnum(this.enumLeafInfo);

		final CMEnumOutline enumOutline = new CMEnumOutline(parent.getParent(),
				parent, enumLeafInfo, eo.clazz);

		for (MEnumConstantInfo<NType, NClass> enumConstantInfo : enumLeafInfo
				.getConstants()) {

			if (enumConstantInfo.getOrigin() instanceof EnumConstantOutlineGeneratorFactory) {
				final MEnumConstantOutlineGenerator generator = ((EnumConstantOutlineGeneratorFactory) enumConstantInfo
						.getOrigin()).createGenerator(outline);
				final MEnumConstantOutline enumConstantOutline = generator
						.generate(enumOutline, modelInfo, enumConstantInfo);
				if (enumConstantOutline != null) {
					enumOutline.addEnumConstantOutline(enumConstantOutline);
				}
			}
		}
		return enumOutline;
	}

}
