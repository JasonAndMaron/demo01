package com.demo01.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo01.model.CodeLanguage;
import com.demo01.service.ICodeLanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/code")
public class CodeLanguageController {

    @Resource
    private ICodeLanguageService iCodeLanguageService;

    @RequestMapping(value = "/selectCode/{id}",method= RequestMethod.GET)
    @ResponseBody
    public JSONObject selectCodeLanguage(@PathVariable("id") Integer id){

        System.out.println("CodeLanguageController.selectCodeLanguage.id : " + id);
        CodeLanguage codeLanguage = this.iCodeLanguageService.selectCodeLanguage(id);
        if(codeLanguage == null){
            codeLanguage = new CodeLanguage();
        }
        System.out.println("codeLanguage : " + codeLanguage);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",codeLanguage.getId());
        jsonObject.put("name",codeLanguage.getName());
        jsonObject.put("age",codeLanguage.getAge());
        return jsonObject;
    }

    @RequestMapping(value = "/jojo",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject jojo(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("so: ","Son,if you ever get a chance to bring mankind to its knees, do it!");
        return jsonObject;
    }
}
