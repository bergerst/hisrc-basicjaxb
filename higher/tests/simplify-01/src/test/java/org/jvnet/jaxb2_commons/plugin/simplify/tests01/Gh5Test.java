package org.jvnet.jaxb2_commons.plugin.simplify.tests01;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Gh5Test {

	private JAXBContext context;

	@BeforeEach
	public void setUp() throws Exception {
		context = JAXBContext.newInstance(getClass().getPackage().getName());
	}

	@Test
	public void compiles() {
		final SimplifyReferencesPropertyAsReferencePropertyType item = new SimplifyReferencesPropertyAsReferencePropertyType();
		item.getBases();
		item.getBaseElements();
	}

	@Test
	public void unmarshalls() throws Exception {

		@SuppressWarnings("unchecked")
		SimplifyReferencesPropertyAsReferencePropertyType value = ((JAXBElement<SimplifyReferencesPropertyAsReferencePropertyType>) context
				.createUnmarshaller()
				.unmarshal(
						getClass()
								.getResourceAsStream(
										"simplifyReferencesPropertyAsReferenceProperty.xml")))
				.getValue();

		assertEquals(3, value.getBases().size());
		assertEquals(3, value.getBaseElements().size());
	}
}
