package ohtm.backend.db.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.zaxxer.hikari.util.DriverDataSource;
import ohtm.backend.db.config.DbConfig;
import pl.coffeepower.guiceliquibase.GuiceLiquibaseConfig;
import pl.coffeepower.guiceliquibase.GuiceLiquibaseModule;
import pl.coffeepower.guiceliquibase.LiquibaseConfig;
import pl.coffeepower.guiceliquibase.annotation.GuiceLiquibaseConfiguration;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.util.Properties;

public class LiquibaseModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new GuiceLiquibaseModule());
    }

    @Provides
    @Singleton
    public DataSource dataSource(DbConfig config) {
        Properties properties = new Properties();
        properties.setProperty("currentSchema", config.getSchema());
        return new DriverDataSource(
                config.getUrl(),
                config.getDriver(),
                properties,
                config.getUsername(),
                config.getPassword());
    }

    @GuiceLiquibaseConfiguration
    @Provides
    @Inject
    private GuiceLiquibaseConfig createLiquibaseConfig(DataSource dataSource) {
        return GuiceLiquibaseConfig.Builder
                .of(LiquibaseConfig.Builder.of(dataSource)
                        .withChangeLogPath("changelog/db.changelog-master.groovy")
                        .build())
                .build();
    }
}
