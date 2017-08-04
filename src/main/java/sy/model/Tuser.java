package sy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TUSER")
public class Tuser implements java.io.Serializable {
	private String id;
	private String name;
	private String pwd;
	private Date createdatetime;
	private Date modifydatetime;
	/** default constructor */
	public Tuser() {
		
	}
	/** minimal constructor */
	public Tuser(String id, String name, String pwd){
		this.id =  id;
		this.name = name;
		this.pwd = pwd;
	}
	/** full constructor */
	public Tuser(String id, String name, String pwd, Date createdatetime, Date modifydatetime) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	public Date getModifydatetime() {
		return modifydatetime;
	}
	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}
	
}
