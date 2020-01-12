package ohtm.backend.db.dao


import com.google.inject.AbstractModule
import ohtm.backend.db.config.DbConfig
import ohtm.backend.db.guice.DbModule

class TestDbModule extends AbstractModule {

    private final DbConfig dbConfig

    TestDbModule(DbConfig dbConfig) {
        this.dbConfig = dbConfig
    }


    @Override
    protected void configure() {

        bind(DbConfig.class).toInstance(dbConfig)

        install(new DbModule(dbConfig))
    }
}
