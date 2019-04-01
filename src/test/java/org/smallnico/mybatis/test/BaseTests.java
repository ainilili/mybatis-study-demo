package org.smallnico.mybatis.test;

import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.smallnico.mybatis.builder.AbstractSessionFactoryBuilder;
import org.smallnico.mybatis.builder.SessionFactoryXMLBuilder;

public class BaseTests {

//    protected AbstractSessionFactoryBuilder sessionFactoryBuilder = new SessionFactoryCodeBuilder();
    protected AbstractSessionFactoryBuilder sessionFactoryBuilder = new SessionFactoryXMLBuilder();

    protected SqlSession getSqlSession() throws Exception {
        return sessionFactoryBuilder.builder().openSession();
    }

    @Before
    public void init() throws Exception {
        String schemaSql = getClass().getResource("/db/schema.sql").toURI().toString();
        String dataSql = getClass().getResource("/db/data.sql").toURI().toString();

        SqlSession session = getSqlSession();
        Statement st = session.getConnection().createStatement();
        try {
            st.execute("runscript from '"+schemaSql+"'");
            st.execute("runscript from '"+dataSql+"'");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(session != null) session.close();
        }
    }
}
