package com.test02.controller;

import com.test02.entity.Board;
import com.test02.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller // 스프링이 해당 클래스가 컨트롤러임을 인식하게 하기 위한 애너테이션
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시글 작성 페이지
    @GetMapping("/board/write") // localhost:3000/board/write
    public String boardWriteForm() {

        return "boardwrite";
    }

    // 게시글 작성
    @PostMapping("/board/writesubmit")
    public String boardWriteSubmit(Board board, RedirectAttributes redirectAttributes){
        boardService.write(board);
        // 작성 완료 메시지 설정
        redirectAttributes.addAttribute("writeComplete", true);

        return "redirect:/board/list"; // 리스트 페이지로 리다이렉트
    }

    // 게시글 리스트 페이지
    @GetMapping("/board/list")
    public String boardList(Model model) {
        // 반환된 리스트를 list 라는 이름으로 넘기겠다
        model.addAttribute("list", boardService.boardList());
        return "boardlist";
    }

    // 게시글 상세 페이지
    @GetMapping("/board/view") // localhost:3000/board/view?id=id
    public String boardView(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));

        return "boardView";
    }
}
