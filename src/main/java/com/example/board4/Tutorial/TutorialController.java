package com.example.board4.Tutorial;

import com.example.board4.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    TutorialRepository tutoralsRepostory;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title, @RequestBody Tutorial tutorial) {
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();
            if (title == null) {
                tutoralsRepostory.findAll().forEach(tutorials::add);
            } else {
                tutoralsRepostory.findByTitleContaining(title).forEach(tutorials::add);
            }
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        Tutorial tutorial = tutoralsRepostory.findById(id);
        if (tutorial != null) {
            return new ResponseEntity<>(tutorial, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tutorials")
    public ResponseEntity<String> createTutorial(@RequestBody Tutorial tutorial) {
        try {
            tutoralsRepostory.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
            return new ResponseEntity<>("Tutorial was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<String> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        Tutorial _tutorial = tutoralsRepostory.findById(id);
        if (_tutorial != null) {
            _tutorial.setId(id);
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            tutoralsRepostory.update(_tutorial);
            return new ResponseEntity<>("Tutorial was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<String> deleteTutorial(@PathVariable("id") long id) {
        try {
            int result = tutoralsRepostory.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Tutorial was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete tutorial.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<String> deleteAllTutorials() {
        try {
            int numRows = tutoralsRepostory.deleteAll();
            return new ResponseEntity<>("Deleted " + numRows + " Tutorial(s) successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete tutorials.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        try {
            List<Tutorial> tutorials = tutoralsRepostory.findByPublished(true);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
