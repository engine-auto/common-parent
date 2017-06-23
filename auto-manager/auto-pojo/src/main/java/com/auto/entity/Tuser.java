package com.auto.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_weixin_user", schema = "public")
public class Tuser implements Serializable {

	private static final long serialVersionUID = -917847038718889726L;
	private Long id;
	private String mobile;
	private String status;

	/**
	 * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	 */
	private Integer subscribe;
	/**
	 * 用户的标识，对当前公众号唯一
	 */
	private String openid;
	/**
	 * 用户的昵称
	 */
	private String nickname;
	/**
	 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 */
	private Integer sex;
	/**
	 * 用户所在城市
	 */
	private String city;
	/**
	 * 用户所在国家
	 */
	private String country;
	/**
	 * 用户所在省份
	 */
	private String province;
	/**
	 * 用户的语言，简体中文为zh_CN
	 */
	private String language;
	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
	 */
	private String headimgurl;
	/**
	 * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	 */
	private Long subscribetime;

	private String unionid;

	private Long groupid;
	
	private Long mbprovinceid;
	private Long mbcityid;
	private String mboperator;
	private String tags;
	private String channel;
	private String createtime;
	private String createip;
	private String updatetime;
	private String updateip;
	
	/**
	 * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	 */
	@SuppressWarnings("unused")
	private String subscribe_show;
	
	/**
	 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 */
	@SuppressWarnings("unused")
	private String sex_show;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public Long getSubscribetime() {
		return subscribetime;
	}

	public void setSubscribetime(Long subscribetime) {
		this.subscribetime = subscribetime;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public Long getGroupid() {
		return groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public Long getMbprovinceid() {
		return mbprovinceid;
	}

	public void setMbprovinceid(Long mbprovinceid) {
		this.mbprovinceid = mbprovinceid;
	}

	public Long getMbcityid() {
		return mbcityid;
	}

	public void setMbcityid(Long mbcityid) {
		this.mbcityid = mbcityid;
	}

	public String getMboperator() {
		return mboperator;
	}

	public void setMboperator(String mboperator) {
		this.mboperator = mboperator;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getCreateip() {
		return createip;
	}

	public void setCreateip(String createip) {
		this.createip = createip;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdateip() {
		return updateip;
	}

	public void setUpdateip(String updateip) {
		this.updateip = updateip;
	}
		
	@Transient
	public String getSubscribe_show(){
		if (subscribe == null) {
			return "";
		} else if (subscribe == 0) {
			return "未关注";
		}
		return "已关注";
	}
	
	@Transient
	public String getSex_show(){
		if (sex == null) {
			return "";
		} else if (sex == 1) {
			return "男";
		} else if (sex == 2) {
			return "女";
		} else if (sex == 0) {
			return "未知";
		}
		return "";
	}

}
