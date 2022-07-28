package grigdim.springFramework.spring5webapp.bootstrap;

import grigdim.springFramework.spring5webapp.entities.Author;
import grigdim.springFramework.spring5webapp.entities.Book;
import grigdim.springFramework.spring5webapp.entities.Publisher;
import grigdim.springFramework.spring5webapp.repos.AuthorRepo;
import grigdim.springFramework.spring5webapp.repos.BookRepo;
import grigdim.springFramework.spring5webapp.repos.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher("SFG Publishing", "St Petersburg", "FL");
        publisherRepo.save(publisher);
        System.out.println("Publisher count: " + publisherRepo.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepo.save(eric);
        bookRepo.save(ddd);
        publisherRepo.save(publisher);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepo.save(rod);
        bookRepo.save(noEJB);
        publisherRepo.save(publisher);


        System.out.println("Number of books: " + bookRepo.count());
        System.out.println("Publisher Number of books: " + publisher.getBooks().size());
    }
}
