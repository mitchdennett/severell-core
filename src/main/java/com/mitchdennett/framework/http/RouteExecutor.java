package com.mitchdennett.framework.http;

import com.mitchdennett.framework.container.Container;

import java.util.ArrayList;

public class RouteExecutor {

    @FunctionalInterface
    public interface RouteFunction {
        void apply(Request request, Response response, Container container) throws Exception;
    }

    private final RouteFunction func;
    private final ArrayList<MiddlewareExecutor> middleware;
    public String path;
    public String httpMethod;

    public RouteExecutor(String path, String httpMethod, RouteFunction func) {
        this.path = path;
        this.httpMethod = httpMethod;
        this.func = func;
        this.middleware = null;
    }

    public RouteExecutor(String path, String httpMethod, ArrayList<MiddlewareExecutor> middleware, RouteExecutor.RouteFunction func) {
        this.path = path;
        this.httpMethod = httpMethod;
        this.func = func;
        this.middleware = middleware;
    }

    public void execute(Request request, Response response, Container cont) throws Exception {
        func.apply(request, response, cont);
    }

    public RouteFunction getFunc() {
        return func;
    }

    public String getPath() {
        return path;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public ArrayList<MiddlewareExecutor> getMiddleware() {
        return this.middleware;
    }
}
