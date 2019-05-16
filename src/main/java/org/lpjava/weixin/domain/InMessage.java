package org.lpjava.weixin.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class InMessage {
	
	@XmlElement(name = "ToUserName")
	@JsonProperty("ToUserName")
	private String toUserName;
	
	@XmlElement(name = "fromUserName")
	@JsonProperty("FromUserName")
	private String fromUserName;
	
	@XmlElement(name = "CreateTime")
	@JsonProperty("CreateTime")
	private long createTime;
	
	@XmlElement(name = "MsgType")
	@JsonProperty("MsgType")
	private String msgType;
	
	@XmlElement(name = "MsgId")
	@JsonProperty("MsgId")
	private Long msgId;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

}
