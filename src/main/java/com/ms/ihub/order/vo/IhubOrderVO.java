package com.ms.ihub.order.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EntityScan
public class IhubOrderVO {
	private Long orderId;
	private Long ioaId;
	private int deletedFlag;
	private Long createdBy;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ", locale = "en_US")
	private Date creationStartDate;
	private Date creationEndDate;
	private String serviceDomain;
	private String[] serviceDomainList;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status;

	public String getServiceDomain() {
		return serviceDomain;
	}

	public void setServiceDomain(String serviceDomain) {
		this.serviceDomain = serviceDomain;
	}

	public String[] getServiceDomainList() {
		return serviceDomainList;
	}

	public void setServiceDomainList(String[] serviceDomainList) {
		this.serviceDomainList = serviceDomainList;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getIoaId() {
		return ioaId;
	}

	public void setIoaId(Long ioaId) {
		this.ioaId = ioaId;
	}

	public int getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(int deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationStartDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		df.format(creationStartDate);
		return creationStartDate == null ? new Date() : creationStartDate;
	}

	public void setCreationStartDate(Date creationStartDate) {
		this.creationStartDate = creationStartDate;
	}

	public Date getCreationEndDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		df.format(creationEndDate);
		return creationEndDate == null ? new Date() : creationEndDate;
	}

	public void setCreationEndDate(Date creationEndDate) {
		this.creationEndDate = creationEndDate;
	}
}
