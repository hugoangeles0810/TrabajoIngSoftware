/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.util.Criterio;
import java.util.List;

/**
 *
 * @author Hugo
 * @param <Entity>
 * @param <KeyType>
 */
public interface BaseService<Entity, KeyType> {

    public Entity get(KeyType key);
    public void save(Entity entity);
    public void update(Entity entity);
    public void delete(Entity entity);
    public void bulkDelete(List<Entity> entity);
    public List<Entity> getAll();
    public List<Entity> searchForCriteria(Criterio criterio);
    public Long countResultForCriteria(Criterio criterio);

}