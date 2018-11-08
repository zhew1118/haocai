package dqyhyy.haocai.repository;

import dqyhyy.haocai.domain.Haocai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HaocaiRepository extends JpaRepository<Haocai, Integer> {
    List<Haocai> findByHaocaiStatus(Integer haocaiStatus);
}
