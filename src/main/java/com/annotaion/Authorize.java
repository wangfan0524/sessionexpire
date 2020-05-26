/**
 * 文件名：Authorize.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述：用户验证注解
 */
package com.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用户验证注解
 *
 * @author fan.wang03@hand-china.com
 * @version 1.0
 * @date 2019/6/27 10:15
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorize {
    Class <?> outPutClass();
}
