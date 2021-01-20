package com.bistu.Controller;

import com.alibaba.fastjson.JSONObject;
import com.bistu.dao.DataObjDao;
import com.bistu.pojo.DataObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class JsonController {

    @Autowired
    DataObjDao dao;

    @GetMapping("/list")
    public String list(Model model){

        model.addAttribute("emps",dao.getAll());
        return "list";
    }

    @ResponseBody
    @RequestMapping(value = "/json/data", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getByJSON(@RequestBody JSONObject jsonParam) {
        // 直接将json信息打印出来
        System.out.println(jsonParam.toJSONString());

        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "json");
        result.put("data", jsonParam);

        return result.toJSONString();
    }


    @ResponseBody
    @RequestMapping(value = "/request/data", method = RequestMethod.POST)
    public String getByRequest(HttpServletRequest request) {
        DataObj dataObj = new DataObj();
        JSONObject jsonParam = this.getJSONParam(request);


        if(jsonParam.containsKey("sn")&&jsonParam.containsKey("meter")){

            String jsonStr = JSONObject.toJSONString(jsonParam.get("meter"));
            JSONObject jsonObject = JSONObject.parseObject(jsonStr);

            if (jsonObject.containsKey("flow")&&jsonObject.containsKey("speed")
                    &&jsonObject.containsKey("total")){
                dataObj.setSn((String) jsonParam.get("sn"));
                dataObj.setMeterFlow((BigDecimal) jsonObject.get("flow"));
                dataObj.setMeterSpeed((BigDecimal) jsonObject.get("speed"));
                dataObj.setMeterTotal((BigDecimal) jsonObject.get("total"));
                dataObj.setDate(new Date());
                dao.save(dataObj);
                return "ok";
            }else {
                return "data format error";
            }

        }else {
            return "data format error";
        }

    }

    public JSONObject getJSONParam(HttpServletRequest request){
        JSONObject jsonParam = null;
        try {
            // 获取输入流
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            // 写入数据到Stringbuilder
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = streamReader.readLine()) != null) {
                sb.append(line);
            }
            jsonParam = JSONObject.parseObject(sb.toString());
            // 直接将json信息打印出来
            System.out.println(jsonParam.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonParam;
    }

}
