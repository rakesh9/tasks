package chas.twitter.clone.util;

import chas.twitter.clone.app.FileUploadController;
import chas.twitter.clone.domain.model.User;
import chas.twitter.clone.service.TwitterCloneUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.security.Principal;

/**
 * Created by s-sumi on 2017/03/02.
 */
//component service repository controllerは基本どれも同じで、
//クラスをDIコンテナにbeanとして登録する
public class Util {
    private static String noIcon;

    public static String[] imageExtensions ={"jpg","jpeg","png","gif"};

    public static User getLoginuserFromPrincipal(Principal principal){
        Authentication authentication=(Authentication)principal;
        TwitterCloneUserDetails userDetails=TwitterCloneUserDetails.class.cast(authentication.getPrincipal());
        return userDetails.getuser();
        /*TwitterCloneUserDetails userDetails=(TwitterCloneUserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return userDetails.getuser();*/
    }
    public static void updateAuthenticate(Principal principal, User newUser) {
        Authentication oldAuth= (Authentication) principal;
        Authentication newAuth=new UsernamePasswordAuthenticationToken(new TwitterCloneUserDetails(newUser),oldAuth.getCredentials(),oldAuth.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }

    public static String getNoIcon() {
        if(noIcon==null)
            noIcon= MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,"serveFile","noicon.png").build().toString();
        return noIcon;
    }
}
