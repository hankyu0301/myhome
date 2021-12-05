package org.hankyu.myhome.service;

import org.hankyu.myhome.model.Board;
import org.hankyu.myhome.model.User;
import org.hankyu.myhome.repository.BoardRepository;
import org.hankyu.myhome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username, Board board) {
        User user = userRepository.findByUsername(username);
        board.setUser(user);
        return boardRepository.save(board);
    }

}
