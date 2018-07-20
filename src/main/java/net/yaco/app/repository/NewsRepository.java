package net.yaco.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.yaco.app.model.Article;

@Repository
public interface NewsRepository extends JpaRepository<Article, Integer> {
//	public interface NewsRepository extends CrudRepository<Article, Integer> {
	
	// select * from Article
	List<Article> findBy();
	
	// limit 3
	List<Article> findTop3ByStatusOrderByIdDesc(String status);
	
	// select * from Article where status = ?	
	List<Article> findByStatus(String status);

	// select * from Article where date = ?	
	List<Article> findByDate(Date date);
	
	// select * from Article where status = ? and date = ?
	List<Article> findByStatusAndDate(String status, Date date);

	// select * from Article where status = ? and date = ?
	List<Article> findByStatusOrDate(String status, Date date);

	// select * from Article where date between ? and ?
	List<Article> findByDateBetween(Date date1, Date date2);
	
	// select * from Article where id between ? and ?
	List<Article> findByIdBetween(int id1, int id2);
}
