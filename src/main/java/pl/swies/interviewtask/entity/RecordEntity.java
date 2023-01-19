package pl.swies.interviewtask.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "record_entity")
public class RecordEntity {

    @Id
    @Column(name = "PrimaryKey")
    private String primaryKey;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "UpdatedTimestamp")
    private String updatedTimestamp;

    public RecordEntity() {
    }

    public RecordEntity(String id, String name, String description, String updatedTimestamp) {
        primaryKey = id;
        this.name = name;
        this.description = description;
        this.updatedTimestamp = updatedTimestamp;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(String updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @Override
    public String toString() {
        return "RecordEntity{" +
                "Id='" + primaryKey + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", updatedTimestamp='" + updatedTimestamp + '\'' +
                '}';
    }
}
