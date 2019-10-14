package io.webfolder.cdp;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

import io.webfolder.cdp.logger.CdpConsoleLogger;
import io.webfolder.cdp.logger.CdpConsoleLogggerLevel;
import io.webfolder.cdp.logger.CdpLogger;

@TargetClass(value = io.webfolder.cdp.logger.CdpLoggerFactory.class)
final class Target_io_webfolder_cdp_logger_CdpLoggerFactory {

    @Substitute
    public CdpLogger getLogger(String name, CdpConsoleLogggerLevel loggerLevel) {
        return new CdpConsoleLogger(loggerLevel);
    }
}

@TargetClass(className = "com.neovisionaries.ws.client.Misc")
final class Target_com_neovisionaries_ws_client_Misc {

    @Substitute
    public static Constructor<?> getConstructor(String className, Class<?>[] parameterTypes) {
        return null;
    }

    @Substitute
    public static Method getMethod(String className, String methodName, Class<?>[] parameterTypes) {
        return null;
    }
}

public class Cdp4jSubstitutions {

}
