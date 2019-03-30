package org.smallnico.mybatis.mapper;

import org.smallnico.mybatis.domain.Blog;

public interface BlogMapper {

    Blog selectBlog(String id);
}
