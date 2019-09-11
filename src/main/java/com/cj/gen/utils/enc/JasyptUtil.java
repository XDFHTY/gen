package com.cj.gen.utils.enc;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;


/**
 * @author Exrickx
 */
@Slf4j
public class JasyptUtil {

    /**
     * Jasypt生成加密结果
     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
     * @param value 待加密值
     * @return
     */
    public static String encyptPwd(String password,String value){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptor(password));
        String result = encryptor.encrypt(value);
        return result;
    }

    /**
     * 解密
     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
     * @param value 待解密密文
     * @return
     */
    public static String decyptPwd(String password,String value){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptor(password));
        String result = encryptor.decrypt(value);
        return result;
    }

    public static SimpleStringPBEConfig cryptor(String password){
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        return config;
    }

    public static void main(String[] args){

        //加密
//        System.out.println(encyptPwd("config","admin"));
//        System.out.println(encyptPwd("root","47.94.45.159"));
        System.out.println(encyptPwd("root","47.92.129.254"));
//        System.out.println(encyptPwd("root","59.110.164.54"));
//        System.out.println(encyptPwd("root","118.123.16.211"));
//        System.out.println(encyptPwd("root","127.0.0.1"));
//        System.out.println(encyptPwd("root","rootpass"));
//        System.out.println(encyptPwd("root","59.110.164.54:8070"));
//        System.out.println(encyptPwd("root","jdbc:mysql://118.123.16.211:3306/ujie?characterEncoding=UTF-8&useSSL=false&allowMultiQueries=true\n"));
//        System.out.println(encyptPwd("config","https://github.com/xdfh/config.git"));
//        System.out.println(encyptPwd("uav","rootpass"));
        //解密
//        System.out.println(decyptPwd("root","uSKRHCeCIDToALY+t6lMuSsYvmhhh3n2"));
//        System.out.println(decyptPwd("root","e6SUa4HUSLkj3dnRmFQbGkQyFH6aSjlV"));
    }
}
