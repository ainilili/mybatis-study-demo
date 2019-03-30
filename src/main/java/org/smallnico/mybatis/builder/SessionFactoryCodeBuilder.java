package org.smallnico.mybatis.builder;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.smallnico.mybatis.mapper.BlogMapper;

import com.mysql.cj.jdbc.MysqlDataSource;

public class SessionFactoryCodeBuilder extends AbstractSessionFactoryBuilder{

    @Override
    public SqlSessionFactory builder() throws IOException {
        DataSource dataSource = getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }
    
    public DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:h2:mem:testdb;MODE=MYSQL;DB_CLOSE_DELAY=-1");
        dataSource.setUser("sa");
        dataSource.setPassword("");
        return dataSource;
    }

}
