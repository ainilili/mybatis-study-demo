package org.smallnico.mybatis.mapper;

import org.apache.ibatis.annotations.Select;
import org.smallnico.mybatis.domain.Blog;

public interface BlogMapper {

    Blog selectBlog(String id);
}
