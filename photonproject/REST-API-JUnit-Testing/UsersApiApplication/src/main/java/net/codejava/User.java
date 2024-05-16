package net.codejava;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity 
@Table(name = "users")
public class User {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 255, nullable = false)
    @NotBlank(message = "Name must not be empty")
    private String name;
    
    @Column(length = 50, nullable = false)
    @NotBlank(message = "Project must not be empty")
    private String project;
    
    @Column(length = 255, nullable = false)
    @NotBlank(message = "Bounded Context must not be empty")
    private String boundedContext;
    
    @Column(length = 255, nullable = false)
    @NotBlank(message = "Namespace must not be empty")
    private String namespace;
    
    @Column(length = 255, nullable = false)
    @NotBlank(message = "Status must not be empty")
    private String status;
    
    @Column(length = 1000, nullable = false)
    @NotBlank(message = "Tags must not be empty")
    private String tags;
    
    @Column(nullable = false)
    private LocalDateTime created_at;
    
    @Column(nullable = false)
    private LocalDateTime updated_at;

    // Constructors
    public User() {
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    public User(String name, String project, String boundedContext, String namespace, String status, String tags, LocalDateTime created_at, LocalDateTime updated_at) {
        this.name = name;
        this.project = project;
        this.boundedContext = boundedContext;
        this.namespace = namespace;
        this.status = status;
        this.tags = tags;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getBoundedContext() {
        return boundedContext;
    }

    public void setBoundedContext(String boundedContext) {
        this.boundedContext = boundedContext;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(@NotBlank(message = "Tags must not be empty") String list) {
        this.tags = list;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    // Hashcode and Equals methods
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(id, other.id);
    }

    // Override toString() for better logging
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", project='" + project + '\'' +
                ", boundedContext='" + boundedContext + '\'' +
                ", namespace='" + namespace + '\'' +
                ", status='" + status + '\'' +
                ", tags='" + tags + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }


    public User id(Long id) {
		this.id = id;
		return this;
	}

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}