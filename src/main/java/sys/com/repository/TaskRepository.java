package sys.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sys.com.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
