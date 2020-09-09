package com.mitchdennett.framework.providers;

import com.mitchdennett.framework.config.Config;
import com.mitchdennett.framework.container.Container;
import com.mitchdennett.framework.drivers.Session;
import com.mitchdennett.framework.drivers.SessionMemoryDriver;
import com.mitchdennett.framework.managers.SessionManager;

public class SessionProvider extends ServiceProvider {

    public SessionProvider(Container c) {
        super(c);
    }

    @Override
    public void register() {
        this.c.bind("SessionMemoryDriver", (container) -> new SessionMemoryDriver());
        this.c.singleton(SessionManager.class, new SessionManager(this.c));
    }

    @Override
    public void boot() {
        this.c.bind(Session.class,  (container) -> container.make(SessionManager.class).create_driver(Config.get("SESSION_DRIVER")));
    }
}
