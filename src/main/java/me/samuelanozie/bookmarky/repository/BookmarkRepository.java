package me.samuelanozie.bookmarky.repository;

import me.samuelanozie.bookmarky.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

}
