package cn.irez.doc.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    /** 班级Id */
    private Integer classId;

    /** 学生名称 */
    private List<String> nameList;
}
