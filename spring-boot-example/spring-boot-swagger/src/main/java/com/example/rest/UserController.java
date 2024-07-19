package com.example.rest;

import com.example.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Kyrie.Wang
 */
@Api(tags = "用户信息管理")
@RestController
@RequestMapping("user")
public class UserController {


    @ApiOperation("分页查询所有数据")
    @GetMapping("page")
    public ResponseEntity<Object> selectAll() {
        return new ResponseEntity<>("查询成功", HttpStatus.OK);
    }


    @ApiOperation("通过主键查询单条数据")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "主键id",required = true,dataType = "Integer")
    )
    @GetMapping("{id}")
    public ResponseEntity<Object> selectOne(@PathVariable Integer id) {
        return new ResponseEntity<>("查询id=" + id + "的数据成功", HttpStatus.OK);
    }


    @ApiOperation("新增数据")
    @PostMapping("insert")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "user", value = "用户", required = true)
    )
    public ResponseEntity<Object> insert(@RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation("修改数据")
    @PutMapping("update")
    public ResponseEntity<Object> update(@RequestBody @ApiParam(value = "还款") User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @ApiOperation("删除数据")
    @DeleteMapping("delete")
    public ResponseEntity<Object> delete(@RequestBody Set<Long> idList) {
        return new ResponseEntity<>(idList + "删除成功", HttpStatus.OK);
    }
}

