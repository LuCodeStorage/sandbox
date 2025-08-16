package com.mazedemo.security.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * ユーザー
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    /**
     * ID
     */
    private Integer id;

    /**
     * 名前
     */
    private String firstname;

    /**
     * 姓
     */
    private String lastname;

    /**
     * メールアドレス
     */
    private String email;

    /**
     * パスワード
     */
    private String password;

    /**
     * ロール
     */
    private Role role;

    /**
     * 権限の取得
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    /**
     * ユーザー名の取得
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * アカウントが期限切れでないかどうかを確認
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * アカウントがロックされていないかどうかを確認
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 資格情報が期限切れでないかどうかを確認
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * アカウントが有効かどうかを確認
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}