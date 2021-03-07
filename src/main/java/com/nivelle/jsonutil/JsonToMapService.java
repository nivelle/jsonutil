package com.nivelle.jsonutil;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2021/03/03
 */
@Service
public class JsonToMapService {

    public HashMap<String, Object> toMap(String jsonStr) {
        HashMap hashMap = GsonUtils.fromJsonFormat(jsonStr, HashMap.class);
        System.out.println("这个是用JSON类,指定解析类型，来解析JSON字符串!!!");
        for (Object obj : hashMap.keySet()) {
            System.out.println("key为：" + obj + "值为：" + hashMap.get(obj));
        }
        return hashMap;

    }
}
