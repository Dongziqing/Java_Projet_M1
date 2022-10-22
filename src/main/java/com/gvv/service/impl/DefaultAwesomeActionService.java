package com.gvv.service.impl;

import com.gvv.service.AwesomeActionService;
import org.springframework.stereotype.Component;

@Component
public class DefaultAwesomeActionService implements AwesomeActionService {

    @Override
    public String processName(final String name) {
        if(name.equals("徐梦瑶")) {
            return "傻逼你好!";
        }
        else {
            return "Unknown Stranger!";
        }
    }

}
