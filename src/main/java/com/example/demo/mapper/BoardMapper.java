package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Board;
import com.example.demo.domain.Reply;

@Repository("BoardMapper")
public interface BoardMapper {
    public boolean addBoard(Board b);
    public List<Board> getBoard();
    public Board getBoardOne(int idx);
    public boolean addReply(Reply r);
    public List<Reply> getReply(int boardIdx);
}
