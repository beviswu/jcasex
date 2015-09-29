package cn.bevisoft.jcasex.dal.enums;

import org.apache.commons.lang3.StringUtils;

public enum EntityStatus {

    DELETED("DELETED", "删除"), ENABLED("ENABLED", "启用"), UNENABLED("UNENABLED", "禁用");

    String code;

    String name;

    EntityStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static EntityStatus getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (EntityStatus entityStatus : values()) {
            if (StringUtils.equalsIgnoreCase(entityStatus.getCode(), code)) {
                return entityStatus;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
