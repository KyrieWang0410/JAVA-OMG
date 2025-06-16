package com.demo.common.security;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class AuthUser implements UserDetails, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id; // 用户ID（对应sys_user表）
    private String username; // 用户名
    private String password; // BCrypt加密后的密码
    private Integer dataScope; // 数据权限：1=全部，2=本人
    private Integer status; // 状态：0=禁用，1=启用
    private List<String> permissions; // 权限标识列表（如：sys:user:query）
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        // 启用状态视为未过期
        return status == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 启用状态视为未锁定
        return status == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 凭据永不过期（按需调整）
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 启用状态视为激活
        return status == 1;
    }

    // 权限集合转换（RBAC核心）
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
