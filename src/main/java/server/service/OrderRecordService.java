package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.OrderRecordMapper;

@Service
public class OrderRecordService {

    @Autowired
    private OrderRecordMapper orderRecordMapper;

    public Integer selectRevenueByNPreviousDay(Integer numDay) {
        return orderRecordMapper.selectRevenueByNPreviousDay(numDay);
    }

    public Integer selectRevenueByNPreviousMonth(Integer numMonth) {
        return orderRecordMapper.selectRevenueByNPreviousMonth(numMonth);
    }

    public Integer selectRevenueByNPreviousQuarter(Integer numQuarter) {
        return orderRecordMapper.selectRevenueByNPreviousQuarter(numQuarter);
    }

    public Integer selectRevenueByNPreviousYear(Integer numYear) {
        return orderRecordMapper.selectRevenueByNPreviousYear(numYear);
    }
}
