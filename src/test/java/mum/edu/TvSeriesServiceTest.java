/*
 * Created on Dec 9, 2017
 */
package mum.edu;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mum.edu.services.impl.TvSeriesServiceImpl;

public class TvSeriesServiceTest {

    public TvSeriesServiceTest() {
        // TODO Auto-generated constructor stub
    }
    
    @Test
    public void testAddSeries() { //seriesService
        ApplicationContext context = new ClassPathXmlApplicationContext("DispatcherServlet-context-test.xml");
        TvSeriesServiceImpl seriesService = context.getBean("seriesService",TvSeriesServiceImpl.class);
        System.out.println("success");
    }

}
