package com.staterkit.repositories;

import java.util.List;

import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;

import com.staterkit.domain.Album;

/**
 * @author narendra.gurram@cognizant.com
 * @description JpaRepository reads system environment variables (VCAP_SERVICE) and establish a connection with DB using
 *   connection parameters. It creates a table 'Album' (domain class passed as an argument).
 *   Its having build-in methods for CRUD operation.
 *
 */
public interface CouchAlbumRepository extends CrudRepository<Album, String> {
	
	@View(designDocument = "Album")
	public List<Album> findAll();
	
	@View(designDocument = "Album",viewName = "id")
	public List<Album> findById();
}
