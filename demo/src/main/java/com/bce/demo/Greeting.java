package com.bce.demo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
		private Long sid;
	private String content;

	  protected Greeting() {}

	  public Greeting(Long sid, String content) {
	    this.sid = sid;
	    this.content = content;
	  }
	  
	  @Override
	  public String toString() {
	    return String.format(
	        "Greeting[id=%d, sid=%d, content='%s']",
	        id, sid, content);
	  }

	public Long getId() {
		return id;
	}

	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
