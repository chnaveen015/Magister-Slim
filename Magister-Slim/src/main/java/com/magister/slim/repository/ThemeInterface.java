package com.magister.slim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.Theme;

public interface ThemeInterface extends MongoRepository<Theme,String>{

	@Query("{'themeName':?0}")
	List<Theme> getThemes(String themeName);
	
	@Query("{'themeid':?0}")
	Theme getTheme(String themeid);

}
