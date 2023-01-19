package pl.swies.interviewtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.swies.interviewtask.dao.RecordEntityRepository;
import pl.swies.interviewtask.entity.RecordEntity;
import pl.swies.interviewtask.rest.RecordNotFoundException;

import java.util.List;

@Service
public class RecordEntityServiceImpl implements RecordEntityService {

    RecordEntityRepository repository;

    @Autowired
    public RecordEntityServiceImpl(RecordEntityRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void save(MultipartFile csv) {
        List<RecordEntity> list = RecordReader.transformCsv(csv);
        for (RecordEntity re : list) {
            System.out.println(re);
            repository.save(re);
        }
    }

    @Override
    @Transactional
    public List<RecordEntity> findAllById(List<String> primaryKeys) {
        return repository.findAllByPrimaryKeyIn(primaryKeys);
    }

    @Override
    @Transactional
    public void deleteById(String primaryKey) {
        if (!repository.existsById(primaryKey))
            throw new RecordNotFoundException("Record not found for primary key: " + primaryKey);
        repository.deleteById(primaryKey);
    }
}
