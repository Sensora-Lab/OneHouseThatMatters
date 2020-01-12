package ohtm.backend.db.config;

public interface DbConfig {
    String getUsername();

    String getPassword();

    String getUrl();

    String getDriver();

    boolean getShowSql();

    String getPersistence();

    String getSchema();
}
