package com.kurdsoft.instagram.user;


import com.kurdsoft.instagram.common.exceptions.ConflictException;
import com.kurdsoft.instagram.common.exceptions.NotFound;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.config.ConfigDataException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class UserService implements IUserService{

    private final UserRepo repo;
    @Override
    public User save(User user) {
        List<User> userList=(List<User>) repo.findAll();
        for(User user1:userList){
            if(user1.getGmailAcount()==user1.getGmailAcount() &&
                    user1.getPhoneNumber()==user1.getPhoneNumber() &&
                    user1.getUserName()==user1.getUserName())
            throw new ConflictException("We already have this information.");
        }
        return repo.save(user);
    }

    @Override
    public User update(User user) {
        User lastItem=getById(user.getId());
        lastItem.setUserName(user.getUserName());
        lastItem.setGmailAcount(user.getGmailAcount());
        lastItem.setPhoneNumber(user.getPhoneNumber());
        lastItem.setPassword(user.getPassword());
        return repo.save(lastItem);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optionalUser=repo.findById(id);
        if(!optionalUser.isPresent())
        {
            throw new NotFound("Not found id");
        }
        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    public Page<User> paging(Integer page, Integer size) {
        return repo.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }
}
