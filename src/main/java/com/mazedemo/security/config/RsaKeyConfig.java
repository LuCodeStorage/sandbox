package com.mazedemo.security.config;

import com.mazedemo.security.util.KeyGeneratorUtil.RsaKeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * RSA鍵設定
 */
@Configuration
public class RsaKeyConfig {

    /**
     * JWTの鍵プロパティ
     *
     * @return JWT鍵プロパティ
     */
    @Bean
    public JwtKeyProperties jwtKeyProperties() {
        // RSA鍵を生成
        RsaKeyProperties rsaKeys = RsaKeyProperties.generate();

        // JWTキープロパティを設定
        JwtKeyProperties jwtKeyProperties = new JwtKeyProperties();
        jwtKeyProperties.setPublicKey(rsaKeys.publicKey());
        jwtKeyProperties.setPrivateKey(rsaKeys.privateKey());

        return jwtKeyProperties;
    }
}