package dqyhyy.haocai.utils;

import dqyhyy.haocai.enums.CodeEnum;

public class EnumUtil {
    /**
     *
      * @param enumClass
     * @param code
     * @param <T>
     * @return
     */
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if(each.getCode()==code){
                return each;
            }
        }
        return null;
    }
}
