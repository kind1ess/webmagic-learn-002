package cn.itcast.job.dao;


import cn.itcast.job.DatabaseConnection;
import cn.itcast.job.pojo.JobInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobInfoDao{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public JobInfoDao(Connection connection){
        this.connection = connection;
    }

    public void save(JobInfo jobInfo) throws SQLException {
        if (isExist(jobInfo)) {
            String sql = "INSERT INTO jobinfo3(company_name,company_addr,company_info,job_name,job_addr,job_info," +
                    "salary_min,salary_max,url,time) values(?,?,?,?,?,?,?,?,?,?)";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,jobInfo.getCompanyName());
                preparedStatement.setString(2,jobInfo.getCompanyAddr());
                preparedStatement.setString(3,jobInfo.getCompanyInfo());
                preparedStatement.setString(4,jobInfo.getJobName());
                preparedStatement.setString(5,jobInfo.getJobAddr());
                preparedStatement.setString(6,jobInfo.getJobInfo());
                preparedStatement.setInt(7,jobInfo.getSalaryMin());
                preparedStatement.setInt(8,jobInfo.getSalaryMax());
                preparedStatement.setString(9,jobInfo.getUrl());
                preparedStatement.setString(10,jobInfo.getTime());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw e;
            }
            DatabaseConnection.close(connection);
            DatabaseConnection.close(preparedStatement);
        }
        else{
            System.out.println("招聘信息已存在！");
        }
    }

    public boolean isExist(JobInfo jobInfo){
        String sql = "select * from jobinfo3 where url=?";
        boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,jobInfo.getUrl());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
