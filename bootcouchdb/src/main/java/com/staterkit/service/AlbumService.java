/**
 * 
 */
package com.staterkit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.query.View;
import org.springframework.stereotype.Service;

import com.staterkit.domain.Album;
import com.staterkit.repositories.CouchAlbumRepository;

/**
 * @author narendra.gurram@cognizant.com
 *
 */
@Service
public class AlbumService {

	@Autowired
	private CouchAlbumRepository couchAlbumRepository;

	
	/**
	 * Get all the task from 'Album' Table by calling the findAll method
	 * 
	 * @return List of Albums
	 */
	
	public List<Album> getAlbumList() {
		return (List<Album>) couchAlbumRepository.findAll();
	}

	/**
	 * Remove the task from 'Album' table by calling delete method
	 * 
	 * @param albumId
	 */

	public void removeAlbum(String albumId) {
		couchAlbumRepository.delete(albumId);
	}

	

	/**
	 * Save new task into 'Album' table by calling the save method
	 * 
	 * @param title
	 * @param artist
	 * @param releaseYear
	 * @return boolean
	 */
	public boolean saveAlbum(String title, String artist, String releaseYear) {
		Album album = new Album(title, artist, releaseYear);
		Album savedAlbum = couchAlbumRepository.save(album);
		return album.getTitle().equalsIgnoreCase(savedAlbum.getTitle())? true : false;
	}

	/**
	 * Updated the album into 'Album' table by saving the album based on album id
	 * 
	 * @param id
	 * @param title
	 * @param artist
	 * @param releaseYear
	 * @return
	 */
	public boolean editAlbum(String id, String title, String artist, String releaseYear) {
		Album album = new Album(title, artist, releaseYear);
		album.setId(id);
		Album savedAlbum = couchAlbumRepository.save(album);
		return album.getId().equals(savedAlbum.getId()) ? true : false;
	}

	
}
