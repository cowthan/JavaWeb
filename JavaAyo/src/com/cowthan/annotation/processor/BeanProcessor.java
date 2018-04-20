package com.cowthan.annotation.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;

@SupportedAnnotationTypes({"com.avenwu.annotation.PrintMe"})
public class BeanProcessor extends AbstractProcessor {

	// 元素操作的辅助类
	Elements elementUtils;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		// 元素操作的辅助类
		elementUtils = processingEnv.getElementUtils();
	}

	
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {

		for (TypeElement currentAnnotation : annotations) {
            Name qualifiedName = currentAnnotation.getQualifiedName();
            if (qualifiedName.contentEquals("com.avenwu.annotation.PrintMe")){
                Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(currentAnnotation);
                for (Element element : annotatedElements) {
                	Version v = element.getAnnotation(Version.class);
                    int major = v.major();
                    int minor = v.minor();
                    if(major < 0 || minor < 0) {
                        String errMsg = "Version cannot be negative. major = " + major + " minor = " + minor;
                        Messager messager = this.processingEnv.getMessager();
                        messager.printMessage(javax.tools.Diagnostic.Kind.ERROR,errMsg,element);
}
                }
            }
        }
		return true;
	}
	
	@Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

}
