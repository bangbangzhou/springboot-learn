package com.zbbmeta.aspect;

import com.zbbmeta.annotation.SensitiveField;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@Slf4j
@Aspect
@Component
public class SensitiveAspect {
    @Autowired
    private StringEncryptor stringEncryptor;
    @Pointcut("@annotation(com.zbbmeta.annotation.SensitiveMethod)")
    public void pointCut() {
    }


    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint ) throws Throwable {
        // 执行原有方法

        // 获取参数，对参数中加密字段，进行解密
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
                Field[] fields = arg.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(SensitiveField.class)) {
                        field.setAccessible(true);
                        Object value = field.get(arg);
                        if (value instanceof String) {
                            // 调用脱敏服务进行处理
                            String maskedValue = stringEncryptor.decrypt((String) value);
                            // 设置脱敏后的值
                            field.set(arg, maskedValue);
                        }
                    }
                }

        }

        Object returnValue = joinPoint.proceed(args);

        // 获取对象的字段及其值进行加密
        if (returnValue != null) {
            Class<?> clazz = returnValue.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if(field.isAnnotationPresent(SensitiveField.class)) {
                    field.setAccessible(true);
                    Object value = field.get(returnValue);

                    // 在这里可以对字段值进行处理，例如脱敏
                    if (value instanceof String) {
                        String maskedValue = stringEncryptor.encrypt((String) value);
                        field.set(returnValue, maskedValue);
                    }
                }
            }
        }

        return returnValue;
    }
}
