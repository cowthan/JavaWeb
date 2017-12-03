package org.test.db.jpa;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.test.db.UserTest;

/**
 * User业务层，依赖持久层  IUserDao
 * @author liuyt
 * @date  2014-10-30 下午2:37:21
 */
@Service
public class UserService {
    // 推荐用Resource来替代AutoWrite注解
    @Resource
    private IUserDao userDao;

    // 新增用户
    public void saveUser(UserTest user) {
        userDao.save(user);
    }

    // 删除用户，参数也可以为一个含有id的User对象
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    // 查询所有user对象，findOne为查询单个
    public List<UserTest> findAllUsers() {
        return (List<UserTest>) userDao.findAll();
    }

    /**
     * 根据一个分页对象查询user集合（还可以添加一个Store排序属性）
     * PageRequest    是spring自己封装的请求分页类，实现了Pageable接口，包涵从请求中获得的分页属性（当前页和大小）和获取方法
     * 通过调用分页方法，返回一个Page<>一个泛型集合的分页对象，里面包涵了通过查询计算出的各个属性和结果集
     * 详细类结构和属性请参阅源码
     * @param page
     * @return
     */
    public Page<UserTest> findAllUserByPage(PageRequest page) {
        return (Page<UserTest>) userDao.findAll(page);
    }
}