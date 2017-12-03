package org.test.db.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.test.db.UserTest;

/**
 * 持久层接口
 * @author liuyt
 * @date  2014-10-30 下午2:09:48
 */
/*
 Repository：是 Spring Data的一个核心接口，它不提供任何方法，开发者需要在自己定义的接口中声明需要的方法

public interface Repository<T, ID extends Serializable> {
}

------------------------------
CrudRepository：继承Repository，提供增删改查方法，可以直接调用

@NoRepositoryBean
public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {
    <S extends T> S save(S var1);

    <S extends T> Iterable<S> save(Iterable<S> var1);

    T findOne(ID var1);

    boolean exists(ID var1);

    Iterable<T> findAll();

    Iterable<T> findAll(Iterable<ID> var1);

    long count();

    void delete(ID var1);

    void delete(T var1);

    void delete(Iterable<? extends T> var1);

    void deleteAll();
}
-------------------------------------
PagingAndSortingRepository：继承CrudRepository，具有分页查询和排序功能
@NoRepositoryBean
public interface PagingAndSortingRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
    Iterable<T> findAll(Sort var1);

    Page<T> findAll(Pageable var1);
}

-------------------------------------
JpaRepository： 继承PagingAndSortingRepository，针对JPA技术提供的接口
@NoRepositoryBean
public interface JpaRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {
    List<T> findAll();

    List<T> findAll(Sort var1);

    List<T> findAll(Iterable<ID> var1);

    <S extends T> List<S> save(Iterable<S> var1);

    void flush();

    <S extends T> S saveAndFlush(S var1);

    void deleteInBatch(Iterable<T> var1);

    void deleteAllInBatch();

    T getOne(ID var1);

    <S extends T> List<S> findAll(Example<S> var1);

    <S extends T> List<S> findAll(Example<S> var1, Sort var2);
}

----------------------------------------
还可以单独实现另外一个接口，支持原生sql：
public interface JpaSpecificationExecutor<T> {
    T findOne(Specification<T> var1);

    List<T> findAll(Specification<T> var1);

    Page<T> findAll(Specification<T> var1, Pageable var2);

    List<T> findAll(Specification<T> var1, Sort var2);

    long count(Specification<T> var1);
}

------------------------------------------
JpaRespostiory还自动继承另一个接口：
public interface QueryByExampleExecutor<T> {
    <S extends T> S findOne(Example<S> var1);

    <S extends T> Iterable<S> findAll(Example<S> var1);

    <S extends T> Iterable<S> findAll(Example<S> var1, Sort var2);

    <S extends T> Page<S> findAll(Example<S> var1, Pageable var2);

    <S extends T> long count(Example<S> var1);

    <S extends T> boolean exists(Example<S> var1);
}


 */
@Repository
public interface IUserDao extends JpaRepository<UserTest, Long> {
    /**
     * 通过前面的配置可以看出，Spring 对 JPA 的支持已经非常强大，开发者无需过多关注 EntityManager 的创建、事务处理等 JPA 相关的处理
     * ***********************************************************************
     * 然而spring对Jpa的支持不止于此，它要从根本上来简化我们的业务代码                        **
     * 在没用使用jpa支持的时候，我们的代码应该是这样的：                                    **
     *     1、IUserDao   持久层接口                                                **
     *     2、IUserDaoImpl   持久层实现类                                            **
     *     3、IUserService    业务层接口.....后面不在列举                                    **
     * 每写一个实体类，都要衍生出5、6个类来对他进行操作，即使有了注解，我们可以依赖注入方式来拿到实现类，    **
     * 但是通用的CRUD等操作却不免在每个实现类里声明，你又说，我可以定义一个父类，利用泛型反射原理就可以了，    **
     * 但那样你还需要为每个Dao声明自己的实现类来继承你的父类                                    **
     * ***********************************************************************
     * 那么问题来了...（不是挖掘机技术）对持久层的简化技术哪家强？      Spring Data Jpa            **
     * 你唯一要做的就只是声明持久层的接口，来继承他自身已经封装好的持久层接口，正如本类IUserDao一样        **
     * 可使用的接口有：                                                            **********
     *　    Repository：是 Spring Data的一个核心接口，它不提供任何方法，开发者需要在自己定义的接口中声明需要的方法。**
     *     CrudRepository：继承Repository，提供增删改查方法，可以直接调用。                            **
     *     PagingAndSortingRepository：继承CrudRepository，具有分页查询和排序功能（本类实例）        **
     *     JpaRepository：                         继承PagingAndSortingRepository，针对JPA技术提供的接口            **
     *     JpaSpecificationExecutor：          可以执行原生SQL查询                                    **
     *    继承不同的接口，有两个不同的泛型参数，他们是该持久层操作的类对象和主键类型。                            **
     *********************************************************************************
     */
}