package chas.twitter.clone.service

import chas.twitter.clone.domain.model.User
import chas.twitter.clone.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import spock.lang.Specification


class TwitterCloneUserDetailsServiceTest extends Specification {
    UserRepository userRepository
    UserDetailsService userDetailsService
    def userId = "user1"

    def setup() {
        userRepository = Mock(UserRepository)
        userDetailsService = new TwitterCloneUserDetailsService(userRepository)
    }

    def "should return user if user is found"() {
        given:
        def twitterUser = Mock(User)
        userRepository.findOne(userId) >> twitterUser

        when:
        def userByUsername = userDetailsService.loadUserByUsername(userId)

        then:
        userByUsername instanceof TwitterCloneUserDetails
        userByUsername.getuser() == twitterUser
    }

    def "should throw exception if user is not found"() {
        given:
        userRepository.findOne(userId) >> null

        when:
        userDetailsService.loadUserByUsername(userId)

        then:
        thrown(UsernameNotFoundException)
    }
}
