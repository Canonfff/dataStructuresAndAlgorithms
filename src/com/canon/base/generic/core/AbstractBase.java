package com.canon.base.generic.core;

import com.canon.base.generic.IBase;
import com.canon.base.generic.model.Base;

/**
 * @PackageName: com.canon.base.generic.core
 * @Description:
 * @author: canon
 * @date: 2020/9/4 17:06
 * @Version: 1.0
 */
public abstract class AbstractBase<T extends Base> implements IBase<T> {

    @Override
    public void execute(T t) {
        System.out.println(t.getName());
    }
}
