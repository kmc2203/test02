package com.test02.service;

import com.test02.entity.Board;
import com.test02.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 데이터 저장하기
    public void write(Board board) {
        boardRepository.save(board);
    }

    // 리스트 긁어오기
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    // 게시물 상세 페이지 불러오기
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }
}
