package org.test.db.jpa;

import org.springframework.data.domain.*;
import org.test.db.UserTest;

import javax.annotation.Resource;
import java.util.List;

public class BaseService {


    // 推荐用Resource来替代AutoWrite注解
    @Resource
    private IUserDao userDao;



    // --------------------------------insert && update-------------------------- //
    public void save(UserTest user) {
        userDao.save(user);
    }

    public void save(List<UserTest> users){
        userDao.save(users);
    }


    public void flush(){
        userDao.flush();
    }

    public void saveAndFlush(UserTest var1){
        userDao.saveAndFlush(var1);
    }

    // -------------------------------delete--------------------------------------- //
    public  void delete(Long id){
        userDao.delete(id);
    }

    public void delete(UserTest var1){
        userDao.delete(var1);
    }

    public void delete(Iterable<UserTest> var1){
        userDao.delete(var1);
    }

    public  void deleteAll(){
        userDao.deleteAll();
    }

    public void deleteInBatch(Iterable<UserTest> var1){
        userDao.deleteInBatch(var1);
    }

    public void deleteAllInBatch(){
        userDao.deleteAllInBatch();
    }

    // --------------------------------- exists ---------------------- //
    public boolean exists(Long var1){
        return userDao.exists(var1);
    }

    //---------------------------------- count ----------------------//
    public long count(){
        return userDao.count();
    }

    // ------------------------------- query one ------------------------//
    public UserTest findOne(Long id){
        return userDao.findOne(id);
    }

    public UserTest getOne(Long var1){
        return userDao.getOne(var1);
    }

    // ------------------------------- query list ------------------------//
    public List<UserTest> findAll(){
        return userDao.findAll();
    }

    public List<UserTest> findAll(Sort var1){
        return userDao.findAll(var1);
    }

    public  Page<UserTest> findAll(Pageable var1){
        return userDao.findAll(var1);
    }

    public List<UserTest> findAll(Iterable<Long> ids){
        return userDao.findAll(ids);
    }

    public List<UserTest> findAll(Example<UserTest> var1){
        return userDao.findAll(var1);
    }

    public List<UserTest> findAll(Example<UserTest> var1, Sort var2){
        return userDao.findAll(var1, var2);
    }


}
