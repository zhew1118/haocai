package dqyhyy.haocai.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Haocai {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer haocaiId;

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
    private Integer haocaiStatus;

    public Haocai() {
    }

    public Integer getHaocaiId() {
        return haocaiId;
    }

    public void setHaocaiId(Integer haocaiId) {
        this.haocaiId = haocaiId;
    }

    public String getHaocaiName() {
        return haocaiName;
    }

    public void setHaocaiName(String haocaiName) {
        this.haocaiName = haocaiName;
    }

    public String getHaocaiPurchaseDate() {
        return haocaiPurchaseDate;
    }

    public void setHaocaiPurchaseDate(String haocaiPurchaseDate) {
        this.haocaiPurchaseDate = haocaiPurchaseDate;
    }

    public String getHaocaiExpirationDate() {
        return haocaiExpirationDate;
    }

    public void setHaocaiExpirationDate(String haocaiExpirationDate) {
        this.haocaiExpirationDate = haocaiExpirationDate;
    }

    public String getHaocaiSpec() {
        return haocaiSpec;
    }

    public void setHaocaiSpec(String haocaiSpec) {
        this.haocaiSpec = haocaiSpec;
    }

    public String getHaocaiVendor() {
        return haocaiVendor;
    }

    public void setHaocaiVendor(String haocaiVendor) {
        this.haocaiVendor = haocaiVendor;
    }

    public String getHaocaiType() {
        return haocaiType;
    }

    public void setHaocaiType(String haocaiType) {
        this.haocaiType = haocaiType;
    }

    public int getHaocaiAmount() {
        return haocaiAmount;
    }

    public void setHaocaiAmount(int haocaiAmount) {
        this.haocaiAmount = haocaiAmount;
    }

    public String getHaocaiUnit() {
        return haocaiUnit;
    }

    public void setHaocaiUnit(String haocaiUnit) {
        this.haocaiUnit = haocaiUnit;
    }

    public Integer getHaocaiStatus() {
        return haocaiStatus;
    }

    public void setHaocaiStatus(Integer haocaiStatus) {
        this.haocaiStatus = haocaiStatus;
    }
}
