package com.fancv.model;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 供需方认证信息表
 *
 * @author null
 * @date 2020-11-05
 */
public class AuthenticationInfo {
    /**
     * 主键
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id")
    private Integer id;

    /**
     * 企业名称
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "企业名称")
    @TableId(value = "customer_name")
    private String customerName;

    /**
     * 企业id
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "企业id")
    @TableId(value = "customer_id")
    private String customerId;

    /**
     * 企业编号
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "企业编号")
    @TableId(value = "customer_code")
    private String customerCode;

    /**
     * 企业类别 1：供方  2：需方
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "企业类别 1：供方  2：需方")
    @TableId(value = "customer_type")
    private String customerType;

    /**
     * 企业所在地省编码
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "企业所在地省编码")
    @TableId(value = "address_province_code")
    private String addressProvinceCode;

    /**
     * 企业所在地省名称
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "企业所在地省名称")
    @TableId(value = "address_province_name")
    private String addressProvinceName;

    /**
     * 企业所在地城市编码
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "企业所在地城市编码")
    @TableId(value = "address_city_code")
    private String addressCityCode;

    /**
     * 企业所在地城市名称
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "企业所在地城市名称")
    @TableId(value = "address_city_name")
    private String addressCityName;

    /**
     * 企业所在地区编码
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "企业所在地区编码")
    @TableId(value = "address_area_code")
    private String addressAreaCode;

    /**
     * 企业所在地区名称
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "企业所在地区名称")
    @TableId(value = "address_area_name")
    private String addressAreaName;

    /**
     * 提交人id  运营中台2.0
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "提交人id  运营中台2.0")
    @TableId(value = "submit_user_id")
    private String submitUserId;

    /**
     * 提交人手机号
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "提交人手机号")
    @TableId(value = "submit_user_phone")
    private String submitUserPhone;

    /**
     * 认证状态：未认证、认证通过、认证不通过
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "认证状态：未认证、认证通过、认证不通过")
    @TableId(value = "auth_status")
    private String authStatus;

    /**
     * 认证意见
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "认证意见")
    @TableId(value = "auth_remark")
    private String authRemark;

    /**
     * 推荐类型
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "推荐类型")
    @TableId(value = "traffic_type")
    private String trafficType;

    /**
     * 二维码持有人姓名
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "二维码持有人姓名")
    @TableId(value = "qr_possessor")
    private String qrPossessor;

    /**
     * 二维码持有人工号
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "二维码持有人工号")
    @TableId(value = "qr_possessor_code")
    private String qrPossessorCode;

    /**
     * 经营类目编码
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "经营类目编码")
    @TableId(value = "business_category_code")
    private String businessCategoryCode;

    /**
     * 经营类目名称
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "经营类目名称")
    @TableId(value = "business_category_name")
    private String businessCategoryName;

    /**
     * 营业执照URL
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "营业执照URL")
    @TableId(value = "business_license")
    private String businessLicense;

    /**
     * 提交认证时间
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "提交认证时间")
    @TableId(value = "auth_submit_time")
    private Date authSubmitTime;

    /**
     * 注册资金来源征信
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "注册资金来源征信")
    @TableId(value = "regcap")
    private String regcap;

    /**
     * 经营类目 来源征信
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "经营类目 来源征信")
    @TableId(value = "industryconame")
    private String industryconame;

    /**
     * 删除标识
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "删除标识")
    @TableId(value = "deleted")
    private String deleted;

    /**
     * 备注
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "备注")
    @TableId(value = "remark")
    private String remark;

    private String creatorId;

    private String creatorName;

    private String modifierId;

    private String modifierName;

    private Date gmtCreateTime;

    private Date gmtModifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType == null ? null : customerType.trim();
    }

    public String getAddressProvinceCode() {
        return addressProvinceCode;
    }

    public void setAddressProvinceCode(String addressProvinceCode) {
        this.addressProvinceCode = addressProvinceCode == null ? null : addressProvinceCode.trim();
    }

    public String getAddressProvinceName() {
        return addressProvinceName;
    }

    public void setAddressProvinceName(String addressProvinceName) {
        this.addressProvinceName = addressProvinceName == null ? null : addressProvinceName.trim();
    }

    public String getAddressCityCode() {
        return addressCityCode;
    }

    public void setAddressCityCode(String addressCityCode) {
        this.addressCityCode = addressCityCode == null ? null : addressCityCode.trim();
    }

    public String getAddressCityName() {
        return addressCityName;
    }

    public void setAddressCityName(String addressCityName) {
        this.addressCityName = addressCityName == null ? null : addressCityName.trim();
    }

    public String getAddressAreaCode() {
        return addressAreaCode;
    }

    public void setAddressAreaCode(String addressAreaCode) {
        this.addressAreaCode = addressAreaCode == null ? null : addressAreaCode.trim();
    }

    public String getAddressAreaName() {
        return addressAreaName;
    }

    public void setAddressAreaName(String addressAreaName) {
        this.addressAreaName = addressAreaName == null ? null : addressAreaName.trim();
    }

    public String getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(String submitUserId) {
        this.submitUserId = submitUserId == null ? null : submitUserId.trim();
    }

    public String getSubmitUserPhone() {
        return submitUserPhone;
    }

    public void setSubmitUserPhone(String submitUserPhone) {
        this.submitUserPhone = submitUserPhone == null ? null : submitUserPhone.trim();
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus == null ? null : authStatus.trim();
    }

    public String getAuthRemark() {
        return authRemark;
    }

    public void setAuthRemark(String authRemark) {
        this.authRemark = authRemark == null ? null : authRemark.trim();
    }

    public String getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(String trafficType) {
        this.trafficType = trafficType == null ? null : trafficType.trim();
    }

    public String getQrPossessor() {
        return qrPossessor;
    }

    public void setQrPossessor(String qrPossessor) {
        this.qrPossessor = qrPossessor == null ? null : qrPossessor.trim();
    }

    public String getQrPossessorCode() {
        return qrPossessorCode;
    }

    public void setQrPossessorCode(String qrPossessorCode) {
        this.qrPossessorCode = qrPossessorCode == null ? null : qrPossessorCode.trim();
    }

    public String getBusinessCategoryCode() {
        return businessCategoryCode;
    }

    public void setBusinessCategoryCode(String businessCategoryCode) {
        this.businessCategoryCode = businessCategoryCode == null ? null : businessCategoryCode.trim();
    }

    public String getBusinessCategoryName() {
        return businessCategoryName;
    }

    public void setBusinessCategoryName(String businessCategoryName) {
        this.businessCategoryName = businessCategoryName == null ? null : businessCategoryName.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public Date getAuthSubmitTime() {
        return authSubmitTime;
    }

    public void setAuthSubmitTime(Date authSubmitTime) {
        this.authSubmitTime = authSubmitTime;
    }

    public String getRegcap() {
        return regcap;
    }

    public void setRegcap(String regcap) {
        this.regcap = regcap == null ? null : regcap.trim();
    }

    public String getIndustryconame() {
        return industryconame;
    }

    public void setIndustryconame(String industryconame) {
        this.industryconame = industryconame == null ? null : industryconame.trim();
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId == null ? null : modifierId.trim();
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName == null ? null : modifierName.trim();
    }

    public Date getGmtCreateTime() {
        return gmtCreateTime;
    }

    public void setGmtCreateTime(Date gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    public Date getGmtModifyTime() {
        return gmtModifyTime;
    }

    public void setGmtModifyTime(Date gmtModifyTime) {
        this.gmtModifyTime = gmtModifyTime;
    }
}