/**
 * 
 */
package demo.java8.journel.dev;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rishabh.daim
 * 
 */
@Documented
@Target(value = ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
	String author() default "rishabh.daim";

	String date();

	int revision() default 1;

	String comments();
}