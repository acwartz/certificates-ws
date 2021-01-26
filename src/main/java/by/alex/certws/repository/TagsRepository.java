package by.alex.certws.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import by.alex.certws.domain.Tag;

public interface TagsRepository extends PagingAndSortingRepository<Tag, Long> {
	Optional<Tag> findByName(String tagName);
}
