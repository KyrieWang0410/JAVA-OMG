package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 作者
 *
 * @author Kyrie.Wang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Author {
    /** id **/
    private Long id;

    /** 姓名 **/
    private String name;

    /** 年龄 **/
    private Integer age;

    /** 简介 **/
    private String intro;

    /** 作品 **/
    private List<Book> books;

}
