package org.smallnico.mybatis.builder;

import java.io.IOException;
import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.smallnico.mybatis.mapper.BlogMapper;

import com.alibaba.druid.pool.DruidDataSource;

public class SessionFactoryCodeBuilder extends AbstractSessionFactoryBuilder{

    @Override
    public SqlSessionFactory builder() throws IOException {
        DataSource dataSource = getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        loader("mybatis-mappers/BlogMapper.xml", configuration);
        
        return new SqlSessionFactoryBuilder().build(configuration);
    }
    
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:h2:mem:testdb;MODE=MYSQL;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setMaxActive(10);
        dataSource.setInitialSize(2);
        dataSource.setMaxWait(6000 * 1000);
        dataSource.setMinIdle(5);
        return dataSource;
    }
    
    public void loader(String uri, Configuration configuration) throws IOException {
        InputStream mapperStream = Resources.getResourceAsStream(uri);
        XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(mapperStream, configuration,
                mapperStream.toString(), configuration.getSqlFragments());
        xmlMapperBuilder.parse();
    }

}
