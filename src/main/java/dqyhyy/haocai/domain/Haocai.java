package dqyhyy.haocai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dqyhyy.haocai.enums.HaocaiStatusEnum;
import dqyhyy.haocai.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@DynamicUpdate
public class Haocai implements Serializable {
    @Id
    private String haocaiId;

    /** 耗材名称 */
    private String haocaiName;

    /** 耗材购买时间 */
    private String haocaiPurchaseDate;

    /** 耗材有效期 */
    private String haocaiExpirationDate;

    /** 耗材规格 */
    private String haocaiSpec;

    /** 耗材供应商 */
    private String haocaiVendor;

    /** 耗材种类 */
    private String haocaiType;

    /** 耗材库存余量 */
    private int haocaiAmount;

    /** 耗材库存单位 */
    private String haocaiUnit;

    /** 耗材状态 0正常 1下架 */
    private Integer haocaiStatus = HaocaiStatusEnum.UP.getCode();;

    @JsonIgnore
    public HaocaiStatusEnum getHaocaiStatusEnum(){
        return EnumUtil.getByCode(haocaiStatus, HaocaiStatusEnum.class);
    }
}
