package com.beyond.board.author.dto;

import com.beyond.board.author.domain.Author;
import com.beyond.board.author.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSaveReqDto {
    private String name;
    private String email;
    private String password;
    private Role role; // 사용자가 String 요청해도 Role 클래스 자동 형변환.

    private PasswordEncoder passwordEncoder;

    public Author toEntity(String passwordEncoder){
        Author author = Author.builder()
                .password(passwordEncoder)
                .name(this.name)
                .email(this.email).role(this.role)
                .posts(new ArrayList<>())
                .build();
        return author;
    }
}
