package cn.irez.doc.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * User用户实体类
 */
@Data
@Accessors(chain = true)
public class User {

    /** id */
    private Integer id;

    /** 用户名 */
    private String username;

    /** 公司 */
    private String company;

    /** 邮箱 */
    private String mail;
}
