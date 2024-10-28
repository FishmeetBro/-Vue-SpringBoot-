# 通讯录管理系统

基于 **Vue** + **Spring Boot** 的通讯录管理系统，这是一个功能全面的工具，旨在简化个人和企业对联系人信息的管理。该系统提供主页、系统管理、公告管理和用户管理等核心功能，使用户能够轻松地进行信息添加、编辑、查询和删除操作，并通过用户友好的界面确保数据的高效和安全处理。

## 技术栈

- **Java** 8+
- **Spring Boot**
- **MySQL**
- **Vue**

---

## 功能特点

- **文件管理**：
  - 支持文件的上传、下载、删除、批量删除等操作。
  - 支持分页查询和条件查询，适应大数据量的文件管理需求。
  - 文件导出功能，便于文件列表的归档与备份。

- **公告管理**：
  - 支持公告的新增、编辑和删除，方便系统内信息通知的管理。
  - 提供公告的导入和导出功能，实现公告信息的批量管理与迁移。
  - 支持公告的分页查询和模糊查询，便于快速查找特定公告内容。

- **角色管理**：
  - 角色的创建、编辑和删除，支持角色与菜单的绑定，灵活配置用户权限。
  - 支持角色的分页查询和模糊查询，方便系统角色的集中管理。

- **用户管理**：
  - 用户的注册、登录、信息编辑、删除等操作，支持用户的批量删除。
  - 提供密码重置和修改功能，确保用户数据的安全性。
  - 支持按用户名、邮箱、地址等条件的分页查询和模糊查询，便于快速定位特定用户。

---

## 前端页面展示

- **登入界面**
  ![登入界面](https://github.com/user-attachments/assets/2b0c1f2b-a278-403b-8abf-dcf83da7b380)

- **管理员界面**
  ![管理员界面](https://github.com/user-attachments/assets/a53caaae-ab11-4a7d-a28d-a65fd6c0402b)

- **用户界面**
  ![用户界面](https://github.com/user-attachments/assets/dce7f4fc-de4f-4563-a7ec-8762041ed1e7)

---

## 快速开始（代码存放在 `master-address_vue` 分支中）

### 克隆仓库

```bash
git clone https://github.com/FishmeetBro/A-Contact-Management-System-Based-on-Vue.js-and-Spring-Boot.git
```

### 安装依赖

```bash
npm install
```

### 启动项目

```bash
npm run serve
```

### 访问项目

打开浏览器并访问 [http://localhost:8080](http://localhost:8080)

---

## 使用说明

### 1. 用户登录和注册
- 访问登录页面，输入用户名和密码以登录系统。
- 如果没有账号，可以点击注册链接，完成注册后使用新账户登录。

### 2. 联系人管理
- **添加联系人**：在联系人管理页面，点击“添加”按钮，输入联系人信息并保存。
- **编辑联系人**：选择要编辑的联系人，点击“编辑”按钮，修改信息后保存。
- **删除联系人**：选择不需要的联系人，点击“删除”按钮，确认后删除该联系人。
- **搜索联系人**：在搜索框中输入姓名，快速查找匹配的联系人。
- **分页显示**：在联系人列表底部选择页码，浏览大量联系人信息。

### 3. 公告管理
- **添加或编辑公告**：进入公告管理页面，点击“添加”或“编辑”按钮，输入公告内容并保存。
- **删除公告**：选择需要删除的公告，点击“删除”按钮进行删除。
- **公告导入与导出**：使用 Excel 文件快速批量导入或导出公告信息，便于迁移或备份。

### 4. 用户管理
- 管理系统用户，包括用户的新增、编辑和删除。
- 支持重置密码功能，用户可以自行修改或重置密码。
- 按用户名、邮箱或地址进行搜索和分页查询，便于管理大量用户。

---

## API 说明

### 1. 文件管理

- **获取文件列表**  
  - **请求**: `GET /file/page`  
  - **参数**:  
    - `pageNum`（页码）  
    - `pageSize`（每页数量）  
    - `name`（文件名，模糊查询）  

- **上传文件**  
  - **请求**: `POST /file/upload`  
  - **请求体**: 文件（`MultipartFile`）

- **下载文件**  
  - **请求**: `GET /file/{fileUUID}`  
  - **参数**:  
    - `fileUUID`（文件的唯一标识符）

- **更新文件信息**  
  - **请求**: `POST /file/update`  
  - **请求体**: 文件信息（JSON 格式，包含 ID）

- **删除文件**  
  - **请求**: `DELETE /file/{id}`  
  - **参数**:  
    - `id`（文件 ID）

### 2. 公告管理

- **获取公告列表**  
  - **请求**: `GET /notice/page`  
  - **参数**:  
    - `pageNum`（页码）  
    - `pageSize`（每页数量）  
    - `name`（公告名称，模糊查询）  

- **新增公告**  
  - **请求**: `POST /notice`  
  - **请求体**: 公告信息（JSON 格式）

- **编辑公告**  
  - **请求**: `PUT /notice`  
  - **请求体**: 公告信息（包含 ID）

- **删除公告**  
  - **请求**: `DELETE /notice/{id}`  
  - **参数**:  
    - `id`（公告 ID）

- **导出公告**  
  - **请求**: `GET /notice/export`

- **导入公告**  
  - **请求**: `POST /notice/import`  
  - **请求体**: 文件（`MultipartFile`）

### 3. 角色管理

- **获取角色列表**  
  - **请求**: `GET /role/page`  
  - **参数**:  
    - `pageNum`（页码）  
    - `pageSize`（每页数量）  
    - `name`（角色名称，模糊查询）  

- **新增或编辑角色**  
  - **请求**: `POST /role`  
  - **请求体**: 角色信息（JSON 格式）

- **删除角色**  
  - **请求**: `DELETE /role/{id}`  
  - **参数**:  
    - `id`（角色 ID）

- **绑定角色与菜单**  
  - **请求**: `POST /role/roleMenu/{roleId}`  
  - **路径参数**:  
    - `roleId`（角色 ID）  
  - **请求体**: 菜单 ID 列表（JSON 格式）

- **获取角色菜单权限**  
  - **请求**: `GET /role/roleMenu/{roleId}`  
  - **路径参数**:  
    - `roleId`（角色 ID）

### 4. 用户管理

- **获取用户列表**  
  - **请求**: `GET /user/page`  
  - **参数**:  
    - `pageNum`（页码）  
    - `pageSize`（每页数量）  
    - `username`（用户名，模糊查询）  
    - `email`（用户邮箱，模糊查询）  
    - `address`（用户地址，模糊查询）  

- **新增或编辑用户**  
  - **请求**: `POST /user`  
  - **请求体**: 用户信息（JSON 格式）

- **删除用户**  
  - **请求**: `DELETE /user/{id}`  
  - **参数**:  
    - `id`（用户 ID）

- **登录**  
  - **请求**: `POST /user/login`  
  - **请求体**: 用户登录信息（JSON 格式，包含用户名和密码）

- **注册**  
  - **请求**: `POST /user/register`  
  - **请求体**: 用户注册信息（JSON 格式，包含用户名和密码）

- **重置密码**  
  - **请求**: `PUT /user/reset`  
  - **请求体**: 用户信息（JSON 格式，包含用户名和手机号）

---

## 后端部分

代码存放在 `master-address_Springboot` 分支中，以下是后端的主要目录结构：

```plaintext
com.example.Application             # 启动类
com.example.controller.UserController # 用户管理的 RESTful API 控制器
com.example.service.UserService      # 业务逻辑处理层
com.example.dao.UserRepository       # 数据访问层
com.example.entity.User              # 用户实体类
```

### 安装与运行

#### 克隆项目

```bash
git clone

 https://github.com/FishmeetBro/A-Contact-Management-System-Based-on-Vue.js-and-Spring-Boot.git
```

#### 配置数据库

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

#### 运行项目

```bash
mvn spring-boot:run
```

### API 访问

项目启动后，访问 `http://localhost:9090` 进行接口调用。

---

## 联系方式

如有任何问题，请联系：2545997627@qq.com
