package com.hostaway.core.extensions;

import com.google.inject.Guice;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class InjectExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        Guice.createInjector().injectMembers(extensionContext.getTestInstance().get());
    }
}
