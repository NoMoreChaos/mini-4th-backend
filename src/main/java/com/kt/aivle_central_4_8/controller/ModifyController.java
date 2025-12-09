package com.kt.aivle_central_4_8.controller;

import com.kt.aivle_central_4_8.dto.ApiResponse;
import com.kt.aivle_central_4_8.dto.book.request.ModifyLoadRequest;
import com.kt.aivle_central_4_8.dto.book.request.ModifyRequest;
import com.kt.aivle_central_4_8.dto.book.response.ModifyLoadDto;
import com.kt.aivle_central_4_8.service.ModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class ModifyController {
    private final ModifyService modifyService;

    @GetMapping("/modify")
    public ApiResponse<ModifyLoadDto> LoadModify(@RequestParam String bookCd){
        ModifyLoadDto dto = modifyService.getModifier(bookCd);
        if(dto != null)
            return ApiResponse.success(dto);
        else
            return ApiResponse.failure("전달에 오류가 발생했습니다.");
    }

    @PutMapping("/modify")
    public ApiResponse<?> ModifyBook(@RequestParam ModifyRequest request){
        return modifyService.putModified(request) ?
                ApiResponse.success(null) : ApiResponse.failure("저장에 실패하였습니다.");
    }
}
