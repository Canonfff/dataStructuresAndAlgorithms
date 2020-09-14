package com.canon.base.generic;

import com.canon.base.generic.model.Base;

/**
 * @PackageName: com.canon.base.generic
 * @Description:
 * @author: canon
 * @date: 2020/9/4 17:05
 * @Version: 1.0
 */
public interface IBase<T extends Base> {

    void execute(T t);
}
