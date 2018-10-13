package com.demo01.service.Impl;

import com.demo01.dao.ICodeLanguageDao;
import com.demo01.model.CodeLanguage;
import com.demo01.service.ICodeLanguageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("codeService")
public class CodeLanguageImpl implements ICodeLanguageService {

    @Resource
    private ICodeLanguageDao iCodeLanguageDao;

    public CodeLanguage selectCodeLanguage(int id){
        return this.iCodeLanguageDao.selectCodeLanguage(id);
    }
}
