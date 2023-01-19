package pl.swies.interviewtask.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.swies.interviewtask.entity.RecordEntity;
import pl.swies.interviewtask.service.RecordEntityService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RecordEntityController {

    private RecordEntityService service;

    @Autowired
    public RecordEntityController(RecordEntityService service) {
        this.service = service;
    }

    @GetMapping("/recordentity")
    public List<RecordEntity> getById(@RequestParam List<String> primaryKey) {
        if (primaryKey == null || primaryKey.isEmpty())
            throw new RecordNotFoundException("No primary key was given.");
        List<RecordEntity> list = service.findAllById(primaryKey);
        if (list.isEmpty())
            throw new RecordNotFoundException("Record not found for primary key: " + primaryKey.stream()
                    .map(id -> "" + id + ", ").collect(Collectors.joining()));
        return list;
    }


    @PostMapping("/recordentity")
    public ResponseEntity<Object> saveFileContent(@RequestParam(value = "file1", required = true) MultipartFile csv) throws Exception {
        if (csv.isEmpty())
            throw new RuntimeException("Given file is empty");
        service.save(csv);
        return new ResponseEntity<>("File content persisted successfully", HttpStatus.OK);
    }


    @DeleteMapping("/recordentity")
    public String deleteRecord(@RequestParam String primaryKey) {
        if (!StringUtils.hasLength(primaryKey))
            throw new RecordNotFoundException("No primary key was given.");
        service.deleteById(primaryKey);
        return "Record with id: " + primaryKey + " deleted";
    }
}
