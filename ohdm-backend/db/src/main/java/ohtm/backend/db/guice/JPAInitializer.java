package ohtm.backend.db.guice;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JPAInitializer {

    @Inject
    public JPAInitializer(final PersistService service) {
        service.start();
    }
}
