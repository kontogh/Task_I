package pl.swies.interviewtask.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.swies.interviewtask.entity.RecordEntity;

import java.util.List;

public interface RecordEntityRepository  extends JpaRepository<RecordEntity, String> {

    List<RecordEntity> findAllByPrimaryKeyIn(List<String> ids);

}
