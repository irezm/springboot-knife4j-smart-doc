# 百草味 - api文档
Version |  Update Time  | Status | Author |  Description
---|---|---|---|---
v2021-11-04 21:47:58|2021-11-04 21:47:58|auto|@zi|Created by smart-doc



## User 用户接口
### 获得用户对象
**URL:** http://127.0.0.1:9090/userInfo

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获得用户对象

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|desc|true|-


**Request-example:**
```
curl -X GET -H 'token:leon' -i http://127.0.0.1:9090/userInfo
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|消息|-
data|array|数据|-
└─id|int32|id|-
└─username|string|用户名|-
└─company|string|公司|-
└─mail|string|邮箱|-

**Response-example:**
```
{
  "code": 525,
  "msg": "legy7w",
  "data": [
    {
      "id": 391,
      "username": "monroe.connelly",
      "company": "Boyer-Kling",
      "mail": "r11ugb"
    }
  ]
}
```

### 根据Id获得用户信息
**URL:** http://127.0.0.1:9090/userInfoById

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据Id获得用户信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|desc|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|用户Id|false|-

**Request-example:**
```
curl -X GET -H 'token:leon' -i http://127.0.0.1:9090/userInfoById?id=110
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|消息|-
data|object|数据|-
└─id|int32|id|-
└─username|string|用户名|-
└─company|string|公司|-
└─mail|string|邮箱|-

**Response-example:**
```
{
  "code": 800,
  "msg": "4q4ka2",
  "data": {
    "id": 963,
    "username": "monroe.connelly",
    "company": "Boyer-Kling",
    "mail": "rpgmo6"
  }
}
```

### 根据班级Id,与学生名称获得数据
**URL:** http://127.0.0.1:9090/classByIdUsername

**Type:** POST


**Content-Type:** application/json; charset=utf-8

**Description:** 根据班级Id,与学生名称获得数据

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|desc|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
classId|int32|班级Id|false|-
nameList|array|学生名称|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -H 'token:leon' -i http://127.0.0.1:9090/classByIdUsername --data '{
  "classId": 783,
  "nameList": [
    "fvseal"
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|消息|-
data|object|数据|-
└─classId|int32|班级Id|-
└─className|string|班级名称|-
└─userList|array|班级学生,你就假装是学生呗|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int32|id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─username|string|用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─company|string|公司|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mail|string|邮箱|-

**Response-example:**
```
{
  "code": 542,
  "msg": "7uwk38",
  "data": {
    "classId": 217,
    "className": "monroe.connelly",
    "userList": [
      {
        "id": 548,
        "username": "monroe.connelly",
        "company": "Boyer-Kling",
        "mail": "ehmmc9"
      }
    ]
  }
}
```

## 错误码列表
Error code |Description
---|---
200|成功
400|错误请求
401|未经授权
500|内部服务器错误

## 数据字典
### http状态码字典

Code |Type|Description
---|---|---
200|int32|成功
400|int32|错误请求
401|int32|未经授权
500|int32|内部服务器错误
