
package dev.abbasadel.smava.service.persistence.simple;

import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.services.BankAccountService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasadel
 */

@Service
public class InMemoryBankAccountRepository  implements BankAccountService{
    
    Map<Long,BankAccount> memory = new HashMap();
    AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public <S extends BankAccount> S save(S entity) {
        entity.setId(idGenerator.get());
        memory.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public BankAccount findOne(Long id) {
        return memory.remove(id);
    }

    @Override
    public boolean exists(Long id) {
        return memory.get(id) != null;
    }

    @Override
    public Iterable<BankAccount> findAll() {
        return memory.values();
    }


    @Override
    public long count() {
        return memory.size();
    }

    @Override
    public void delete(Long id) {
        memory.remove(id);
    }

    @Override
    public void delete(BankAccount entity) {
        memory.remove(entity.getId());
    }


    @Override
    public void deleteAll() {
        memory.clear();
    }
    
    
    @Override
    public void delete(Iterable<? extends BankAccount> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public <S extends BankAccount> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Iterable<BankAccount> findAll(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
