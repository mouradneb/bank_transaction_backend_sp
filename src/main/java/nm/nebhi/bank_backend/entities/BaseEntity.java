package nm.nebhi.bank_backend.entities;




import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Mourad NEBHI
 * @version 1.0
 *
 * @apiNote Define parent class for all persisted entities, to generate @Id for all classes
 *          Marked by :
 *              @MappedSuperclass to avoid persistansce
 *              @Data to generate getters and setters for id in subclasses.
 *
 *          Identifier is auto generated
 */
@MappedSuperclass
@Data
public abstract class BaseEntity extends RepresentationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
}
