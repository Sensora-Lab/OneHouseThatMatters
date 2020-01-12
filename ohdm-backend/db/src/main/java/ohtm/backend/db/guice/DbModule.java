package ohtm.backend.db.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import ohtm.backend.db.config.DbConfig;

import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

public class DbModule extends AbstractModule {

    private final DbConfig dbConfig;
    private final Map<String, String> properties = new HashMap<>();

    public DbModule(DbConfig dbConfig) {
        this(dbConfig, new HashMap<>());
    }

    public DbModule(DbConfig dbConfig, Map<String, String> properties) {
        this.dbConfig = dbConfig;
        this.properties.putAll(properties);
    }

    @Override
    protected void configure() {
        properties.put("hibernate.connection.url", dbConfig.getUrl());
        properties.put("hibernate.connection.username", dbConfig.getUsername());
        properties.put("hibernate.connection.password", dbConfig.getPassword());
        properties.put("hibernate.show_sql", Boolean.toString(dbConfig.getShowSql()));
        properties.put("hibernate.default_schema", dbConfig.getSchema());

        install(new JpaPersistModule(dbConfig.getPersistence()).properties(properties));
        install(new LiquibaseModule());
        bind(JPAInitializer.class).asEagerSingleton();
    }

    @Provides
    @Singleton
    public JPAQueryFactory jpaQueryFactory(Provider<EntityManager> manager) {
        return new JPAQueryFactory(manager);
    }
}
