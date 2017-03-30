package chas.twitter.clone.service;

import chas.twitter.clone.domain.model.User;
import chas.twitter.clone.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class TwitterCloneUserDetailsService implements UserDetailsService {

   private final  UserRepository userRepository;

    @Autowired
    public TwitterCloneUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOne(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " is not found.");
        }
        return new TwitterCloneUserDetails(user);
    }
}
