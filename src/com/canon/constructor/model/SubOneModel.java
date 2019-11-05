package com.canon.constructor.model;

/**
 * @Author Canon
 * @Date:Created in 23:57 2019/10/25
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class SubOneModel extends BaseModel {

    public SubOneModel() {
    }
    public SubOneModel(BaseModel baseModel) {
        super(baseModel);
        // baseModel.cast(base);

    }

    private String subName;

    public String getSubName() {
        return this.subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "SubOneModel{" +
                "subName='" + subName + '\'' +
                '}';
    }
}
