/**
 * CommData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.rrtx.frame.ws;

public class CommData  implements java.io.Serializable {
    private java.lang.String messageId;

    private java.lang.String version;

    private java.lang.String bizCode;

    private java.lang.String success;

    private java.lang.String errorCode;

    private java.lang.String errors;

    private java.lang.String mac;

    private java.lang.String customerNo;

    private java.lang.String customerNameCN;

    private java.lang.String certType;

    private java.lang.String certNo;

    private java.lang.String mobileNo;

    private java.lang.String email;

    private java.lang.String customerStatus;

    private java.lang.String tokenId;

    private java.lang.String tokenStatus;

    private java.lang.String merchantId;

    private java.lang.String merchantName;

    private java.lang.String merchantStatus;

    private java.lang.String orderNo;

    private java.lang.String payPassword;

    private long amount;

    private java.lang.String currency;

    private java.lang.String orderTime;

    private java.lang.String orderSerialNo;

    private java.lang.String queryPassword;

    private long balance;

    private java.lang.String batchNo;

    private java.lang.String batchDate;

    private java.lang.String totalNum;

    private java.lang.String totalSuccNum;

    private com.rrtx.frame.ws.CommData[] orderList;

    private java.lang.String unionPaySerialNo;

    private java.lang.String succTime;

    private java.lang.String extend1;

    private java.lang.String extend2;

    private java.lang.String extend3;

    public CommData() {
    }

    public CommData(
           java.lang.String messageId,
           java.lang.String version,
           java.lang.String bizCode,
           java.lang.String success,
           java.lang.String errorCode,
           java.lang.String errors,
           java.lang.String mac,
           java.lang.String customerNo,
           java.lang.String customerNameCN,
           java.lang.String certType,
           java.lang.String certNo,
           java.lang.String mobileNo,
           java.lang.String email,
           java.lang.String customerStatus,
           java.lang.String tokenId,
           java.lang.String tokenStatus,
           java.lang.String merchantId,
           java.lang.String merchantName,
           java.lang.String merchantStatus,
           java.lang.String orderNo,
           java.lang.String payPassword,
           long amount,
           java.lang.String currency,
           java.lang.String orderTime,
           java.lang.String orderSerialNo,
           java.lang.String queryPassword,
           long balance,
           java.lang.String batchNo,
           java.lang.String batchDate,
           java.lang.String totalNum,
           java.lang.String totalSuccNum,
           com.rrtx.frame.ws.CommData[] orderList,
           java.lang.String unionPaySerialNo,
           java.lang.String succTime,
           java.lang.String extend1,
           java.lang.String extend2,
           java.lang.String extend3) {
           this.messageId = messageId;
           this.version = version;
           this.bizCode = bizCode;
           this.success = success;
           this.errorCode = errorCode;
           this.errors = errors;
           this.mac = mac;
           this.customerNo = customerNo;
           this.customerNameCN = customerNameCN;
           this.certType = certType;
           this.certNo = certNo;
           this.mobileNo = mobileNo;
           this.email = email;
           this.customerStatus = customerStatus;
           this.tokenId = tokenId;
           this.tokenStatus = tokenStatus;
           this.merchantId = merchantId;
           this.merchantName = merchantName;
           this.merchantStatus = merchantStatus;
           this.orderNo = orderNo;
           this.payPassword = payPassword;
           this.amount = amount;
           this.currency = currency;
           this.orderTime = orderTime;
           this.orderSerialNo = orderSerialNo;
           this.queryPassword = queryPassword;
           this.balance = balance;
           this.batchNo = batchNo;
           this.batchDate = batchDate;
           this.totalNum = totalNum;
           this.totalSuccNum = totalSuccNum;
           this.orderList = orderList;
           this.unionPaySerialNo = unionPaySerialNo;
           this.succTime = succTime;
           this.extend1 = extend1;
           this.extend2 = extend2;
           this.extend3 = extend3;
    }


    /**
     * Gets the messageId value for this CommData.
     * 
     * @return messageId
     */
    public java.lang.String getMessageId() {
        return messageId;
    }


    /**
     * Sets the messageId value for this CommData.
     * 
     * @param messageId
     */
    public void setMessageId(java.lang.String messageId) {
        this.messageId = messageId;
    }


    /**
     * Gets the version value for this CommData.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this CommData.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the bizCode value for this CommData.
     * 
     * @return bizCode
     */
    public java.lang.String getBizCode() {
        return bizCode;
    }


    /**
     * Sets the bizCode value for this CommData.
     * 
     * @param bizCode
     */
    public void setBizCode(java.lang.String bizCode) {
        this.bizCode = bizCode;
    }


    /**
     * Gets the success value for this CommData.
     * 
     * @return success
     */
    public java.lang.String getSuccess() {
        return success;
    }


    /**
     * Sets the success value for this CommData.
     * 
     * @param success
     */
    public void setSuccess(java.lang.String success) {
        this.success = success;
    }


    /**
     * Gets the errorCode value for this CommData.
     * 
     * @return errorCode
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this CommData.
     * 
     * @param errorCode
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errors value for this CommData.
     * 
     * @return errors
     */
    public java.lang.String getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this CommData.
     * 
     * @param errors
     */
    public void setErrors(java.lang.String errors) {
        this.errors = errors;
    }


    /**
     * Gets the mac value for this CommData.
     * 
     * @return mac
     */
    public java.lang.String getMac() {
        return mac;
    }


    /**
     * Sets the mac value for this CommData.
     * 
     * @param mac
     */
    public void setMac(java.lang.String mac) {
        this.mac = mac;
    }


    /**
     * Gets the customerNo value for this CommData.
     * 
     * @return customerNo
     */
    public java.lang.String getCustomerNo() {
        return customerNo;
    }


    /**
     * Sets the customerNo value for this CommData.
     * 
     * @param customerNo
     */
    public void setCustomerNo(java.lang.String customerNo) {
        this.customerNo = customerNo;
    }


    /**
     * Gets the customerNameCN value for this CommData.
     * 
     * @return customerNameCN
     */
    public java.lang.String getCustomerNameCN() {
        return customerNameCN;
    }


    /**
     * Sets the customerNameCN value for this CommData.
     * 
     * @param customerNameCN
     */
    public void setCustomerNameCN(java.lang.String customerNameCN) {
        this.customerNameCN = customerNameCN;
    }


    /**
     * Gets the certType value for this CommData.
     * 
     * @return certType
     */
    public java.lang.String getCertType() {
        return certType;
    }


    /**
     * Sets the certType value for this CommData.
     * 
     * @param certType
     */
    public void setCertType(java.lang.String certType) {
        this.certType = certType;
    }


    /**
     * Gets the certNo value for this CommData.
     * 
     * @return certNo
     */
    public java.lang.String getCertNo() {
        return certNo;
    }


    /**
     * Sets the certNo value for this CommData.
     * 
     * @param certNo
     */
    public void setCertNo(java.lang.String certNo) {
        this.certNo = certNo;
    }


    /**
     * Gets the mobileNo value for this CommData.
     * 
     * @return mobileNo
     */
    public java.lang.String getMobileNo() {
        return mobileNo;
    }


    /**
     * Sets the mobileNo value for this CommData.
     * 
     * @param mobileNo
     */
    public void setMobileNo(java.lang.String mobileNo) {
        this.mobileNo = mobileNo;
    }


    /**
     * Gets the email value for this CommData.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this CommData.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the customerStatus value for this CommData.
     * 
     * @return customerStatus
     */
    public java.lang.String getCustomerStatus() {
        return customerStatus;
    }


    /**
     * Sets the customerStatus value for this CommData.
     * 
     * @param customerStatus
     */
    public void setCustomerStatus(java.lang.String customerStatus) {
        this.customerStatus = customerStatus;
    }


    /**
     * Gets the tokenId value for this CommData.
     * 
     * @return tokenId
     */
    public java.lang.String getTokenId() {
        return tokenId;
    }


    /**
     * Sets the tokenId value for this CommData.
     * 
     * @param tokenId
     */
    public void setTokenId(java.lang.String tokenId) {
        this.tokenId = tokenId;
    }


    /**
     * Gets the tokenStatus value for this CommData.
     * 
     * @return tokenStatus
     */
    public java.lang.String getTokenStatus() {
        return tokenStatus;
    }


    /**
     * Sets the tokenStatus value for this CommData.
     * 
     * @param tokenStatus
     */
    public void setTokenStatus(java.lang.String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }


    /**
     * Gets the merchantId value for this CommData.
     * 
     * @return merchantId
     */
    public java.lang.String getMerchantId() {
        return merchantId;
    }


    /**
     * Sets the merchantId value for this CommData.
     * 
     * @param merchantId
     */
    public void setMerchantId(java.lang.String merchantId) {
        this.merchantId = merchantId;
    }


    /**
     * Gets the merchantName value for this CommData.
     * 
     * @return merchantName
     */
    public java.lang.String getMerchantName() {
        return merchantName;
    }


    /**
     * Sets the merchantName value for this CommData.
     * 
     * @param merchantName
     */
    public void setMerchantName(java.lang.String merchantName) {
        this.merchantName = merchantName;
    }


    /**
     * Gets the merchantStatus value for this CommData.
     * 
     * @return merchantStatus
     */
    public java.lang.String getMerchantStatus() {
        return merchantStatus;
    }


    /**
     * Sets the merchantStatus value for this CommData.
     * 
     * @param merchantStatus
     */
    public void setMerchantStatus(java.lang.String merchantStatus) {
        this.merchantStatus = merchantStatus;
    }


    /**
     * Gets the orderNo value for this CommData.
     * 
     * @return orderNo
     */
    public java.lang.String getOrderNo() {
        return orderNo;
    }


    /**
     * Sets the orderNo value for this CommData.
     * 
     * @param orderNo
     */
    public void setOrderNo(java.lang.String orderNo) {
        this.orderNo = orderNo;
    }


    /**
     * Gets the payPassword value for this CommData.
     * 
     * @return payPassword
     */
    public java.lang.String getPayPassword() {
        return payPassword;
    }


    /**
     * Sets the payPassword value for this CommData.
     * 
     * @param payPassword
     */
    public void setPayPassword(java.lang.String payPassword) {
        this.payPassword = payPassword;
    }


    /**
     * Gets the amount value for this CommData.
     * 
     * @return amount
     */
    public long getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this CommData.
     * 
     * @param amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }


    /**
     * Gets the currency value for this CommData.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this CommData.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the orderTime value for this CommData.
     * 
     * @return orderTime
     */
    public java.lang.String getOrderTime() {
        return orderTime;
    }


    /**
     * Sets the orderTime value for this CommData.
     * 
     * @param orderTime
     */
    public void setOrderTime(java.lang.String orderTime) {
        this.orderTime = orderTime;
    }


    /**
     * Gets the orderSerialNo value for this CommData.
     * 
     * @return orderSerialNo
     */
    public java.lang.String getOrderSerialNo() {
        return orderSerialNo;
    }


    /**
     * Sets the orderSerialNo value for this CommData.
     * 
     * @param orderSerialNo
     */
    public void setOrderSerialNo(java.lang.String orderSerialNo) {
        this.orderSerialNo = orderSerialNo;
    }


    /**
     * Gets the queryPassword value for this CommData.
     * 
     * @return queryPassword
     */
    public java.lang.String getQueryPassword() {
        return queryPassword;
    }


    /**
     * Sets the queryPassword value for this CommData.
     * 
     * @param queryPassword
     */
    public void setQueryPassword(java.lang.String queryPassword) {
        this.queryPassword = queryPassword;
    }


    /**
     * Gets the balance value for this CommData.
     * 
     * @return balance
     */
    public long getBalance() {
        return balance;
    }


    /**
     * Sets the balance value for this CommData.
     * 
     * @param balance
     */
    public void setBalance(long balance) {
        this.balance = balance;
    }


    /**
     * Gets the batchNo value for this CommData.
     * 
     * @return batchNo
     */
    public java.lang.String getBatchNo() {
        return batchNo;
    }


    /**
     * Sets the batchNo value for this CommData.
     * 
     * @param batchNo
     */
    public void setBatchNo(java.lang.String batchNo) {
        this.batchNo = batchNo;
    }


    /**
     * Gets the batchDate value for this CommData.
     * 
     * @return batchDate
     */
    public java.lang.String getBatchDate() {
        return batchDate;
    }


    /**
     * Sets the batchDate value for this CommData.
     * 
     * @param batchDate
     */
    public void setBatchDate(java.lang.String batchDate) {
        this.batchDate = batchDate;
    }


    /**
     * Gets the totalNum value for this CommData.
     * 
     * @return totalNum
     */
    public java.lang.String getTotalNum() {
        return totalNum;
    }


    /**
     * Sets the totalNum value for this CommData.
     * 
     * @param totalNum
     */
    public void setTotalNum(java.lang.String totalNum) {
        this.totalNum = totalNum;
    }


    /**
     * Gets the totalSuccNum value for this CommData.
     * 
     * @return totalSuccNum
     */
    public java.lang.String getTotalSuccNum() {
        return totalSuccNum;
    }


    /**
     * Sets the totalSuccNum value for this CommData.
     * 
     * @param totalSuccNum
     */
    public void setTotalSuccNum(java.lang.String totalSuccNum) {
        this.totalSuccNum = totalSuccNum;
    }


    /**
     * Gets the orderList value for this CommData.
     * 
     * @return orderList
     */
    public com.rrtx.frame.ws.CommData[] getOrderList() {
        return orderList;
    }


    /**
     * Sets the orderList value for this CommData.
     * 
     * @param orderList
     */
    public void setOrderList(com.rrtx.frame.ws.CommData[] orderList) {
        this.orderList = orderList;
    }

    public com.rrtx.frame.ws.CommData getOrderList(int i) {
        return this.orderList[i];
    }

    public void setOrderList(int i, com.rrtx.frame.ws.CommData _value) {
        this.orderList[i] = _value;
    }


    /**
     * Gets the unionPaySerialNo value for this CommData.
     * 
     * @return unionPaySerialNo
     */
    public java.lang.String getUnionPaySerialNo() {
        return unionPaySerialNo;
    }


    /**
     * Sets the unionPaySerialNo value for this CommData.
     * 
     * @param unionPaySerialNo
     */
    public void setUnionPaySerialNo(java.lang.String unionPaySerialNo) {
        this.unionPaySerialNo = unionPaySerialNo;
    }


    /**
     * Gets the succTime value for this CommData.
     * 
     * @return succTime
     */
    public java.lang.String getSuccTime() {
        return succTime;
    }


    /**
     * Sets the succTime value for this CommData.
     * 
     * @param succTime
     */
    public void setSuccTime(java.lang.String succTime) {
        this.succTime = succTime;
    }


    /**
     * Gets the extend1 value for this CommData.
     * 
     * @return extend1
     */
    public java.lang.String getExtend1() {
        return extend1;
    }


    /**
     * Sets the extend1 value for this CommData.
     * 
     * @param extend1
     */
    public void setExtend1(java.lang.String extend1) {
        this.extend1 = extend1;
    }


    /**
     * Gets the extend2 value for this CommData.
     * 
     * @return extend2
     */
    public java.lang.String getExtend2() {
        return extend2;
    }


    /**
     * Sets the extend2 value for this CommData.
     * 
     * @param extend2
     */
    public void setExtend2(java.lang.String extend2) {
        this.extend2 = extend2;
    }


    /**
     * Gets the extend3 value for this CommData.
     * 
     * @return extend3
     */
    public java.lang.String getExtend3() {
        return extend3;
    }


    /**
     * Sets the extend3 value for this CommData.
     * 
     * @param extend3
     */
    public void setExtend3(java.lang.String extend3) {
        this.extend3 = extend3;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CommData)) return false;
        CommData other = (CommData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.messageId==null && other.getMessageId()==null) || 
             (this.messageId!=null &&
              this.messageId.equals(other.getMessageId()))) &&
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.bizCode==null && other.getBizCode()==null) || 
             (this.bizCode!=null &&
              this.bizCode.equals(other.getBizCode()))) &&
            ((this.success==null && other.getSuccess()==null) || 
             (this.success!=null &&
              this.success.equals(other.getSuccess()))) &&
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.errors==null && other.getErrors()==null) || 
             (this.errors!=null &&
              this.errors.equals(other.getErrors()))) &&
            ((this.mac==null && other.getMac()==null) || 
             (this.mac!=null &&
              this.mac.equals(other.getMac()))) &&
            ((this.customerNo==null && other.getCustomerNo()==null) || 
             (this.customerNo!=null &&
              this.customerNo.equals(other.getCustomerNo()))) &&
            ((this.customerNameCN==null && other.getCustomerNameCN()==null) || 
             (this.customerNameCN!=null &&
              this.customerNameCN.equals(other.getCustomerNameCN()))) &&
            ((this.certType==null && other.getCertType()==null) || 
             (this.certType!=null &&
              this.certType.equals(other.getCertType()))) &&
            ((this.certNo==null && other.getCertNo()==null) || 
             (this.certNo!=null &&
              this.certNo.equals(other.getCertNo()))) &&
            ((this.mobileNo==null && other.getMobileNo()==null) || 
             (this.mobileNo!=null &&
              this.mobileNo.equals(other.getMobileNo()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.customerStatus==null && other.getCustomerStatus()==null) || 
             (this.customerStatus!=null &&
              this.customerStatus.equals(other.getCustomerStatus()))) &&
            ((this.tokenId==null && other.getTokenId()==null) || 
             (this.tokenId!=null &&
              this.tokenId.equals(other.getTokenId()))) &&
            ((this.tokenStatus==null && other.getTokenStatus()==null) || 
             (this.tokenStatus!=null &&
              this.tokenStatus.equals(other.getTokenStatus()))) &&
            ((this.merchantId==null && other.getMerchantId()==null) || 
             (this.merchantId!=null &&
              this.merchantId.equals(other.getMerchantId()))) &&
            ((this.merchantName==null && other.getMerchantName()==null) || 
             (this.merchantName!=null &&
              this.merchantName.equals(other.getMerchantName()))) &&
            ((this.merchantStatus==null && other.getMerchantStatus()==null) || 
             (this.merchantStatus!=null &&
              this.merchantStatus.equals(other.getMerchantStatus()))) &&
            ((this.orderNo==null && other.getOrderNo()==null) || 
             (this.orderNo!=null &&
              this.orderNo.equals(other.getOrderNo()))) &&
            ((this.payPassword==null && other.getPayPassword()==null) || 
             (this.payPassword!=null &&
              this.payPassword.equals(other.getPayPassword()))) &&
            this.amount == other.getAmount() &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.orderTime==null && other.getOrderTime()==null) || 
             (this.orderTime!=null &&
              this.orderTime.equals(other.getOrderTime()))) &&
            ((this.orderSerialNo==null && other.getOrderSerialNo()==null) || 
             (this.orderSerialNo!=null &&
              this.orderSerialNo.equals(other.getOrderSerialNo()))) &&
            ((this.queryPassword==null && other.getQueryPassword()==null) || 
             (this.queryPassword!=null &&
              this.queryPassword.equals(other.getQueryPassword()))) &&
            this.balance == other.getBalance() &&
            ((this.batchNo==null && other.getBatchNo()==null) || 
             (this.batchNo!=null &&
              this.batchNo.equals(other.getBatchNo()))) &&
            ((this.batchDate==null && other.getBatchDate()==null) || 
             (this.batchDate!=null &&
              this.batchDate.equals(other.getBatchDate()))) &&
            ((this.totalNum==null && other.getTotalNum()==null) || 
             (this.totalNum!=null &&
              this.totalNum.equals(other.getTotalNum()))) &&
            ((this.totalSuccNum==null && other.getTotalSuccNum()==null) || 
             (this.totalSuccNum!=null &&
              this.totalSuccNum.equals(other.getTotalSuccNum()))) &&
            ((this.orderList==null && other.getOrderList()==null) || 
             (this.orderList!=null &&
              java.util.Arrays.equals(this.orderList, other.getOrderList()))) &&
            ((this.unionPaySerialNo==null && other.getUnionPaySerialNo()==null) || 
             (this.unionPaySerialNo!=null &&
              this.unionPaySerialNo.equals(other.getUnionPaySerialNo()))) &&
            ((this.succTime==null && other.getSuccTime()==null) || 
             (this.succTime!=null &&
              this.succTime.equals(other.getSuccTime()))) &&
            ((this.extend1==null && other.getExtend1()==null) || 
             (this.extend1!=null &&
              this.extend1.equals(other.getExtend1()))) &&
            ((this.extend2==null && other.getExtend2()==null) || 
             (this.extend2!=null &&
              this.extend2.equals(other.getExtend2()))) &&
            ((this.extend3==null && other.getExtend3()==null) || 
             (this.extend3!=null &&
              this.extend3.equals(other.getExtend3())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMessageId() != null) {
            _hashCode += getMessageId().hashCode();
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getBizCode() != null) {
            _hashCode += getBizCode().hashCode();
        }
        if (getSuccess() != null) {
            _hashCode += getSuccess().hashCode();
        }
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getErrors() != null) {
            _hashCode += getErrors().hashCode();
        }
        if (getMac() != null) {
            _hashCode += getMac().hashCode();
        }
        if (getCustomerNo() != null) {
            _hashCode += getCustomerNo().hashCode();
        }
        if (getCustomerNameCN() != null) {
            _hashCode += getCustomerNameCN().hashCode();
        }
        if (getCertType() != null) {
            _hashCode += getCertType().hashCode();
        }
        if (getCertNo() != null) {
            _hashCode += getCertNo().hashCode();
        }
        if (getMobileNo() != null) {
            _hashCode += getMobileNo().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getCustomerStatus() != null) {
            _hashCode += getCustomerStatus().hashCode();
        }
        if (getTokenId() != null) {
            _hashCode += getTokenId().hashCode();
        }
        if (getTokenStatus() != null) {
            _hashCode += getTokenStatus().hashCode();
        }
        if (getMerchantId() != null) {
            _hashCode += getMerchantId().hashCode();
        }
        if (getMerchantName() != null) {
            _hashCode += getMerchantName().hashCode();
        }
        if (getMerchantStatus() != null) {
            _hashCode += getMerchantStatus().hashCode();
        }
        if (getOrderNo() != null) {
            _hashCode += getOrderNo().hashCode();
        }
        if (getPayPassword() != null) {
            _hashCode += getPayPassword().hashCode();
        }
        _hashCode += new Long(getAmount()).hashCode();
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getOrderTime() != null) {
            _hashCode += getOrderTime().hashCode();
        }
        if (getOrderSerialNo() != null) {
            _hashCode += getOrderSerialNo().hashCode();
        }
        if (getQueryPassword() != null) {
            _hashCode += getQueryPassword().hashCode();
        }
        _hashCode += new Long(getBalance()).hashCode();
        if (getBatchNo() != null) {
            _hashCode += getBatchNo().hashCode();
        }
        if (getBatchDate() != null) {
            _hashCode += getBatchDate().hashCode();
        }
        if (getTotalNum() != null) {
            _hashCode += getTotalNum().hashCode();
        }
        if (getTotalSuccNum() != null) {
            _hashCode += getTotalSuccNum().hashCode();
        }
        if (getOrderList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrderList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrderList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUnionPaySerialNo() != null) {
            _hashCode += getUnionPaySerialNo().hashCode();
        }
        if (getSuccTime() != null) {
            _hashCode += getSuccTime().hashCode();
        }
        if (getExtend1() != null) {
            _hashCode += getExtend1().hashCode();
        }
        if (getExtend2() != null) {
            _hashCode += getExtend2().hashCode();
        }
        if (getExtend3() != null) {
            _hashCode += getExtend3().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CommData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.pay.zte.com/", "commData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "messageId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bizCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bizCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("success");
        elemField.setXmlName(new javax.xml.namespace.QName("", "success"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mac");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mac"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNameCN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerNameCN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("certType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "certType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("certNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "certNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobileNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mobileNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tokenId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tokenId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tokenStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tokenStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchantId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "merchantId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchantName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "merchantName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchantStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "merchantStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payPassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderSerialNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderSerialNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queryPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("", "queryPassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "balance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "batchNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "batchDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalSuccNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalSuccNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.pay.zte.com/", "commData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unionPaySerialNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unionPaySerialNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("succTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "succTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extend1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "extend1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extend2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "extend2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extend3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "extend3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
