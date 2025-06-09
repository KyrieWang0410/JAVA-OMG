-- 密码统一使用 BCrypt 加密（强度12），明文为 "P@ssw0rd123"
INSERT INTO sys_user (uuid, username, password, status, last_login_ip, last_login_time)
VALUES ('550e8400-e29b-41d4-a716-446655440000', 'admin', '$2a$12$K9Vc8g2sRcXJYY5hRWQz0e', 1, '192.168.1.100',
        '2025-06-09 10:30:00'),
       ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'user_zhang', '$2a$12$Fd3jH7pOqAeB5nN8vY6Zze', 1, '110.185.250.101',
        '2025-06-09 09:15:00'),
       ('6ba7b811-9dad-11d1-80b4-00c04fd430c9', 'user_li', '$2a$12$Lk5tG7rPxYtHjM1nB2V3De', 0, NULL, NULL);

-- 包含本地密码、手机号、微信三种认证方式
INSERT INTO sys_user_auth (user_id, identity_type, identifier, credential, verified)
VALUES (1, 'local', 'admin', '$2a$12$K9Vc8g2sRcXJYY5hRWQz0e', 1),       -- 本地密码
       (2, 'phone', '13800138000', '$2a$12$Fd3jH7pOqAeB5nN8vY6Zze', 1), -- 手机号登录
       (2, 'weixin', 'wx_openid_abcd123', 'encrypted_refresh_token_xyz', 1);
-- 微信登录

-- 定义三种角色及数据权限范围
INSERT INTO sys_role (role_key, name, data_scope)
VALUES ('ROLE_ADMIN', '系统管理员', 1), -- 1=全部数据权限
       ('ROLE_USER', '普通用户', 2);
-- 2=仅本人数据权限


-- 权限类型：1=菜单，2=按钮，3=接口
INSERT INTO sys_permission (perm_key, name, type)
VALUES ('system:user:query', '查询用户信息', 3),
       ('system:user:edit', '编辑用户信息', 2),
       ('system:log:view', '查看操作日志', 1);


-- 定义角色权限映射
INSERT INTO sys_role_permission (role_id, perm_id)
VALUES (1, 1),
       (1, 2),
       (1, 3), -- 管理员拥有全部权限
       (2, 1); -- 普通用户仅可查询
