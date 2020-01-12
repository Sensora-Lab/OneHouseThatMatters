package ohtm.backend.db.dao

import be.janbols.spock.extension.dbunit.DbUnit
import com.google.inject.Guice
import ohtm.backend.db.config.DbConfig
import org.testcontainers.containers.PostgreSQLContainer
import spock.lang.Specification

import javax.inject.Inject
import javax.sql.DataSource

abstract class AbstractDaoTest extends Specification {

    PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>("postgres:11")

    @Inject
    DataSource dataSource

    @DbUnit(schema = 'public')
    def content = {}

    def setup() {

        DbConfig dbConfig = Mock {
            getUsername() >> postgreSQLContainer.getUsername()
            getPassword() >> postgreSQLContainer.getPassword()
            getUrl() >> postgreSQLContainer.getJdbcUrl()
            getDriver() >> postgreSQLContainer.getDriverClassName()
            getShowSql() >> false
            getPersistence() >> "postgres_pu"
            getSchema() >> "public"
        }

        Guice.createInjector(new TestDbModule(dbConfig)).injectMembers(this)
    }

}