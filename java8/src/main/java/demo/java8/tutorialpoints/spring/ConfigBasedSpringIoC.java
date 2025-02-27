/**
 * 
 */
package demo.java8.tutorialpoints.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.java8.tutorialpoints.spring.annotation.TextEditor;
import demo.java8.tutorialpoints.spring.config.CRefreshEventHandlerConfig;
import demo.java8.tutorialpoints.spring.config.CStartEventHandlerConfig;
import demo.java8.tutorialpoints.spring.config.CStopEventHandlerConfig;
import demo.java8.tutorialpoints.spring.config.CustomEventHandlerConfig;
import demo.java8.tutorialpoints.spring.config.CustomEventPublisherConfig;
import demo.java8.tutorialpoints.spring.config.HelloWorldConfig;
import demo.java8.tutorialpoints.spring.config.TextEditorConfig;
import demo.java8.tutorialpoints.spring.events.CustomEventPublisher;
import demo.java8.tutorialpoints.spring.xml.HelloWorld;

/**
 * @author Rishabh.Daim
 *
 */
public class ConfigBasedSpringIoC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.register(HelloWorldConfig.class, TextEditorConfig.class, CStartEventHandlerConfig.class, CStopEventHandlerConfig.class, 
				CRefreshEventHandlerConfig.class, CustomEventPublisherConfig.class, CustomEventHandlerConfig.class);
		context.refresh();
		System.out.println("----------------------------------");
		
		/*final ApplicationListener<ContextStartedEvent> startListener = context.getBean("cStartEventHandler", CStartEventHandler.class);
		final ApplicationListener<ContextStoppedEvent> stopListener = context.getBean("cStopEventHandler", CStopEventHandler.class);
		
		context.addApplicationListener(startListener);
		context.addApplicationListener(stopListener);*/
		
		context.start();
		System.out.println("----------------------------------");
		
		HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
		helloWorld.setMessage("Hello World!");
		helloWorld.getMessage();
		System.out.println("----------------------------------");
		
		TextEditor textEditor = context.getBean("textEditor", TextEditor.class);
		textEditor.spellCheck();
		System.out.println("----------------------------------");
		
		context.stop();
		System.out.println("----------------------------------");
		
		// custom event publishing
		CustomEventPublisher publisher = context.getBean("customEventPublisher", CustomEventPublisher.class);
		publisher.publish();
		System.out.println("----------------------------------");
		
		context.registerShutdownHook();
	}
}
