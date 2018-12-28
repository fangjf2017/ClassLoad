package jvm;

import org.springframework.beans.factory.FactoryBean;

import java.net.URL;


/**
 * Created by fan on 2018/12/28.
 */
public class MiddlewareServiceFactory implements FactoryBean<IMiddlewareService> {

    private SimpleClassLoader simpleClassLoader = new SimpleClassLoader(new URL[0]);


    public IMiddlewareService getObject() throws Exception {
        Class clazz = simpleClassLoader.loadClass("jvm.MiddlewareServiceImpl");
        //转型为 systemclassloader 加载的接口类
        return (IMiddlewareService) clazz.newInstance();
    }

    public Class<?> getObjectType() {
        return IMiddlewareService.class;
    }

    public boolean isSingleton() {
        return false;
    }
}