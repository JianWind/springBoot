package com.sk.boot.springboot.web;

import java.util.Date;

import com.sk.boot.springboot.DTO.ExecuteDTO;
import com.sk.boot.springboot.DTO.PageQueryParamDTO;
import com.sk.boot.springboot.DTO.PageResultDTO;
import com.sk.boot.springboot.entity.User;
import com.sk.boot.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员控制器
 *
 * @author 刘冬 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@RestController
@RequestMapping("member")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("get/{id}")
    public User get(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("save")
    public ExecuteDTO save(@RequestBody User entity) {
        repository.save(entity);
        return new ExecuteDTO(true, "保存成功", entity.getId());
    }

    @PostMapping("loadPage")
    public PageResultDTO loadPage(@RequestBody PageQueryParamDTO params) {

        // 动态查询条件
        Specification<User> spec = (root, query, cb) -> {
            if (params.getQuery() != null) {
                // 筛选 会员姓名
                query.where(cb.equal(root.get("name"), params.getQuery().toString()));
            }

            return null;
        };
        Pageable pageable = new PageRequest(params.getPage() - 1, params.getSize());
        Page<User> pageResult = repository.findAll( pageable);

        // 返回分页数据
        return new PageResultDTO(pageResult.getTotalElements(), pageResult.getContent());
    }

    @GetMapping("remove/{id}")
    public ExecuteDTO remove(@PathVariable Long id) {
        repository.delete(id);
        return new ExecuteDTO(true, "删除成功", id);
    }

}