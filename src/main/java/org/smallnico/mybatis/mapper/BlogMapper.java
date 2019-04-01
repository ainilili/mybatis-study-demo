package org.smallnico.mybatis.mapper;

import org.smallnico.mybatis.domain.Blog;

public interface BlogMapper {

    //mybatis支持注解和xml两种配置方式
    //@Select("select * from blog where id = #{id}")
    Blog selectBlog(String id);
}
