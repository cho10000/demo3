package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Board;
import com.example.demo.domain.Reply;
import com.example.demo.mapper.BoardMapper;

@Service
public class BoardService {
    @Autowired private BoardMapper m;
	
    public List<Board> getBoard(){
        return m.getBoard();
    }

    public boolean addBoard(Board b) {
        return m.addBoard(b);
    }
    
	public Board getBoardOne(int idx) {
        return m.getBoardOne(idx);
    }
	
    public boolean addReply(Reply r) {
        return m.addReply(r);
    }
    public List<Reply> getReply(int boardIdx) {
        return m.getReply(boardIdx);
    }
}
