package org.smallnico.mybatis.builder;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactoryXMLBuilder extends AbstractSessionFactoryBuilder{

    @Override
    public SqlSessionFactory builder() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(inputStream);     
    }

}
