package com.creative.Impl;

import com.creative.DAO.UserDAO;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by jisabw1 on 6/1/2016.
 */
public class UserDAOImpl extends UserDAO {
    private Map<String, String> queries;
    private DataSource dataSource;

    private FindAllUsersQuery findAllUsersQuery;

    public void init() {
        this.findAllUsersQuery = new FindAllUsersQuery(dataSource);
    }

    public void setQueries(Map<String, String> queries) {
        this.queries = queries;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> findAllUsers() {
        return (List<String>)this.findAllUsersQuery.execute();
    }

    private class FindAllUsersQuery extends MappingSqlQuery {

        FindAllUsersQuery(DataSource ds) {
            super(ds, UserDAOImpl.this.queries.get("FIND_ALL_USERS"));
            compileInternal();
        }

        protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getString(1).trim();
        }
    }
}
