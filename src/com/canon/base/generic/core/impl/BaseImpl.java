package com.canon.base.generic.core.impl;

import com.canon.base.generic.core.AbstractBase;
import com.canon.base.generic.model.SubBase;

/**
 * @PackageName: com.canon.base.generic.core.impl
 * @Description:
 * @author: canon
 * @date: 2020/9/4 17:07
 * @Version: 1.0
 */
public class BaseImpl extends AbstractBase<SubBase> {
    @Override
    public void execute(SubBase subBase) {
        super.execute(subBase);
        System.out.println(subBase.getSubName());
    }
}
