package sn.dakar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import sn.dakar.entity.BaseEntity;
import sn.dakar.repository.BaseRepository;

import java.util.Optional;

public abstract class AbstractCrudService<T extends BaseEntity> {

    protected final BaseRepository<T> repository;

    protected AbstractCrudService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public Page<T> findAll(Pageable pageable) {
        Specification<T> spec = (root, query, cb) -> cb.equal(root.get("deleted"), false);
        return repository.findAll(spec, pageable);
    }

    public Page<T> search(String filter, Pageable pageable) {
        // For simplicity, no RSQL here, but can be added
        Specification<T> spec = (root, query, cb) -> cb.equal(root.get("deleted"), false);
        return repository.findAll(spec, pageable);
    }

    public Optional<T> findById(Long id) {
        return repository.findById(id)
                .filter(entity -> !entity.isDeleted());
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
    }

    protected void beforeCreate(T entity) {}
    protected void beforeUpdate(T entity) {}
    protected void validate(T entity) {}
}