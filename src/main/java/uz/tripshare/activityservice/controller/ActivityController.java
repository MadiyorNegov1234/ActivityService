package uz.tripshare.activityservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.tripshare.activityservice.service.activityservice.ActivityServiceImpl;
import uz.tripshare.domain.common.Activity;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityServiceImpl activityService;


    @PostMapping("/save/{tripId}")
    public Activity save(@PathVariable("tripId") Integer tripId) {
        return activityService.save(tripId);
    }

    @PutMapping("/id/{tripId}/{request}")
    public Activity update(@PathVariable("tripId") Integer tripId, @PathVariable("request") Integer request) {
        return activityService.update(tripId, request);
    }

    @GetMapping("/{id}")
    public Activity getActivityById(@PathVariable("id") Integer id) {
        return activityService.findById(id);
    }

    @GetMapping("/get-all")
    public List<Activity> findAll() {
        return activityService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteActivityById(@PathVariable("id") Integer id) {
        activityService.delete(id);
    }

    @GetMapping("/by-trip/{tripId}")
    public List<Activity> getActivitiesByTripId(@PathVariable("tripId") Integer tripId) {
        return activityService.findByTripId(tripId);
    }
}
