package edu.udacity.java.nano.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class WebSocketChatController {
    /**
     * Login Page
     */
    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    /**
     * Chatroom Page
     */
    @GetMapping("/index")
    public ModelAndView index(String username, HttpServletRequest request) throws UnknownHostException {
        //TODO: add code for login to chatroom.
        ModelAndView mv = new ModelAndView("/chat");
        if( "".equalsIgnoreCase(username)){
            username = "John Doe";
        }

        mv.addObject("username", username);
        // TODO: To return Route = "ws://localhost:8080/chat"
        mv.addObject("url","ws://" + InetAddress.getLocalHost().getHostName() + ":" +request.getServerPort()+request.getContextPath() + "/chat");
        return mv;
    }
}
