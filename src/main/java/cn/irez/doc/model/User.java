package cn.irez.doc.model;

import lombok.Data;

/**
 * User用户实体类
 */
@Data
public class User {

    /** id */
    private Long id;

    /** 用户名 */
    private String username;

    /** 公司 */
    private String company;

    /** 邮箱 */
    private String mail;
}
