package org.jvnet.basicjaxb.plugin.simplify.tests02;

import java.io.File;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.codemodel.JCodeModel;
import com.sun.tools.xjc.ConsoleErrorReporter;
import com.sun.tools.xjc.ModelLoader;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.model.Model;

public class RunSimplifyPlugin {

	@BeforeEach
	public void setUp() {
		System.setProperty("javax.xml.accessExternalSchema", "all");
	}

	@Test
	public void compilesSchema() throws Exception {

		new File("target/generated-sources/xjc").mkdirs();

		URL schema = getClass().getResource("/schema.xsd");
		URL binding = getClass().getResource("/bindings.xjb");
		final String[] arguments = new String[] { "-xmlschema",
				schema.toExternalForm(), "-b", binding.toExternalForm(), "-d",
				"target/generated-sources/xjc", "-extension", "-Xsimplify", "-Xsimplify-usePluralForm=true"};

		Options options = new Options();
		options.parseArguments(arguments);
		ConsoleErrorReporter receiver = new ConsoleErrorReporter();
		Model model = ModelLoader.load(options, new JCodeModel(), receiver);
		model.generateCode(options, receiver);
		com.sun.codemodel.CodeWriter cw = options.createCodeWriter();
		model.codeModel.build(cw);
	}
}
