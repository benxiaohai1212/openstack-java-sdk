package com.woorea.openstack.keystone.v3.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;

@JsonRootName("token")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Token implements Serializable {
	
	private String id;
	
	@JsonProperty("expires_at")
	private Calendar expiresAt;
	
	@JsonProperty("issued_at")
	private Calendar issuedAt;
	
	private List<String> methods;
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static final class Domain {
		
		private String id;
		
		private String name;

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

		@Override
		public String toString() {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				return objectMapper.writeValueAsString(this);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return MoreObjects.toStringHelper(this)
					.add("id",id)
					.add("name",name)
					.toString();
		}
	}
	
	private Domain domain;
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static final class Project {
		
		private Domain domain;
		
		private String id;
		
		private String name;

		public Domain getDomain() {
			return domain;
		}

		public void setDomain(Domain domain) {
			this.domain = domain;
		}

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

		@Override
		public String toString() {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				return objectMapper.writeValueAsString(this);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return MoreObjects.toStringHelper(this)
					.add("id",id)
					.add("name",name)
					.add("domain",domain)
					.toString();
		}
	}
	
	private Project project;
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static final class User {
		
		private String id;
		
		private String name;

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

	}
	
	private User user;
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static final class Role {
		
		private String id;
		
		private String name;
		
	}
	
	private List<Role> roles;
	
	public static final class Service {
		
		public static final class Endpoint {
			
			private String id;
			
			private String url;
			
			private String region;
			
			private Boolean enabled;
			
			@JsonProperty("legacy_endpoint_id")
			private String legacyEndpointId;
			
			@JsonProperty("interface")
			private String iface;

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public String getRegion() {
				return region;
			}

			public void setRegion(String region) {
				this.region = region;
			}

			public Boolean getEnabled() {
				return enabled;
			}

			public void setEnabled(Boolean enabled) {
				this.enabled = enabled;
			}

			public String getLegacyEndpointId() {
				return legacyEndpointId;
			}

			public void setLegacyEndpointId(String legacyEndpointId) {
				this.legacyEndpointId = legacyEndpointId;
			}

			public String getInterface() {
				return iface;
			}

			public void setInterface(String iface) {
				this.iface = iface;
			}
			
		}
		
		private String id;
		
		private String type;
		
		private List<Endpoint> endpoints;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<Endpoint> getEndpoints() {
			return endpoints;
		}

		public void setEndpoints(List<Endpoint> endpoints) {
			this.endpoints = endpoints;
		}
		
	}
	
	private List<Service> catalog;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Calendar expiresAt) {
		this.expiresAt = expiresAt;
	}

	public Calendar getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Calendar issuedAt) {
		this.issuedAt = issuedAt;
	}

	public List<String> getMethods() {
		return methods;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Service> getCatalog() {
		return catalog;
	}

	public void setCatalog(List<Service> catalog) {
		this.catalog = catalog;
	}

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return MoreObjects.toStringHelper(this)
				.add("id",id)
				.add("expiresAt",expiresAt)
				.add("issuedAt",issuedAt)
				.add("methods",methods)
				.add("domain",domain)
				.add("project",project)
				.add("user",user)
				.add("roles",roles)
				.add("catalog",catalog)
				.toString();
	}

}
