DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    uuid            CHAR(36)     NOT NULL UNIQUE COMMENT '对外暴露ID（防遍历）',
    username        VARCHAR(50)  NOT NULL UNIQUE COMMENT '登录账号',
    password        VARCHAR(100) NOT NULL COMMENT '加密密码',
    status          TINYINT(1) DEFAULT 1 COMMENT '状态（1启用 0禁用）',
    last_login_ip   VARCHAR(45) COMMENT '最后登录IP',
    last_login_time DATETIME COMMENT '最后登录时间',
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


DROP TABLE IF EXISTS sys_user_auth;
CREATE TABLE sys_user_auth
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id       BIGINT       NOT NULL COMMENT '关联用户ID',
    identity_type VARCHAR(20)  NOT NULL COMMENT '认证类型：local/weixin/phone',
    identifier    VARCHAR(255) NOT NULL COMMENT '标识（如手机号/openid）',
    credential    VARCHAR(255) NOT NULL COMMENT '凭证（加密密码/令牌）',
    verified      TINYINT(1) DEFAULT 0 COMMENT '是否已验证',
    FOREIGN KEY (user_id) REFERENCES sys_user (id),
    UNIQUE KEY idx_type_identity (identity_type, identifier)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    role_key   VARCHAR(30) NOT NULL UNIQUE COMMENT '角色标识（admin/user）',
    name       VARCHAR(50) NOT NULL COMMENT '角色名称',
    data_scope TINYINT COMMENT '数据权限范围'
) ENGINE = InnoDB;

CREATE TABLE sys_permission
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    perm_key VARCHAR(100) NOT NULL COMMENT '权限标识（system:user:query）',
    name     VARCHAR(100) NOT NULL COMMENT '权限名称',
    type     TINYINT COMMENT '类型（1菜单 2按钮 3接口）'
) ENGINE = InnoDB;

DROP TABLE IF EXISTS sys_user_role;
-- 用户-角色关联
CREATE TABLE sys_user_role
(
    user_id BIGINT NOT NULL,
    role_id INT    NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES sys_user (id),
    FOREIGN KEY (role_id) REFERENCES sys_role (id)
);

DROP TABLE IF EXISTS sys_role_permission;
-- 角色-权限关联
CREATE TABLE sys_role_permission
(
    role_id INT NOT NULL,
    perm_id INT NOT NULL,
    PRIMARY KEY (role_id, perm_id)
) ENGINE = InnoDB;
