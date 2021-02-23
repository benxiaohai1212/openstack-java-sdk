package com.woorea.openstack.keystone.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

@JsonRootName("user")
public class User {

	private String id;
	
	@JsonProperty("domain_id")
	private String domainId;
	
	@JsonProperty("default_project_id")
	private String defaultProjectId;
	
	private String name;
	
	private String password;
	
	private String email;
	
	private String description;
	
	private Boolean enabled;

	private Map<String,String> links;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getDefaultProjectId() {
		return defaultProjectId;
	}

	public void setDefaultProjectId(String defaultProjectId) {
		this.defaultProjectId = defaultProjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Map<String, String> getLinks() {
		return links;
	}

	public void setLinks(Map<String, String> links) {
		this.links = links;
	}

	@Override
	public String toString() {

		ObjectMapper  objectMapper  = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("name", name)
				.add("id", id)
				.add("email", email)
				.add("password", password)
				.add("description", description)
				.add("domainId", domainId)
				.add("links", links)
				.add("enabled", enabled)
				.add("defaultProjectId", defaultProjectId)
				.toString();
	}
}
