
package dev.abbasadel.smava.service.persistence.simple;

import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.models.UserAccount;
import dev.abbasadel.smava.core.services.BankAccountService;
import dev.abbasadel.smava.core.services.UserAccountService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasadel
 */
@Service
public class InMemoryUserAccountRepository implements UserAccountService{
    
    @Autowired
    BankAccountService  bankAccountService;

    Map<Long,UserAccount> memory = new HashMap();
    AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public <S extends UserAccount> S save(S entity) {
        if(entity.getId() == null || entity.getId() == 0){
            entity.setId(idGenerator.getAndIncrement());
        }
        
        memory.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public UserAccount findOne(Long id) {
        UserAccount userAccount =  memory.get(id);
        userAccount.setBankAccounts((List<BankAccount>)bankAccountService.findforUserAccount(userAccount));
        return userAccount;
    }

    @Override
    public boolean exists(Long id) {
        return memory.get(id) != null;
    }

    @Override
    public Iterable<UserAccount> findAll() {
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
    public void delete(UserAccount entity) {
        memory.remove(entity.getId());
    }


    @Override
    public void deleteAll() {
        memory.clear();
    }
    
    
    @Override
    public void delete(Iterable<? extends UserAccount> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public <S extends UserAccount> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Iterable<UserAccount> findAll(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
