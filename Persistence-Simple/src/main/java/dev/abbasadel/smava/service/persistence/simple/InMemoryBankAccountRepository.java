
package dev.abbasadel.smava.service.persistence.simple;

import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.models.UserAccount;
import dev.abbasadel.smava.core.services.BankAccountService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasadel
 */

@Service
public class InMemoryBankAccountRepository  implements BankAccountService{
    
    Map<Long,BankAccount> bankaccounts = new HashMap();
    Map<Long,List<Long>> joinTable = new HashMap();
    
    
    AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public <S extends BankAccount> S save(S entity) {
        entity.setId(idGenerator.get());
        bankaccounts.put(entity.getId(), entity);
        joinWithUserAccount(entity);
        return entity;
    }

    @Override
    public BankAccount findOne(Long id) {
        return bankaccounts.get(id);
    }

    @Override
    public boolean exists(Long id) {
        return bankaccounts.get(id) != null;
    }

    @Override
    public Iterable<BankAccount> findAll() {
        return bankaccounts.values();
    }


    @Override
    public long count() {
        return bankaccounts.size();
    }

    @Override
    public void delete(Long id) {
        bankaccounts.remove(id);
    }

    @Override
    public void delete(BankAccount entity) {
        bankaccounts.remove(entity.getId());
    }


    @Override
    public void deleteAll() {
        bankaccounts.clear();
    }
    

    
    @Override
    public Iterable<BankAccount> findAll(Iterable<Long> ids) {
        if(ids == null) return null;
        List<BankAccount> all = new ArrayList();
        for(Long id: ids){
            all.add(findOne(id));
        }
        return all;
    }

    private <S extends BankAccount> void joinWithUserAccount(S entity) {
        if(entity.getUserAccount() != null){
            List<Long> listOfBankAccounts = joinTable.getOrDefault(entity.getUserAccount().getId(), new ArrayList<Long>());
            listOfBankAccounts.add(entity.getId());
            joinTable.put(entity.getUserAccount().getId(), listOfBankAccounts);
        }
    }

    @Override
    public Iterable<BankAccount> findforUserAccount(UserAccount userAccount) {
        List<Long> listOfBankAccountIds = joinTable.get(userAccount.getId());
        return findAll(listOfBankAccountIds);
    }
    
        
    @Override
    public void delete(Iterable<? extends BankAccount> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public <S extends BankAccount> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
