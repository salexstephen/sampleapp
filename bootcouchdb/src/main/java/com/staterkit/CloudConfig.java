package com.staterkit;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import com.couchbase.client.java.cluster.ClusterInfo;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;

@Configuration
@EnableCouchbaseRepositories

public class CloudConfig extends AbstractCouchbaseConfiguration {

	// @Value("${couchbase.cluster.bucket}")
	// private String bucketName;
	//
	// @Value("${couchbase.cluster.password}")
	// private String password;
	//
	// @Value("${couchbase.cluster.ip}")
	// private String ip;

	@PostConstruct
	public void init() {
		// CouchDbClient dbClient = new CouchDbClient();
		// org.lightcouch.DesignDocument designDoc =
		// dbClient.design().getFromDesk("Album");
		// Response response = dbClient.design().synchronizeWithDb(designDoc);
	}

	@Override
	protected String getBucketName() {
		// return "Album";
		return "ac2501cf-ea19-43e1-b582-8176fd900ff5-bluemix";
	}

	@Override
	protected String getBucketPassword() {
		return "053816238c36c08ba68ff3c5a10698dd8b6b32eaf19300c54a34afbca7b825e6";
		// return "";
	}

	@Override
	protected List<String> getBootstrapHosts() {
		try {
			return Arrays.asList("ac2501cf-ea19-43e1-b582-8176fd900ff5-bluemix.cloudant.com");
			// return Arrays.asList("localhost");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected CouchbaseEnvironment getEnvironment() {
		int port = 443;
		// int port = 5984;
		CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder().bootstrapHttpDirectPort(port)
				.connectTimeout(10000).build();
		return env;
	}

	@Override
	public ClusterInfo couchbaseClusterInfo() throws Exception {
		return couchbaseCluster().clusterManager("ac2501cf-ea19-43e1-b582-8176fd900ff5-bluemix",
				"053816238c36c08ba68ff3c5a10698dd8b6b32eaf19300c54a34afbca7b825e6").info();
		// return couchbaseCluster().clusterManager("admin", "admin").info();

	}

}
