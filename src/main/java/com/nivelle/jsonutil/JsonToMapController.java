package com.nivelle.jsonutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2021/03/03
 */
@RestController
@RequestMapping(value = "/jsonUtil")
public class JsonToMapController {

    @Autowired
    JsonToMapService jsonToMapService;

    @PostMapping(value = "/toHashMap", produces = "text/plain;;charset=utf-8")
    public Object toMap(@RequestBody String jsonStr) {
        HashMap hashMap = jsonToMapService.toMap(jsonStr);
        StringBuilder stringBuilder = new StringBuilder("HashMap params = new HashMap();\n");
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = hashMap.get(key);
            stringBuilder.append("params.put(\"" + key + "\",\"" + value + "\");");
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("----------------------------------");
        stringBuilder.append("\n");
        StringBuilder stringBuilder2 = new StringBuilder("HashMap paramsRaw = new HashMap();\n");
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = hashMap.get(key);
            stringBuilder2.append("paramsRaw.put(" + key + "," + value + ");");
            stringBuilder2.append("\n");
        }
        return stringBuilder.append(stringBuilder2);
    }
}
