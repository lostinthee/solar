package com.wwy.springboot.biz.action;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wwy.springboot.biz.domain.dto.UserDto;
import com.wwy.springboot.biz.domain.entity.User;
import com.wwy.springboot.biz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * @author wangxiaosan
 * @date 2017/09/29
 */
@Controller
@EnableAutoConfiguration
@Path("/hello")
public class HelloSpringBoot {

    @Autowired
    private UserService userService;

    private Logger log = LoggerFactory.getLogger(HelloSpringBoot.class);

    @GET
    @Path("/springBoot")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloWord() {
        String s = "this is spring boot";
        log.info("this is info log : "+s);
        log.debug("this is debug log : "+s);
        return s;
    }

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> listUser(){
        return userService.findAllUser();
    }

    public static void main(String[] args) {
        List<Map<String, String>> ls = Lists.newArrayList();
        Map<String, List<Map<String, String>>> idnumMap = Maps.newHashMap();
        if(null != ls && !ls.isEmpty()) {
            for(Map<String, String > lsMap : ls) {
                for (String lsMapKey : lsMap.keySet()) {
                    if(null == idnumMap.get(lsMapKey) || idnumMap.get(lsMapKey).isEmpty()) {
                        idnumMap.put(lsMapKey, Lists.newArrayList(lsMap));
                    } else {
                        List<Map<String, String>> maps = idnumMap.get(lsMapKey);
                        maps.add(lsMap);
                        idnumMap.put(lsMapKey, maps);
                    }
                }

            }
        }
    }
}
