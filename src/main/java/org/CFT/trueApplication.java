package org.CFT;


import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.CFT.resources.DeliveryEmployeeController;
import org.CFT.resources.SalesEmployeeController;

public class trueApplication extends Application<trueConfiguration> {

    public static void main(final String[] args) throws Exception {
        new trueApplication().run(args);
    }

    @Override
    public String getName() {
        return "true";
    }

    @Override
    public void initialize(final Bootstrap<trueConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(new SwaggerBundle<trueConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(trueConfiguration config){
                return config.getSwagger();
            }
        });
    }

    @Override
    public void run(final trueConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new SalesEmployeeController());
        environment.jersey().register(new DeliveryEmployeeController());
    }

}
