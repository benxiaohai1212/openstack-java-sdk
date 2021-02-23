package com.woorea.openstack.examples;


import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.base.client.OpenStackSimpleTokenProvider;
import com.woorea.openstack.examples.hpcloud.Keystone3Authentication;
import com.woorea.openstack.keystone.utils.KeystoneUtils;
import com.woorea.openstack.keystone.v3.Keystone;
import com.woorea.openstack.keystone.v3.api.*;
import com.woorea.openstack.keystone.v3.model.Authentication;
import com.woorea.openstack.keystone.v3.model.Projects;
import com.woorea.openstack.keystone.v3.model.Token;
import com.woorea.openstack.keystone.v3.model.Users;
import com.woorea.openstack.quantum.Quantum;

public class ExamplesConfiguration {

	public static final String KEYSTONE_AUTH_URL = "http://swan-controller:5000/v3";
	
	public static final String KEYSTONE_USERNAME = "admin";
	
	public static final String KEYSTONE_PASSWORD = "openstack";
	
	public static final String KEYSTONE_ENDPOINT = "http://swan-controller:5000/v3";
	
	public static final String TENANT_NAME = "admin";
	public static final String DEFAULT_NAME = "default";

	public static final String NOVA_ENDPOINT = "http://compute/v2";
	
	public static final String CEILOMETER_ENDPOINT = "";
	
	public static void main(String[] args) {
//		Keystone client = new Keystone(KEYSTONE_ENDPOINT);
//		client.setTokenProvider(new OpenStackSimpleTokenProvider("secret0"));
//		client.tenants().delete("36c481aec1d54fc49190c92c3ef6840a").execute();
//		Tenant tenant = client.tenants().create(new Tenant("new_api")).execute();
//		System.out.println(tenant);
//		System.out.println(client.tenants().list().execute());
//		client.tenants().delete(tenant.getId()).execute();
		Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);

		Authentication auth = new Authentication();
		auth.setIdentity(Authentication.Identity.password(ExamplesConfiguration.DEFAULT_NAME,ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD));
		auth.setScope(Authentication.Scope.project(ExamplesConfiguration.DEFAULT_NAME,ExamplesConfiguration.TENANT_NAME));

		OpenStackResponse response = keystone.tokens().authenticate(auth).request();
		keystone.setTokenProvider(new OpenStackSimpleTokenProvider(response.header("X-Subject-Token")));

		Token token = response.getEntity(Token.class);
		System.out.println(token);

		UsersResource usersResource = new UsersResource(keystone);
		System.out.println(usersResource.list().execute().getList());

		ProjectsResource projects = new ProjectsResource(keystone);
		System.out.println(projects.list().execute().getList());

		PoliciesResource policies = new PoliciesResource(keystone);
		System.out.println(policies.list().execute().getList());

		DomainsResource domains = new DomainsResource(keystone);
		System.out.println(domains.list().execute().getList());
	}
	
}
