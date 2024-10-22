package uz.tripshare.activityservice.service.activityservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tripshare.activityservice.clints.TripServiceClient;
import uz.tripshare.activityservice.entity.ActivityEntity;
import uz.tripshare.activityservice.repository.ActivityRepository;
import uz.tripshare.domain.common.Activity;
import uz.tripshare.domain.common.Trip;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final TripServiceClient tripServiceClient;

    @Transactional
    @Override
    public Activity save(Integer entity) {
        Trip tripById = tripServiceClient.getTripById(entity);

        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setTripId(tripById.getId());
        ActivityEntity save = activityRepository.save(activityEntity);
        return mapEntityToResponse(save);
    }

    @Transactional
    @Override
    public Activity update(Integer id, Integer request) {
        ActivityEntity entity = findEntityById(id);

        Trip trip = tripServiceClient.getTripById(request);
        entity.setTripId(trip.getId());
        ActivityEntity update = activityRepository.save(entity);
        return mapEntityToResponse(update);
    }

    @Override
    public Activity findById(Integer id) {
        ActivityEntity entityById = findEntityById(id);
        return mapEntityToResponse(entityById);
    }

    @Override
    public ActivityEntity findEntityById(Integer id) {
        return activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found "));
    }

    @Override
    public List<Activity> findAll() {
        List<ActivityEntity> all = activityRepository.findAll();
        return all.stream().map(this::mapEntityToResponse).toList();
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        ActivityEntity entityById = findEntityById(id);
        activityRepository.delete(entityById);
    }

    @Override
    public Activity mapEntityToResponse(ActivityEntity entity) {
        Activity activity = new Activity();
        activity.setName(entity.getName());
        activity.setDescription(entity.getDescription());
        activity.setLocation(entity.getLocation());
        activity.setPrice(entity.getPrice());
        return activity;
    }


    @Transactional
    public List<Activity> findByTripId(Integer tripId) {
        List<ActivityEntity> byTripId = activityRepository.findByTripId(tripId);
        return byTripId.stream().
                map(this::mapEntityToResponse)
                .collect(Collectors.toList());
    }
}

