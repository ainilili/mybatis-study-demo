package org.smallnico.mybatis.builder;

import org.apache.ibatis.session.SqlSessionFactory;

public abstract class AbstractSessionFactoryBuilder {

    public abstract SqlSessionFactory builder() throws Exception;
}
