package com.id4.iprod.ITS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="iprod_master_part")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PART_ID")
	protected int partId;

	@Column(name = "PART_NAME")
	protected String partName;

	@Column(name = "PART_DESC")
	protected String partDesc;

	@Column(name = "PART_CDATETIME")
	protected String partCdatetime;

	@Column(name = "PART_MDATETIME")
	protected String partMdatetime;

	@Column(name = "PART_IS_DELETED")
	protected Short partIsDeleted;

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartDesc() {
		return partDesc;
	}

	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}

	public String getPartCdatetime() {
		return partCdatetime;
	}

	public void setPartCdatetime(String partCdatetime) {
		this.partCdatetime = partCdatetime;
	}

	public String getPartMdatetime() {
		return partMdatetime;
	}

	public void setPartMdatetime(String partMdatetime) {
		this.partMdatetime = partMdatetime;
	}

	public Short getPartIsDeleted() {
		return partIsDeleted;
	}

	public void setPartIsDeleted(Short partIsDeleted) {
		this.partIsDeleted = partIsDeleted;
	}

}