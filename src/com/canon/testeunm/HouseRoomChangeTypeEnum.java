package com.canon.testeunm;

public enum HouseRoomChangeTypeEnum {
    CHECK_OUT("定时任务退租",1),
    LEASE("续租",2),
    SUBLET("转租",3),
    EXCHANGE31("换租",4),
    LEASE_SAVE("租约保存",5),
    LEASE_SUBMIT("租约提交",6),
    LEASE_DISMISSED("租约驳回",7),
    LEASE_APPROVED("租约审批通过",8),
    LEASE_WITHDRAWAL("租约撤回",9),
    LEASE_INVALID("租约作废",10),
    RESERVATIONS_INSERT("预订录入",11),
    RESERVATIONS_CANCELED("预订作废/过期",12),
    RESERVATIONS_CANCELED_HR("定时任务预定作废",13);

    public String name;
    public int value;

    private HouseRoomChangeTypeEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name() + "(" + this.name + "," + this.value + ")";
    }

    public static HouseRoomChangeTypeEnum getSexEnumByCode(String code){
        for(HouseRoomChangeTypeEnum sexEnum : HouseRoomChangeTypeEnum.values()){
            if(code.equals(sexEnum.value)){
                return sexEnum;
            }
        }
        return null;
    }

}
