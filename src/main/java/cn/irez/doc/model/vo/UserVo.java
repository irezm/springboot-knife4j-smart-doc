package cn.irez.doc.model.vo;

import cn.irez.doc.model.User;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class UserVo {

    /** 班级Id */
    private Integer classId;

    /** 班级名称 */
    private String className;

    /** 班级学生,你就假装是学生呗 */
    private List<User> userList;
}
