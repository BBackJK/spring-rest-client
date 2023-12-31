package test.bbackjk.http.core.proxy;

import test.bbackjk.http.core.interfaces.HttpAgent;
import test.bbackjk.http.core.interfaces.ResponseMapper;
import test.bbackjk.http.core.wrapper.RestClientInvoker;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RestClientProxyFactory<T> {

    private final Map<Method, RestClientInvoker> cachedMethod = new ConcurrentHashMap<>();
    private final Class<T> restClientInterface;
    private final HttpAgent httpAgent;
    private final ResponseMapper dataMapper;

    public RestClientProxyFactory(Class<T> restClientInterface, HttpAgent httpAgent, ResponseMapper dataMapper) {
        this.restClientInterface = restClientInterface;
        this.httpAgent = httpAgent;
        this.dataMapper = dataMapper;
    }

    public Class<T> getRestClientInterface() {
        return this.restClientInterface;
    }

    public Map<Method, RestClientInvoker> getCachedMethod() {
        return this.cachedMethod;
    }

    @SuppressWarnings("unchecked")
    protected T newInstance(RestClientProxy<T> restClientProxy) {
        return (T) Proxy.newProxyInstance(
                this.restClientInterface.getClassLoader()
                , new Class[]{ this.restClientInterface }
                , restClientProxy
            );
    }

    public T newInstance() {
        return newInstance(
                new RestClientProxy<>(this.restClientInterface, this.cachedMethod, this.httpAgent, this.dataMapper)
        );
    }
}
