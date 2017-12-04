package com.boot.service.impl;

import com.boot.dao.JDBCTemplateDemoDao;
import com.boot.dao.JPADemoRepositoryEntityManager;
import com.boot.entity.Demo;
import com.boot.mapper.DemoMappper;
import com.boot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/12/16
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 * 三种方法操作数据库
 * jpa jdbc mybatis
 */
@Component("demoService")
@Transactional
public class DemoServiceImpl implements DemoService {
    @Resource
    private JPADemoRepositoryEntityManager jpaDemoRepositoryEntityManager;
    @Resource
    private JDBCTemplateDemoDao jdbcTemplateDemoDao;
    @Autowired
    private DemoMappper demoMappper;
    @Transactional
    public void save(Demo demo){
        jpaDemoRepositoryEntityManager.save(demo);
    }
    public Demo getById(long id){
        //demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
        return jdbcTemplateDemoDao.getById(id);
    }

    @Override
    public List<Demo> likeName(String name) {
        List<Demo> list =   demoMappper.likeName(name);
        return  list;
    }
}
