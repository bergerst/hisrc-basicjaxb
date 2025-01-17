package org.jvnet.basicjaxb.tests.one;

import java.io.File;

import org.jvnet.basicjaxb.test.AbstractSamplesTest;
import org.jvnet.basicjaxb.lang.JAXBToStringStrategy;

public class ToStringTest extends AbstractSamplesTest {

  @Override
  protected void checkSample(File sample) throws Exception {
    
    final Object object = createContext().createUnmarshaller().unmarshal(sample);
    System.out.println(JAXBToStringStrategy.getInstance().append(null, new StringBuilder(), object).toString());
  }

}
