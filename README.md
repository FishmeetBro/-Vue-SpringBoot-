# 通讯录管理系统

基于 **Vue** + **Spring Boot** 的通讯录管理系统，这是一个功能全面的工具，旨在简化个人和企业对联系人信息的管理。该系统提供主页、系统管理、公告管理和用户管理等核心功能，使用户能够轻松地进行信息添加、编辑、查询和删除操作，并通过用户友好的界面确保数据的高效和安全处理。

## 技术栈

- **Java** 8+
- **Spring Boot**
- **MySQL**

## 目录结构

```plaintext
com.example.Application             # 启动类
com.example.controller.UserController # 用户管理的 RESTful API 控制器
com.example.service.UserService      # 业务逻辑处理层
com.example.dao.UserRepository       # 数据访问层
com.example.entity.User              # 用户实体类
```

## 安装与运行

### 克隆项目

```bash
git clone https://github.com/FishmeetBro/A-Contact-Management-System-Based-on-Vue.js-and-Spring-Boot.git
```

### 配置数据库

在 `application.yml` 中设置 MySQL 数据库连接信息：

```yaml
server:
  port: 9090
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/smart_address_book?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true
    username: root
    password: 123456
```

### 运行项目

```bash
mvn spring-boot:run
```

## API 访问

项目启动后，访问 `http://localhost:9090` 进行接口调用。

# 接口文档

## 1. 文件管理接口 (`FileController`)

### 文件上传
- **URL**: `POST /file/upload`
- **请求方法**: `POST`
- **请求参数**: `file`（`MultipartFile`）
- **描述**: 接收文件并保存到服务器。若文件已存在（MD5校验），返回已有文件的 URL，否则存储新文件。
- **返回值**: 文件 URL

### 文件下载
- **URL**: `GET /file/{fileUUID}`
- **请求方法**: `GET`
- **路径参数**: `fileUUID`（`String`）：文件的唯一标识符
- **描述**: 根据文件唯一标识符下载文件，返回文件流。

### 更新文件信息
- **URL**: `POST /file/update`
- **请求方法**: `POST`
- **请求体**: `Files` 对象
- **描述**: 更新文件信息。

### 删除文件
- **URL**: `DELETE /file/{id}`
- **请求方法**: `DELETE`
- **路径参数**: `id`（`Integer`）：文件 ID
- **描述**: 逻辑删除指定 ID 文件。

### 批量删除文件
- **URL**: `POST /file/del/batch`
- **请求方法**: `POST`
- **请求体**: `List<Integer>`（文件 ID 列表）
- **描述**: 批量逻辑删除文件。

### 分页查询文件
- **URL**: `GET /file/page`
- **请求方法**: `GET`
- **请求参数**:
  - `pageNum`（`Integer`）：页码
  - `pageSize`（`Integer`）：每页数量
  - `name`（`String`）：文件名（模糊查询）
- **描述**: 分页查询文件列表，按名称模糊查询。

---

## 2. 公告管理接口 (`NoticeController`)

### 新增或更新公告
- **URL**: `POST /notice`
- **请求方法**: `POST`
- **请求体**: `Notice` 对象
- **描述**: 新增或更新公告。

### 删除公告
- **URL**: `DELETE /notice/{id}`
- **请求方法**: `DELETE`
- **路径参数**: `id`（`Integer`）：公告 ID
- **描述**: 删除指定公告。

### 批量删除公告
- **URL**: `POST /notice/del/batch`
- **请求方法**: `POST`
- **请求体**: `List<Integer>`（公告 ID 列表）
- **描述**: 批量删除公告。

### 查询所有公告
- **URL**: `GET /notice`
- **请求方法**: `GET`
- **描述**: 查询所有公告。

### 查询单个公告
- **URL**: `GET /notice/{id}`
- **请求方法**: `GET`
- **路径参数**: `id`（`Integer`）：公告 ID
- **描述**: 根据 ID 查询公告。

### 分页查询公告
- **URL**: `GET /notice/page`
- **请求方法**: `GET`
- **请求参数**:
  - `name`（`String`）：公告名称（模糊查询）
  - `pageNum`（`Integer`）：页码
  - `pageSize`（`Integer`）：每页数量
- **描述**: 分页查询公告，按名称模糊查询。

### 导出公告
- **URL**: `GET /notice/export`
- **请求方法**: `GET`
- **描述**: 导出公告列表至 Excel 文件。

### 导入公告
- **URL**: `POST /notice/import`
- **请求方法**: `POST`
- **请求参数**: `file`（`MultipartFile`）
- **描述**: 从 Excel 文件导入公告数据。

---

## 3. 角色管理接口 (`RoleController`)

### 新增或更新角色
- **URL**: `POST /role`
- **请求方法**: `POST`
- **请求体**: `Role` 对象
- **描述**: 新增或更新角色。

### 删除角色
- **URL**: `DELETE /role/{id}`
- **请求方法**: `DELETE`
- **路径参数**: `id`（`Integer`）：角色 ID
- **描述**: 删除指定角色。

### 批量删除角色
- **URL**: `POST /role/del/batch`
- **请求方法**: `POST`
- **请求体**: `List<Integer>`（角色 ID 列表）
- **描述**: 批量删除角色。

### 查询所有角色
- **URL**: `GET /role`
- **请求方法**: `GET`
- **描述**: 查询所有角色。

### 查询单个角色
- **URL**: `GET /role/{id}`
- **请求方法**: `GET`
- **路径参数**: `id`（`Integer`）：角色 ID
- **描述**: 查询指定角色。

### 分页查询角色
- **URL**: `GET /role/page`
- **请求方法**: `GET`
- **请求参数**:
  - `name`（`String`）：角色名称（模糊查询）
  - `pageNum`（`Integer`）：页码
  - `pageSize`（`Integer`）：每页数量
- **描述**: 分页查询角色，按名称模糊查询。

### 绑定角色与菜单
- **URL**: `POST /role/roleMenu/{roleId}`
- **请求方法**: `POST`
- **路径参数**: `roleId`（`Integer`）：角色 ID
- **请求体**: `List<Integer>`（菜单 ID 列表）
- **描述**: 为角色绑定菜单。

### 获取角色的菜单关系
- **URL**: `GET /role/roleMenu/{roleId}`
- **请求方法**: `GET`
- **路径参数**: `roleId`（`Integer`）：角色 ID
- **描述**: 查询角色的菜单权限关系。

---

## 4. 用户管理接口 (`UserController`)

### 用户登录
- **URL**: `POST /user/login`
- **请求方法**: `POST`
- **请求体**: `UserDTO` 对象（包含 `username` 和 `password`）
- **描述**: 用户登录验证。

### 用户注册
- **URL**: `POST /user/register`
- **请求方法**: `POST`
- **请求体**: `UserDTO` 对象（包含 `username` 和 `password`）
- **描述**: 注册新用户。

### 新增或更新用户
- **URL**: `POST /user`
- **请求方法**: `POST`
- **请求体**: `User` 对象
- **描述**: 新增或更新用户信息。

### 修改密码
- **URL**: `POST /user/password`
- **请求方法**: `POST`
- **请求体**: `UserPasswordDTO` 对象
- **描述**: 修改用户密码。

### 重置密码
- **URL**: `PUT /user/reset`
- **请求方法**: `PUT`
- **请求体**: `UserPasswordDTO` 对象（包含 `username` 和 `phone`）
- **描述**: 重置用户密码为默认值 `123`。

### 删除用户
- **URL**: `DELETE /user/{id}`
- **请求方法**: `DELETE`
- **路径参数**: `id`（`Integer`）：用户 ID
- **描述**: 删除指定用户。

### 批量删除用户
- **URL**: `POST /user/del/batch`
- **请求方法**: `POST`
- **请求体**: `List<Integer>`（用户 ID 列表）
- **描述**: 批量删除用户。

### 查询所有用户
- **URL**: `GET /user`
- **请求方法**: `GET`
- **描述**: 获取所有用户列表。

### 查询单个用户
- **URL**: `GET /user/{id}`
- **请求方法**: `GET`
- **路径参数**: `id`（`Integer`）：用户 ID
- **描述**: 查询指定用户。

### 根据用户名查询用户
- **URL**: `GET /user/username/{username}`
- **请求方法**: `GET`
- **路径参数**: `username`（`String`）：用户名
- **描述**: 查询指定用户名的用户信息。

### 分页查询用户
- **URL**: `GET /user/page`
- **请求方法**: `GET`
- **请求参数**:
  - `pageNum`（`Integer`）：页码
  - `pageSize`（`Integer`）：每页数量
  - `username`（`String`）：用户名（模糊查询）
  - `email`（`String`）：用户邮箱（模糊查询）
  - `address`（`String`）：用户地址（模糊查询）
- **描述**: 分页查询用户列表，可按用户名、邮箱、地址模糊查询。

联系方式
如有任何问题，请联系1295321006@qq.com
