package org.test.db;

import javax.persistence.*;

/**
 * User实体类
 * @author liuyt
 * @date  2014-10-30 下午2:27:37
 */
@Entity
@Table(name="user_test")
public class UserTest {
    /**
     * 主键序列：DEFAULT_SUQUENCE 是我在oracle数据库中创建的一个序列
     *           MY_SUQUENCE 是给自定义的序列创建一个引用名称
     * 指我的主键生成策略 MY_SUQUENCE 使用的是 DEFAULT_SUQUENCE 这个序列。
     */
    @SequenceGenerator(name = "MY_SUQUENCE", sequenceName = "DEFAULT_SUQUENCE")
    @Id
    @GeneratedValue(generator="MY_SUQUENCE")
    private Long id;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="USER_PASSWORD")
    private String passWord;

    /*************GET****************SET***************/
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    @Override
    public String toString() {
        return "UserTest [id=" + id + ", userName=" + userName + ", passWord="
                + passWord + "]";
    }
}