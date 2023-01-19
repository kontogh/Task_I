package pl.swies.interviewtask.service;

import org.springframework.web.multipart.MultipartFile;
import pl.swies.interviewtask.entity.RecordEntity;

import java.util.List;

public interface RecordEntityService {

    void save(MultipartFile recordEntity) throws Exception;

    List<RecordEntity> findAllById(List<String> primaryKey);

    void deleteById(String primaryKey);
}
