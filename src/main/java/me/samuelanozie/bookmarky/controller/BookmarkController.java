package me.samuelanozie.bookmarky.controller;


import me.samuelanozie.bookmarky.model.Bookmark;
import me.samuelanozie.bookmarky.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class BookmarkController {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    @GetMapping("bookmarks")
    public List<Bookmark> getAllBookmarks() {
        return bookmarkRepository.findAll();
    }

    @GetMapping("bookmarks/{id}")
    public Bookmark getBookmarkById(@PathVariable Long id) {
        return bookmarkRepository.findById(id).orElseThrow(() -> new RuntimeException("Bookmark not found"));
    }

    @PostMapping("bookmarks")
    public Bookmark createBookmark(@RequestBody Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }

    @PutMapping("bookmarks/{id}")
    public Bookmark updateBookmark(@PathVariable Long id, @RequestBody Bookmark bookmark) {

        Bookmark existingBookmark = bookmarkRepository.findById(id).orElseThrow(() -> new RuntimeException("Bookmark not found"));
        existingBookmark.setTitle(bookmark.getTitle());
        existingBookmark.setUrl(bookmark.getUrl());
        existingBookmark.setDescription(bookmark.getDescription());
        return bookmarkRepository.save(existingBookmark);

    }

    @DeleteMapping("bookmarks/{id}")
    public String deleteBookmark(@PathVariable Long id) {
        bookmarkRepository.findById(id).orElseThrow(() -> new RuntimeException("Bookmark not found"));
        bookmarkRepository.deleteById(id);
        return "Bookmark deleted successfully";
    }
}
