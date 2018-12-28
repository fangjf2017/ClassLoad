package jvm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by fan on 2018/12/28.
 */
public class SimpleClassLoader extends URLClassLoader {
    // 中间件jar路径
    private static final String JAR_BASE_PATH = "e:/middleware/";

    public SimpleClassLoader(URL[] urls) {
        //parent 设置为null 则不会被 system classloader 加载
        super(urls, null);
        try {
            File file = new File(JAR_BASE_PATH);
            String[] arr = file.list();
            for (String jar : arr) {
                super.addURL(new URL("file:" + JAR_BASE_PATH + jar));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            return super.findClass(name);
        } catch (ClassNotFoundException e) {
            return SimpleClassLoader.class.getClassLoader().loadClass(name);
        }
    }

}
