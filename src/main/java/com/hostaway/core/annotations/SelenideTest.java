package com.hostaway.core.annotations;

import com.hostaway.core.extensions.SelenideExtension;
import com.hostaway.core.extensions.InjectExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith({InjectExtension.class, SelenideExtension.class})
public @interface SelenideTest {
}
