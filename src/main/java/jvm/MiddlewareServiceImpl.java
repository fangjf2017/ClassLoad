package jvm;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by fan on 2018/12/28.
 */
@Service
public class MiddlewareServiceImpl implements IMiddlewareService {

    @Override
    public String reverse(String str) {
        if (str == null) {
            return null;
        } else {
            return StringUtils.reverse(str);
        }
    }
}
