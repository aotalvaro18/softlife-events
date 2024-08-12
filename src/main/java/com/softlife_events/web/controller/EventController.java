package com.softlife_events.web.controller;

import com.softlife_events.domain.Event;
import com.softlife_events.domain.service.EventService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    @ApiOperation("Get all events")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Event>> getAll() {
        return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a event whit an id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Event not foud"),
    })

    public ResponseEntity<Event> getEvent(@ApiParam(value = "The id of the event", required = true)
                   @PathVariable("id") int eventId) {
        return eventService.getEvent(eventId).map(event -> new ResponseEntity<>(event, HttpStatus.OK)).orElse
                (new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Event>> getByCategory (@PathVariable("categoryId") int categoryId) {
        return eventService.getByCategory(categoryId).map(events -> new ResponseEntity<>(events, HttpStatus.OK)
               ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Event> save(@RequestBody Event event) {
        return new ResponseEntity<>(eventService.save(event), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int eventId) {
        if(eventService.delete(eventId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Event> updateEvent(
            @ApiParam(value = "The id of the event", required = true) @PathVariable("id") int eventId,
            @RequestBody Event event) {
        return eventService.updateEvent(eventId, event)
                .map(updatedEvent -> new ResponseEntity<>(updatedEvent, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}
