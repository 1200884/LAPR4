/*
 * Copyright (c) 2013-2022 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.framework.domain.repositories;

import eapli.framework.domain.model.AggregateRoot;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Support for pessimistic locking.
 *
 * @param <I>
 *            the type of the business identity of the entity.
 * @param <T>
 *            the type of the entity we want to manage in the repository.
 *
 * @author Paulo Gandra Sousa 2021.03.31
 *
 * @see DomainRepository
 *
 */
public interface LockableDomainRepository<I extends Comparable<I>/* & ValueObject */, T extends AggregateRoot<I>> {

    /**
     * Acquires an exclusive write lock to a managed entity previously fetched from the persistence
     * storage.
     * <p>
     *
     * <pre>
     * products = repo.findAll();
     * ...
     * Product selected = products.get(selectedIdx);
     * Product locked = repo.lockItUp(selected);
     * ...
     * locked.changeDescription(...);
     * ...
     * Product saved = repo.save(locked);
     * </pre>
     *
     * @param entity
     * @return the managed entity
     */
    T lockItUp(@Param("entity") T entity);

    /**
     * Loads and acquires an exclusive write lock to a managed entity.
     * <p>
     * Each specific repository MUST implement this method and define the exact JPQL query
     *
     * @param id
     * @return the desired entity
     */
    Optional<T> lockOfIdentity(@Param("id") I id);
}
