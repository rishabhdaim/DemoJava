/**
 * 
 */
package tutorialpoints.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tutorialpoints.spring.annotation.TextEditor;
import tutorialpoints.spring.config.CRefreshEventHandlerConfig;
import tutorialpoints.spring.config.CStartEventHandlerConfig;
import tutorialpoints.spring.config.CStopEventHandlerConfig;
import tutorialpoints.spring.config.CustomEventHandlerConfig;
import tutorialpoints.spring.config.CustomEventPublisherConfig;
import tutorialpoints.spring.config.HelloWorldConfig;
import tutorialpoints.spring.config.TextEditorConfig;
import tutorialpoints.spring.events.CustomEventPublisher;
import tutorialpoints.spring.xml.HelloWorld;

/**
 * @author Rishabh.Daim
 *
 */
public class ConfigBasedSpringIoC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
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
