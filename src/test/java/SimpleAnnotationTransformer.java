import org.apache.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SimpleAnnotationTransformer implements IAnnotationTransformer {

    final static Logger logger = (Logger) Logger.getLogger(SimpleSuiteListener.class);

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {

        logger.info(method.getName());
        Arrays.stream(method.getAnnotations()).forEach(x->logger.info(x.annotationType().getName()));

        /*if(Arrays.stream(method.getAnnotations()).anyMatch(x -> x.annotationType().getName()
                .equals("resources.IgnoreTest"))){
            iTestAnnotation.setEnabled(false);
        }*/
/*        if(iTestAnnotation.getAlwaysRun()){
            iTestAnnotation.setEnabled(false);
        }*/
    }
}
