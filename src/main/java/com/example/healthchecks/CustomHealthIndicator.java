import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/*
Uncomment following line if you want following class to run
*/
//@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

    private static final Logger logger = LoggerFactory.getLogger(HealthIndicator.class);

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.up();
        try {
            System.out.println("In healthcheck");
            doCheck(builder);
            logger.info("Health check success!");
        } catch (Exception ex) {
            // null pointer exception happens here, logger is null.
            if (logger.isWarnEnabled()) {
                String message = "hello Exception";
                logger.warn(StringUtils.hasText(message) ? message : "DEFAULT_MESSAGE",
                        ex);
            }
            builder.down(ex);
        }
    }

    private void doCheck(Health.Builder builder) {
        throw new RuntimeException("Exception");
    }

    /**
     * In healthcheck
     * 2019-06-21 14:17:41.569  WARN 518 --- [)-10.92.244.247] c.example.configuration.HealthIndicator  : hello Exception
     *
     * java.lang.RuntimeException: Exception
     * 	at com.example.configuration.HealthIndicator.doCheck(HealthIndicator.java:34) ~[classes/:na]
     * 	at com.example.configuration.HealthIndicator.doHealthCheck(HealthIndicator.java:20) ~[classes/:na]
     * 	at org.springframework.boot.actuate.health.AbstractHealthIndicator.health(AbstractHealthIndicator.java:84) ~[spring-boot-actuator-2.1.4.RELEASE.jar:2.1.4.RELEASE]
     * 	at org.springframework.boot.actuate.health.CompositeHealthIndicator.health(CompositeHealthIndicator.java:98) ~[spring-boot-actuator-2.1.4.RELEASE.jar:2.1.4.RELEASE]
     * 	at org.springframework.boot.actuate.health.HealthEndpoint.health(HealthEndpoint.java:50) ~[spring-boot-actuator-2.1.4.RELEASE.jar:2.1.4.RELEASE]
     * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
     * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
     * 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
     * 	at java.base/java.lang.reflect.Method.invoke(Method.java:567) ~[na:na]
     */

}
