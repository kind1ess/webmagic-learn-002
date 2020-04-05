package cn.itcast.job.service.impl;

import cn.itcast.job.DatabaseConnection;
import cn.itcast.job.dao.JobInfoDao;
import cn.itcast.job.pojo.JobInfo;
import cn.itcast.job.service.JobInfoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobInfoServiceImp implements JobInfoService {

    private JobInfoDao jobInfoDao = null;
    private DatabaseConnection databaseConnection = null;
    @Override
    public void save(JobInfo jobInfo) {
        try {
            databaseConnection = new DatabaseConnection();
            jobInfoDao = new JobInfoDao(databaseConnection.getConnection());
            jobInfoDao.save(jobInfo);
            DatabaseConnection.close(databaseConnection.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<JobInfo> findJobInfo(JobInfo jobInfo) {
        return null;
    }

    @Override
    public Page<JobInfo> findJobInfoByPage(int page, int rows) {
        return null;
    }
}
