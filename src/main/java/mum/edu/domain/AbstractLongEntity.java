package mum.edu.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.OptimisticLockType;

/**
 * 
 * @author kimtey
 * 
 */
@MappedSuperclass
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.VERSION)
public abstract class AbstractLongEntity implements Entity<Long> {

    /**
     * Serial version id.
     */
    private static final long serialVersionUID = 1L;

    @Version
    @Column(name = "entity_version", columnDefinition = "int default 1")
    private int entityVersion = 1;
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    

    /**
     * Constructeur.
     */
    public AbstractLongEntity() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public Long getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Compare two enties by id and instance of runtime class.
     * if entity is null or entity.getId() is null, it will return false
     * @param entity
     * @return boolean
     */
    public boolean equals(final AbstractLongEntity entity) {
        if (entity == null || entity.getId() == null) {
            return false;
        }
        return entity.getId().equals(this.getId()) && getClass().equals(entity.getClass());
    }

    /**
     * @return the entity version
     */
    public int getEntityVersion() {
        return entityVersion;
    }

    /**
     * @param entityVersion
     *            the entity version to set
     */
    public void setEntityVersion(final int entityVersion) {
        this.entityVersion = entityVersion;
    }

}
