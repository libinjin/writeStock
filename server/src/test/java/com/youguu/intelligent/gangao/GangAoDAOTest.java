package com.youguu.intelligent.gangao;

import com.youguu.intelligent.base.BaseTestClass;
import com.youguu.intelligent.dao.FirstDao;
import com.youguu.intelligent.dao.FiveDao;
import com.youguu.intelligent.dao.FourDao;
import com.youguu.intelligent.dao.SecondDao;
import com.youguu.intelligent.dao.SixDao;
import com.youguu.intelligent.dao.ThirdDao;
import com.youguu.intelligent.moudle.gangao.GangAoDAO;
import com.youguu.intelligent.pojo.First;
import com.youguu.intelligent.pojo.Fiveth;
import com.youguu.intelligent.pojo.Fourth;
import com.youguu.intelligent.pojo.Second;
import com.youguu.intelligent.pojo.Sixth;
import com.youguu.intelligent.pojo.StkBasicinfo;
import com.youguu.intelligent.pojo.Third;
import com.youguu.intelligent.sevice.TotalService;
import org.junit.Test;

import java.util.List;

public class GangAoDAOTest extends BaseTestClass {


    GangAoDAO gangAoDAO = (GangAoDAO) getInstance("gangAoDAO");

    FirstDao firstDao = (FirstDao) getInstance("firstDao");

    SecondDao secondDao = (SecondDao) getInstance("secondDao");

    ThirdDao thirdDao = (ThirdDao) getInstance("thirdDao");

    FourDao fourDao = (FourDao) getInstance("fourDao");

    FiveDao fiveDao = (FiveDao) getInstance("fiveDao");

    SixDao sixDao = (SixDao) getInstance("sixDao");

    TotalService totalService = (TotalService) getInstance("totalService");


    @Test
    public void selectAll(){

        List<StkBasicinfo> stkBasicinfos = gangAoDAO.selectAll();

        System.out.println(stkBasicinfos);//selectStockByCode
    }


    @Test
    public void querFirstList(){

        long start = System.currentTimeMillis();

        //List<Integer> comCodeList = gangAoDAO.selectStocInner();


        String endDate = "2016-03-31 00:00:00";

        int ReportType = 1;

        List<First> firstList = firstDao.querFirstList(endDate, ReportType);

        System.out.println(firstList.size());

        querySecond();

        queryThird();

        queryfourDao();

        queryfiveths();

        querySix();

        long end = System.currentTimeMillis();

        System.out.println((end-start)+"ms");
    }


    @Test
    public void querySecond(){

        String endDate = "2016-03-31 00:00:00";

        int reportType = 1;

        List<Second> seconds = secondDao.querSecondList(endDate, reportType);

        System.out.println(seconds.size());
    }

    @Test
    public void queryThird(){

        String endDate = "2017-03-31 00:00:00";

        int reportType = 1;

        List<Third> thirds = thirdDao.queryThird(endDate, reportType);

        System.out.println(thirds.size());
    }

    @Test
    public void queryfourDao(){

        String endDate = "2017-03-31 00:00:00";

        int reportType = 1;

        List<Fourth> fourths = fourDao.queryFour(endDate, reportType);

        System.out.println(fourths.size());
    }

    @Test
    public void queryfiveths(){

        String endDate = "2017-03-31 00:00:00";

        int reportType = 1;

        List<Fiveth> fiveths = fiveDao.queryFive(endDate, reportType);

        System.out.println(fiveths.size());
    }

    @Test
    public void querySix(){

        String endDate = "2016-03-31 00:00:00";

        int reportType = 1;

        List<Sixth> sixths = sixDao.querySix(endDate, reportType);

        System.out.println(sixths.size());
    }

    @Test
    public void putTogether(){

        String endDate = "2016-03-31 00:00:00";

        int reportType = 1;

        totalService.putTogether(endDate, reportType);
    }
}
