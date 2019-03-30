package org.smallnico.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.smallnico.mybatis.domain.Blog;
import org.smallnico.mybatis.mapper.BlogMapper;

public class SimpleTests extends BaseTests{

    @Test
    public void testSelect() throws Exception {
        SqlSession session = getSqlSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog("1");
            System.out.println(blog);
        } finally {
            session.close();
        }

    }
    
}
