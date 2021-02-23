package com.woorea.openstack.keystone.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Users implements Iterable<User>,  Serializable {

	@JsonProperty("users")
	private List<User> list;

	/**
	 * @return the list
	 */
	public List<User> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		ObjectMapper  objectMapper  = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return MoreObjects.toStringHelper(this)
				.add("users", list)
				.toString();
	}

	@Override
	public Iterator<User> iterator() {
		return list.iterator();
	}
	
}
