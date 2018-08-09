package co.in.pp;

import javax.persistence.*;

@Entity
@Table(name = "familywife")

public class WifeDTO {

	@Id
	@Column(name = "W_ID")
	private Integer wid;

	@Column(name = "W_NAME")
	private String wname;

	@Column(name = "W_GENDER")
	private String wgender;

	@OneToOne(targetEntity = HusbandDTO.class, cascade = CascadeType.ALL)
	// @JoinColumn(name="H_ID", referencedColumnName="H_ID")
	private HusbandDTO husbandParent;

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getWgender() {
		return wgender;
	}

	public void setWgender(String wgender) {
		this.wgender = wgender;
	}

	public HusbandDTO getHusbandParent() {
		return husbandParent;
	}

	public void setHusbandParent(HusbandDTO husbandParent) {
		this.husbandParent = husbandParent;
	}

}
