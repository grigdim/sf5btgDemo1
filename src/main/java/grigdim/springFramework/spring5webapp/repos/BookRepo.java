package grigdim.springFramework.spring5webapp.repos;

import grigdim.springFramework.spring5webapp.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface  BookRepo extends CrudRepository<Book,Long> {
}
