package com.woorea.openstack.keystone.v3.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonRootName("policy")
public class Policy {
	
	private String id;

	private String projectId;
	
	private String type;
	
	private String userId;
	
	private Map<String, String> blob = new HashMap<String, String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<String, String> getBlob() {
		return blob;
	}

	public void setBlob(Map<String, String> blob) {
		this.blob = blob;
	}

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "Policy{" +
				"id='" + id + '\'' +
				", projectId='" + projectId + '\'' +
				", type='" + type + '\'' +
				", userId='" + userId + '\'' +
				", blob=" + blob +
				'}';
	}
}
