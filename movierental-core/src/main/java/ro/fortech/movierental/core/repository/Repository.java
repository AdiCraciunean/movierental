package ro.fortech.movierental.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import ro.fortech.movierental.core.model.BaseEntity;

import java.io.Serializable;

/**
 * Created by Adi on 16.05.2016.
 */
@NoRepositoryBean
@Transactional
public interface Repository<T extends BaseEntity<ID>, ID extends Serializable> extends JpaRepository<T, ID> {

}
