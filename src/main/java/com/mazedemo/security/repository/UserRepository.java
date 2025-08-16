package com.mazedemo.security.repository;

import com.mazedemo.security.domain.User;

import java.util.Optional;



/**
 * ユーザーリポジトリ
 */
public interface UserRepository {

    /**
     * メールアドレスでユーザーを検索
     *
     * @param email メールアドレス
     * @return ユーザー
     */
    Optional<User> findByEmail(String email);

    void save(User user);
}