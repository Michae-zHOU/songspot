package com.songspot.server.repository;

import com.songspot.server.repository.model.DemoTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DemoTrackRepository extends JpaRepository<DemoTrack, Long> {
    Optional<DemoTrack> findById(Long id);

    List<DemoTrack> findAllByArtist(String artist);

    @Query(value = "from DemoTrack as demo_track where ?1 in user.curators")
    List<DemoTrack> findAllByCurator(String curator);
}
